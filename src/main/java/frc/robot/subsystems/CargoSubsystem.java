package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.lib.util.Utils;
import frc.robot.Robot;
/**
 * CargoSubsystem is the subsystem for controlling the Cargo while it is in the robot 
 * That includes taking in the cargo and despensing the cargo
 */
public class CargoSubsystem extends Subsystem {
  private TalonSRX leftArm;
  private TalonSRX rightArm;
  // private TalonSRX intake_roller;

  public CargoSubsystem() {
    leftArm= new TalonSRX(Robot.m_robotMapProperties.getLeftSide());
    rightArm = new TalonSRX(Robot.m_robotMapProperties.getRightSide());

    leftArm.setInverted(true);
    rightArm.setInverted(false);
    // intake_roller = new TalonSRX(Robot.m_robotMapProperties.getIntakeRoller());

    
  }
  
  // public void moveBall(double power) {
  //   power = Utils.Deadband(power, 0.1);
  //   intake_roller.set(ControlMode.PercentOutput, power);
  // }

  public void moveArm(double power) {
    power = Utils.Deadband(power, 0.1);
    leftArm.set(ControlMode.PercentOutput, power);
    rightArm.set(ControlMode.PercentOutput, power);
    Robot.logger.log(Double.toString(power));
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
