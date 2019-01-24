package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is the place for all navagation code to go 
 */
public class NavagationSubsystem extends Subsystem {
  private static final String SPI = null;
  public  AHRS gyro;

  public NavagationSubsystem() {

    try {
			gyro = new AHRS(SPI.Port.kMXP);
		} catch(RuntimeException ex) {
			DriverStation.reportError("Error instantiating navX MXP: " + ex.getMessage(), true);
		}

		gyro.zeroYaw();

  }

  public boolean resetYaw() {
	  gyro.zeroYaw();
	  return true;
  }
  
  public double getYaw() {
	  return gyro.getYaw();
  }



  public void disabledinit() {

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
