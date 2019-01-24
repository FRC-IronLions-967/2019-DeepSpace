package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * HatchPanelSubsystem is the subsystem for manipulating the hatch panel when it is in the robot
 * This includes taking in the panel and scoring the panel
 */
public class HatchPanelSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.


  // Constructor 
  public HatchPanelSubsystem() {
    
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
