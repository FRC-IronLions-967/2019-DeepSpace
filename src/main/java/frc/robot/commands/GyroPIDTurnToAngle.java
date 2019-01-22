package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class GyroPIDTurnToAngle extends Command {
  double angle;
  public GyroPIDTurnToAngle(double Angle) {
    requires(Robot.driveSubsystem);
    angle = Angle;
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveSubsystem.pidSetPoint(angle);
    Robot.driveSubsystem.pidSetState("Enable");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.driveSubsystem.move(Robot.driveSubsystem.PIDOutput, -Robot.driveSubsystem.PIDOutput);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.driveSubsystem.pidDone();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    Robot.driveSubsystem.pidSetState("Disable");
  }
}
