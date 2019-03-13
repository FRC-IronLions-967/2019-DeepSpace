package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTableInstance;

public class limelightGetToTarget extends Command {
  private boolean m_limelightHasValidTarget = false;
  private double m_limelightDriveCommand = 0.0;
  private double m_limelightSteerCommand = 0.0;

  private boolean m_isPlaced = false;
  private boolean m_isDepo = false;

  public limelightGetToTarget(boolean isDepo) {
    this.m_isDepo = isDepo;
    requires(Robot.m_driveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Update_Limelight_Tracking();

    if (m_limelightHasValidTarget) {
      Robot.m_driveSubsystem.arcadeDrive(-m_limelightDriveCommand ,m_limelightSteerCommand);
    } else {
      Robot.m_driveSubsystem.arcadeDrive(0.0, 0.0);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if (!m_limelightHasValidTarget) {
      return true;
    } else if (m_isPlaced) {
      return true;
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_driveSubsystem.arcadeDrive(0.0, 0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.m_driveSubsystem.arcadeDrive(0.0, 0.0);
  }

  public void Update_Limelight_Tracking()
  {

        double STEER_K;                    // how hard to turn toward the target
        double DRIVE_K;                // how hard to drive fwd toward the target
        double DESIRED_TARGET_AREA;       // Area of the target when the robot reaches the wall
        double MAX_DRIVE ;                    // Simple speed limit so we don't drive too fast
        

      if (m_isDepo) { // really the depositing 
        STEER_K = 0.058;                    // how hard to turn toward the target
        DRIVE_K = 0.024;                    // how hard to drive fwd toward the target
        DESIRED_TARGET_AREA = 32.5;       // Area of the target when the robot reaches the wall
        MAX_DRIVE = 1;                    // Simple speed limit so we don't drive too fast
        
      } else { // these are ok for now 
        STEER_K = 0.058;                    // how hard to turn toward the target
        DRIVE_K = 0.024;                    // how hard to drive fwd toward the target
        DESIRED_TARGET_AREA = 29;       // Area of the target when the robot reaches the wall
        MAX_DRIVE = 1;                    // Simple speed limit so we don't drive too fast
        
      }

        double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
        double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
        // double ty = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
        double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);

        if (tv < 1.0)
        {
          m_limelightHasValidTarget = false;
          m_limelightDriveCommand = 0.0;
          m_limelightSteerCommand = 0.0;
          return;
        }

        m_limelightHasValidTarget = true;


        
        // Start with proportional steering
        double steer_cmd = tx * STEER_K;
        m_limelightSteerCommand = steer_cmd;

        // try to drive forward until the target area reaches our desired area
        double drive_cmd = (DESIRED_TARGET_AREA - ta) * DRIVE_K;

        if (drive_cmd < .5) {
          if (m_isDepo) {
            // Robot.m_hatchPanelSubsystem.grabberOpen();
          } else {
            // Robot.m_hatchPanelSubsystem.grabberClose();
          }
          m_isPlaced = true;
        } else {
          m_isPlaced = false;
        }

        // don't let the robot drive too fast into the goal
        if (drive_cmd > MAX_DRIVE)
        {
          drive_cmd = MAX_DRIVE;
        }
        m_limelightDriveCommand = drive_cmd;

  }
}
