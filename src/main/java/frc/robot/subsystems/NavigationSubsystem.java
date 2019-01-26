package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * This is the place for all navigation code to go 
 */
public class NavigationSubsystem extends Subsystem {
  public AHRS gyro;
  public Encoder rightEncoder;
  public Encoder leftEncoder;

  public NavigationSubsystem() {
    rightEncoder = new Encoder(0, 1, true);
    rightEncoder.setDistancePerPulse(25.1327);
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

  public double getVelocityX() {
    System.out.println(gyro.getVelocityX());
    return gyro.getVelocityX();
  }

  public double getVelocityY() {
    return gyro.getVelocityY();
  }
  
  public double getVelocityZ() {
    return gyro.getVelocityZ();  
  }

  public void disabledinit() {

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
