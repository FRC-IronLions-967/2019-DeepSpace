package frc.robot.properties;

import java.util.Properties;

import edu.wpi.first.wpilibj.DriverStation;

import java.io.InputStream;
import java.io.FileInputStream;

/**
 * Add your docs here.
 */
public class RobotMapProperties {
    private int right_master;
    private int right_slave_zero;
    private int right_slave_one;

    private int left_master;
    private int left_slave_zero;
    private int left_slave_one;

    private int left_side;
    private int right_side;

    private int intake_roller;

    private int pcm;

    private int hatchPanelGrabberForward;
    private int hatchPanelGrabberReverse;
    private int hatchPanelArmForward;
    private int hatchPanelArmReverse;

    Properties properties = new Properties();
    InputStream input = null;

    public RobotMapProperties(String path) {
        try {
            input = new FileInputStream(path);
            properties.load(input);
            right_master = Integer.parseInt(properties.getProperty("right_master"));
            right_slave_zero = Integer.parseInt(properties.getProperty("right_slave_zero"));
            right_slave_one = Integer.parseInt(properties.getProperty("right_slave_one"));
            left_master = Integer.parseInt(properties.getProperty("left_master"));
            left_slave_zero = Integer.parseInt(properties.getProperty("left_slave_zero"));
            left_slave_one = Integer.parseInt(properties.getProperty("left_slave_one"));

            left_side = Integer.parseInt(properties.getProperty("left_side"));
            right_side = Integer.parseInt(properties.getProperty("right_side"));

            intake_roller = Integer.parseInt(properties.getProperty("intake_roller"));

            pcm = Integer.parseInt(properties.getProperty("pcm"));
            hatchPanelGrabberForward = Integer.parseInt(properties.getProperty("hatchPanelGrabberForward"));
            hatchPanelGrabberReverse = Integer.parseInt(properties.getProperty("hatchPanelGrabberReverse"));
            hatchPanelArmForward = Integer.parseInt(properties.getProperty("hatchPanelArmForward"));
            hatchPanelArmReverse = Integer.parseInt(properties.getProperty("hatchPanelArmReverse"));

        } catch (Exception e) {
            e.printStackTrace();
            DriverStation.reportError(e.getMessage(), true);
        }

    }

    public int getDriveRightMaster() {
        return right_master;
    }

    public int getDriveRightSlaveZero() {
        return right_slave_zero;
    }

    public int getDriveRightSlaveOne() {
        return right_slave_one;
    }

    public int getDriveLeftMaster() {
        return left_master;
    }

    public int getDriveLeftSlaveZero() {
        return left_slave_zero;
    }

    public int getDriveLeftSlaveOne() {
        return left_slave_one;
    }

    public int getLeftSide() {
        return left_side;
    }

    public int getRightSide() {
        return right_side;
    }

    public int getIntakeRoller() {
        return intake_roller;
    }

    public int getPcm() {
        return pcm;
    }

    public int getHatchPanelGrabberForward() {
        return hatchPanelGrabberForward;
    }

    public int getHatchPanelGrabberReverse() {
        return hatchPanelGrabberReverse;
    }

    public int getHatchPanelArmForward() {
        return hatchPanelArmForward;
    }

    public int getHatchPanelArmReverse() {
        return hatchPanelArmReverse;
    }
}
