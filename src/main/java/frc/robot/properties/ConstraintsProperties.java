package frc.robot.properties;

import java.util.Properties;

import edu.wpi.first.wpilibj.DriverStation;

import java.io.InputStream;
import java.io.FileInputStream;

/**
 * Add your docs here.
 */

public class ConstraintsProperties {
    private double deadband;
    private double kP;
    private double kI;
    private double kD;
    private double PIDTolerance;

    Properties properties = new Properties();
    InputStream input = null;

    public ConstraintsProperties(String path) {
        try {
            input = new FileInputStream(path);
            properties.load(input);
            deadband = Double.parseDouble(properties.getProperty("drive_subsystem_deadband"));
            kP = Double.parseDouble(properties.getProperty("drive_subsystem_kP"));
            kI = Double.parseDouble(properties.getProperty("drive_subsystem_kI"));
            kD = Double.parseDouble(properties.getProperty("drive_subsystem_kD"));
            PIDTolerance = Double.parseDouble(properties.getProperty("drive_subsystem_PIDTolerance"));
        } catch (Exception e) {
            e.printStackTrace();
            DriverStation.reportError(e.getMessage(), true);
        }
    }

    public double getDeadband() {
        return deadband;
    }

    public double getkP() {
        return kP;
    }

    public double getkI() {
        return kI;
    }

    public double getkD() {
        return kD;
    }

    public double getPIDTolerance() {
        return PIDTolerance;
    }
}
