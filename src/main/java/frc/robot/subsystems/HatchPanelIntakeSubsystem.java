package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * HatchPanelSubsystem is the subsystem for manipulating the hatch panel when it is in the robot
 * This includes taking in the panel and scoring the panel
 */
public class HatchPanelIntakeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private DoubleSolenoid grabber;

  // Constructor 
  public HatchPanelIntakeSubsystem() {
    grabber = new DoubleSolenoid(1, 7, 0);
  }


  /** 
   * Put code here for when a varble needs reset when the robot get 
   * disabled or something similar
   */
  public void disabledInit() {

  }

  public void grabberOpen() {
    grabber.set(DoubleSolenoid.Value.kForward);
  }

  public void grabberClose() {
    grabber.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {
    
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}

