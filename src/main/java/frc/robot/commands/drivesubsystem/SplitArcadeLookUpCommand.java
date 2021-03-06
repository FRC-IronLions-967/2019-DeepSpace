package frc.robot.commands.drivesubsystem;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SplitArcadeLookUpCommand extends Command {
  public SplitArcadeLookUpCommand() {
    requires(Robot.m_driveSubsystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_driveSubsystem.arcadeDriveLookup(Robot.m_oi.xbox0.getRawAxis(1), Robot.m_oi.xbox0.getRawAxis(4));
    // System.out.println(Robot.m_oi.xbox0.getRawAxis(1));
    // System.out.println(Robot.m_oi.xbox0.getRawAxis(4));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
