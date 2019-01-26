/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.lib.oi.POVButton;
import frc.robot.commands.GyroPIDChangeState;
import frc.robot.commands.GyroPIDTurnToAngle;
import frc.robot.commands.ResetYaw;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
  public Joystick xbox0 = new Joystick(0);
  public Joystick xbox1 = new Joystick(1);

  public POVButton xbox0povC 	= new POVButton(xbox0, 0, -1);
  public POVButton xbox0povN 	= new POVButton(xbox0, 0, 0);
  public POVButton xbox0povNE = new POVButton(xbox0, 0, 45);
  public POVButton xbox0povE 	= new POVButton(xbox0, 0, 90);
  public POVButton xbox0povSE = new POVButton(xbox0, 0, 135);
  public POVButton xbox0povS 	= new POVButton(xbox0, 0, 180);
  public POVButton xbox0povSW = new POVButton(xbox0, 0, 225);
  public POVButton xbox0povW 	= new POVButton(xbox0, 0, 270);
  public POVButton xbox0povNW = new POVButton(xbox0, 0, 315);

  public POVButton xbox1povC 	= new POVButton(xbox1, 0, -1);
  public POVButton xbox1povN 	= new POVButton(xbox1, 0, 0);
  public POVButton xbox1povNE = new POVButton(xbox1, 0, 45);
  public POVButton xbox1povE 	= new POVButton(xbox1, 0, 90);
  public POVButton xbox1povSE = new POVButton(xbox1, 0, 135);
  public POVButton xbox1povS 	= new POVButton(xbox1, 0, 180);
  public POVButton xbox1povSW = new POVButton(xbox1, 0, 225);
  public POVButton xbox1povW 	= new POVButton(xbox1, 0, 270);
  public POVButton xbox1povNW = new POVButton(xbox1, 0, 315);

  public OI() {
    
    JoystickButton xbox0_a = new JoystickButton(xbox0, 1);
    JoystickButton xbox0_b = new JoystickButton(xbox0, 2);
    // JoystickButton xbox0_x = new JoystickButton(xbox0, 3);
    // JoystickButton xbox0_y = new JoystickButton(xbox0, 4);
    // JoystickButton xbox0_lb = new JoystickButton(xbox0, 5);
    // JoystickButton xbox0_rb = new JoystickButton(xbox0, 6);
    // JoystickButton xbox0_back = new JoystickButton(xbox0, 7);
    // JoystickButton xbox0_start = new JoystickButton(xbox0, 8);
    // JoystickButton xbox0_leftStickButton = new JoystickButton(xbox0, 9);
    // JoystickButton xbox0_rightStickButton = new JoystickButton(xbox0, 10);

    // JoystickButton xbox1_a = new JoystickButton(xbox1, 1);
    // JoystickButton xbox1_b = new JoystickButton(xbox1, 2);
    // JoystickButton xbox1_x = new JoystickButton(xbox1, 3);
    // JoystickButton xbox1_y = new JoystickButton(xbox1, 4);
    // JoystickButton xbox1_lb = new JoystickButton(xbox1, 5);
    // JoystickButton xbox1_rb = new JoystickButton(xbox1, 6);
    // JoystickButton xbox1_back = new JoystickButton(xbox1, 7);
    // JoystickButton xbox1_start = new JoystickButton(xbox1, 8);
    // JoystickButton xbox1_leftStickButton = new JoystickButton(xbox1, 9);
    // JoystickButton xbox1_rightStickButton = new JoystickButton(xbox1, 10);

    xbox0povN.whenPressed(new GyroPIDTurnToAngle(0));
    // xbox0povNE.whenPressed(new ExampleCommand());
    xbox0povE.whenPressed(new GyroPIDTurnToAngle(90));
    // xbox0povSE.whenPressed(new ExampleCommand());
    xbox0povS.whenPressed(new GyroPIDTurnToAngle(180));
    // xbox0povSW.whenPressed(new ExampleCommand());
    xbox0povW.whenPressed(new GyroPIDTurnToAngle(-90));
    // xbox0povNW.whenPressed(new ExampleCommand());
    // xbox0_lT.whenPressed(new ExampleCommand());
    // xbox0_rT.whenPressed(new ExampleCommand());
    xbox0_a.whenPressed(new GyroPIDChangeState("Disable"));
    xbox0_b.whenPressed(new ResetYaw());
    // xbox0_x.whenPressed(new ExampleCommand());
    // xbox0_y.whenPressed(new ExampleCommand());
    // xbox0_lb.whenPressed(new ExampleCommand());
    // xbox0_rb.whenPressed(new ExampleCommand());
    // xbox0_back.whenPressed(new ExampleCommand());
    // xbox0_start.whenPressed(new ExampleCommand());
    // xbox0_leftStickButton.whenPressed(new ExampleCommand());
    // xbox0_rightStickButton.whenPressed(new ExampleCommand());
  
    // xbox1povN.whenPressed(new ExampleCommand());
    // xbox1povNE.whenPressed(new ExampleCommand());
    // xbox1povE.whenPressed(new ExampleCommand());
    // xbox1povSE.whenPressed(new ExampleCommand());
    // xbox1povS.whenPressed(new ExampleCommand());
    // xbox1povSW.whenPressed(new ExampleCommand());
    // xbox1povW.whenPressed(new ExampleCommand());
    // xbox1povNW.whenPressed(new ExampleCommand());
    // xbox1_lT.whenPressed(new ExampleCommand());
    // xbox1_rT.whenPressed(new ExampleCommand());
    // xbox1_a.whenPressed(new ExampleCommand());
    // xbox1_b.whenPressed(new ExampleCommand());
    // xbox1_x.whenPressed(new ExampleCommand());
    // xbox1_y.whenPressed(new ExampleCommand());
    // xbox1_lb.whenPressed(new ExampleCommand());
    // xbox1_rb.whenPressed(new ExampleCommand());
    // xbox1_back.whenPressed(new ExampleCommand());
    // xbox1_start.whenPressed(new ExampleCommand());
    // xbox1_leftStickButton.whenPressed(new ExampleCommand());
    // xbox1_rightStickButton.whenPressed(new ExampleCommand());
   

  }

  public Joystick getXbox0() {
    return xbox0;
  }

  public Joystick getXbox1() {
    return xbox1;
  }

}
