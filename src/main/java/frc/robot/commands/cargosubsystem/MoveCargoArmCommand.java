package frc.robot.commands.cargosubsystem;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class MoveCargoArmCommand extends Command {
  private double power;

  public MoveCargoArmCommand(double Power) {
    requires(Robot.m_cargoSubsystem);
    power = Power;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.m_cargoSubsystem.moveArm(power);
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
