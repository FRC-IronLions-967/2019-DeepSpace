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

  private double[] distanceLookUp = new double[] {   0, .043, .076, .109, .142, .175, .208, .241, .274, .307,
                                                   .34, .373, .406, .439, .472, .505, .538, .571, .604, .637,
                                                   .7, .7, .7, .7, .7, .7, .7, .7, .7, .7,
                                                  //  .67, .703, .736, .769, .802, .835, .868, .901, .934, .967,
                                                   .8, .8, .8, .8, .8, .8, .8, .8, .8, .8,
                                                   .8, .8, .8, .8, .8, .8, .8, .8, .8, .8,
                                                   .8, .8, .8, .8, .8, .8, .8, .8, .8, .8,
                                                   .8, .8, .8, .8, .8, .8, .8, .8, .8, .8,
                                                   .8, .8, .8, .8, .8, .8, .8, .8, .8, .8,
                                                   .8, .8, .8, .8, .8, .8, .8, .8, .8, .8,
                                                   .8, .8, .8, .8, .8, .8, .8, .8, .8, .8};
  
    public limelightGetToTarget(boolean isDepo) {
    this.m_isDepo = isDepo;
    requires(Robot.m_driveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Update_Limelight_Tracking();

    if (m_limelightHasValidTarget) {
      Robot.m_driveSubsystem.arcadeDrive(-m_limelightDriveCommand
      ,m_limelightSteerCommand);
      // Robot.m_driveSubsystem.arcadeDrive(-m_limelightDriveCommand, 0);
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
    // NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.m_driveSubsystem.arcadeDrive(0.0, 0.0);
    // NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);
  }

  public void Update_Limelight_Tracking() {

    double STEER_K = .0365; //.039; // how hard to turn toward the target
 
    double tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    double tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    // double ty =
    // NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0);
    double ta = NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0);

    if (tv < 1.0) {
      m_limelightHasValidTarget = false;
      m_limelightDriveCommand = 0.0;
      m_limelightSteerCommand = 0.0;
      return;
    }

    m_limelightHasValidTarget = true;

    // calculating how to turn to the target
    double steer_cmd;
    steer_cmd = tx * STEER_K;
    m_limelightSteerCommand = steer_cmd;

    double distanceToTarget = (6.1 * (1 / (Math.sqrt(ta))) - .89);

    double distacex10 = (distanceToTarget *10);

    if (distacex10 < 0) {
      distacex10 = 0;
    } else if (distacex10 > 100) {
      distacex10 = 99;
    }

    double drive_cmd = distanceLookUp[(int) distacex10];
  


    // if (drive_cmd < .5) {
    //   if (m_isDepo) {
    //     // Robot.m_hatchPanelSubsystem.grabberOpen();
    //   } else {
    //     Robot.m_hatchPanelSubsystem.grabberClose();
    //   }
    //   m_isPlaced = true;
    // } else {
    //   m_isPlaced = false;
    // }
    m_limelightDriveCommand = drive_cmd;
    // }
  }

}