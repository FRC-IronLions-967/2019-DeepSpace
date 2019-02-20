package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.lib.util.Utils;
import frc.robot.Robot;
import frc.robot.commands.cargosubsystem.MoveBallCommand;

/**
 * Add your docs here.
 */
public class IntakeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public VictorSPX intake_roller;

  public IntakeSubsystem() {
    intake_roller = new VictorSPX(Robot.m_robotMapProperties.getIntakeRoller());
  }

  public void moveBall(double power) {
    power = Utils.Deadband(power, 0.1);
    if (power >= 0) {
      power = -power * power;
    } else {
      power = power * power;
    }
    intake_roller.set(ControlMode.PercentOutput, power);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveBallCommand());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
