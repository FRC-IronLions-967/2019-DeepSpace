package frc.lib.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;

public class POVButton extends Button {
	Joystick joy;
	int POV;
	int Direction;
	
	public POVButton(Joystick stick, int pov, int direction){
		joy = stick;
		POV = pov;
		Direction = direction;
	}
	public boolean get(){
		if(joy.getPOV(POV) == Direction){
			return true;
		}
		else {
			return false;
		}
	}
}