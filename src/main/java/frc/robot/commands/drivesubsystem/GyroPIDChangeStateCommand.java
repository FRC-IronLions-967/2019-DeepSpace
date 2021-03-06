package frc.robot.commands.drivesubsystem;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class GyroPIDChangeStateCommand extends Command {
  String state;

  public GyroPIDChangeStateCommand(String State) {
    requires(Robot.m_driveSubsystem);
    state = State;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if (state.equalsIgnoreCase("true")) {
      Robot.m_driveSubsystem.enablePid();
    } else if (state.equalsIgnoreCase("false")) {
      Robot.m_driveSubsystem.disablePid();
    }
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
