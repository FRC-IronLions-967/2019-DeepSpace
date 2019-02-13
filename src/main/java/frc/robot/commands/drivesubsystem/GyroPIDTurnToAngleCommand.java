package frc.robot.commands.drivesubsystem;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class GyroPIDTurnToAngleCommand extends Command {
  double angle;

  public GyroPIDTurnToAngleCommand(double Angle) {
    requires(Robot.m_driveSubsystem);
    angle = Angle;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.m_driveSubsystem.pidSetPoint(angle);
    Robot.m_driveSubsystem.enablePid();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_driveSubsystem.move(Robot.m_driveSubsystem.PIDOutput, -Robot.m_driveSubsystem.PIDOutput);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.m_driveSubsystem.pidDone();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.m_driveSubsystem.disablePid();
  }
}
