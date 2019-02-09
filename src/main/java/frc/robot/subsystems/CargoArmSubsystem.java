package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.lib.util.Utils;
import frc.robot.Robot;
import frc.robot.commands.*;

/**
 * CargoSubsystem is the subsystem for controlling the Cargo while it is in the robot 
 * That includes taking in the cargo and despensing the cargo
 */
public class CargoSubsystem extends Subsystem {
  private TalonSRX left_side;
  private TalonSRX right_side;
  // private TalonSRX intake_roller;

  public CargoSubsystem() {
    left_side = new TalonSRX(Robot.m_robotMapProperties.getLeftSide());
    right_side = new TalonSRX(Robot.m_robotMapProperties.getRightSide());
    // intake_roller = new TalonSRX(Robot.m_robotMapProperties.getIntakeRoller());

    left_side.setInverted(true);
  }
  
  // public void moveBall(double power) {
  //   power = Utils.Deadband(power, 0.1);
  //   intake_roller.set(ControlMode.PercentOutput, power);
  // }

  public void moveArm(double power) {
    power = Utils.Deadband(power, 0.05);
    left_side.set(ControlMode.PercentOutput, power);
    right_side.set(ControlMode.PercentOutput, power);
  }
  /** 
   * Put code here for when a varble needs reset when the robot get 
   * disabled or something similar
   */
  public void disabledInit() {
      
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new MoveArm());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
