package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * CargoSubsystem is the subsystem for controlling the Cargo while it is in the robot 
 * That includes taking in the cargo and despensing the cargo
 */
public class CargoSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  // Constructor
  public CargoSubsystem() {

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
