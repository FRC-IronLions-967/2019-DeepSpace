package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.lib.util.Utils;
import frc.robot.Robot;
/**
 * CargoSubsystem is the subsystem for controlling the Cargo while it is in the robot 
 * That includes taking in the cargo and despensing the cargo
 */
public class CargoSubsystem extends Subsystem {
  public TalonSRX leftArm;
  public TalonSRX rightArm;

  public DigitalInput limitSwitchBottom;

  public CargoSubsystem() {
    leftArm = new TalonSRX(Robot.m_robotMapProperties.getLeftSide());
    rightArm = new TalonSRX(Robot.m_robotMapProperties.getRightSide());

    limitSwitchBottom = new DigitalInput(9);
    
  }

  public void moveArm(double power) {
    power = Utils.Deadband(power, 0.1);
    // if (!isBottom()) {
      leftArm.set(ControlMode.PercentOutput, power);
      rightArm.set(ControlMode.PercentOutput, power);
    // } else {
    //   power = Math.abs(power);
    //   leftArm.set(ControlMode.PercentOutput, power);
    //   rightArm.set(ControlMode.PercentOutput, power);
    // }
  }


  /** 
   * Put code here for when a varble needs reset when the robot get 
   * disabled or something similar
   */
  public void disabledInit() {
      
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
