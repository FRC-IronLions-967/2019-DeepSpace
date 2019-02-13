package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.lib.util.Utils;
import frc.robot.Robot;
import frc.robot.commands.cargosubsystem.MoveBallCommand;


/**
 * CargoSubsystem is the subsystem for controlling the Cargo while it is in the
 * robot That includes taking in the cargo and despensing the cargo
 */
public class CargoSubsystem extends Subsystem {
  public TalonSRX leftArm;
  public TalonSRX rightArm;

  public TalonSRX intake_roller;


  public DigitalInput limitSwitchBottom;

  public CargoSubsystem() {
    leftArm = new TalonSRX(Robot.m_robotMapProperties.getLeftSide());
    rightArm = new TalonSRX(Robot.m_robotMapProperties.getRightSide());

    intake_roller = new TalonSRX(Robot.m_robotMapProperties.getIntakeRoller());


    limitSwitchBottom = new DigitalInput(9);

  }

  
  public void moveBall(double power) {
    power = Utils.Deadband(power, 0.1);
    intake_roller.set(ControlMode.PercentOutput, power);
  }


  public void moveArm(double power) {
    power = Utils.Deadband(power, 0.1);
    // if (!isBottom()) {
    leftArm.set(ControlMode.PercentOutput, power);
    rightArm.set(ControlMode.PercentOutput, power);
    // } else {
    // power = Math.abs(power);
    // leftArm.set(ControlMode.PercentOutput, power);
    // rightArm.set(ControlMode.PercentOutput, power);
    // }
  }

  /**
   * Put code here for when a varble needs reset when the robot get disabled or
   * something similar
   */
  public void disabledInit() {

  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveBallCommand());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
