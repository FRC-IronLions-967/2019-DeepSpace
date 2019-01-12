/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.properties;

import java.util.Properties;
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
            // System.out.println(right_master);
            // System.out.println(right_slave_zero);
            // System.out.println(right_slave_one);
            // System.out.println(left_master);
            // System.out.println(left_slave_zero);
            // System.out.println(left_slave_one);
        } catch (Exception e) {
            e.printStackTrace();
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
}
