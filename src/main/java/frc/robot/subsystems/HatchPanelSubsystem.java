package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * HatchPanelSubsystem is the subsystem for manipulating the hatch panel when it
 * is in the robot This includes taking in the panel and scoring the panel
 */
public class HatchPanelSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private DoubleSolenoid grabber;
  private DoubleSolenoid arm;

  // Constructor
  public HatchPanelSubsystem() {
    grabber = new DoubleSolenoid(0, 4, 3);
    arm = new DoubleSolenoid(0, 5, 2);
  }

  /**
   * Put code here for when a varble needs reset when the robot get disabled or
   * something similar
   */
  public void disabledInit() {

  }

  public void grabberOpen() {
    grabber.set(DoubleSolenoid.Value.kForward);
  }

  public void grabberClose() {
    grabber.set(DoubleSolenoid.Value.kReverse);
  }

  public void armUp() {
    arm.set(DoubleSolenoid.Value.kForward);
  }

  public void armDown() {
    arm.set(DoubleSolenoid.Value.kReverse);
  }

  @Override
  public void initDefaultCommand() {

    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
