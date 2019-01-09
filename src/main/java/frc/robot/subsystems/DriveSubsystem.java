/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constraints;

/**
 * Add your docs here.
 */
public class DriveSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands
  public DriveSubsystem() {
    
  }

  public void tankDrive(double leftPower, double rightPower) {
    leftPower = Deadband(leftPower);
    rightPower = Deadband(rightPower);

    leftPower = leftPower*Math.abs(leftPower);
    rightPower = rightPower*Math.abs(rightPower);

    move(leftPower, rightPower);
  }

  public double Deadband(double input) {
    // upper deadband
    if(input >= +Constraints.DriveSubsystem_deadband) {
      return input;
    } 
    // lower deadband
    else if(input <= -Constraints.DriveSubsystem_deadband) {
      return input;
    }
    // outside deadband
    return 0;
  }

  public void move(double leftPower, double rightPower) {
    System.out.println("Drive Powers(L,R): " + Double.toString(leftPower) + " : " + Double.toString(rightPower));
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
