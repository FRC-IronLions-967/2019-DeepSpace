package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

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
    try {
    grabber = new DoubleSolenoid(Robot.m_robotMapProperties.getPcm(), Robot.m_robotMapProperties.getHatchPanelGrabberForward(), Robot.m_robotMapProperties.getHatchPanelGrabberReverse());
    arm = new DoubleSolenoid(Robot.m_robotMapProperties.getPcm(), Robot.m_robotMapProperties.getHatchPanelArmForward(), Robot.m_robotMapProperties.getHatchPanelArmReverse());
    } catch(Exception e) {
      System.out.println("Unable to created DoubleSolenoid");
    }
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
