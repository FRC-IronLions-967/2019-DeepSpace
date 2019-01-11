/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package test;

import frc.lib.util.*;
/**
 * Add your docs here.
 */
public class test {
    public static void main(String args[]) {
        switch(args[0]) {
            case "tankdrive":
                testTankDrive(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                break;
            case "arcadedrive":
                testArcadeDrive(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
                break;
            case "deadband":
            testDeadband(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        }
    }

    public static void testTankDrive(double leftYAxis, double rightYAxis) {
        TankDrive drive = new TankDrive(leftYAxis, rightYAxis);
        System.out.println(drive.getLeftOutput());
        System.out.println(drive.getRightOutput());
    }

    public static void testArcadeDrive(double xAxis, double yAxis) {
        SplitArcadeDrive drive = new SplitArcadeDrive(xAxis, yAxis);
        System.out.println(drive.getL());
        System.out.println(drive.getR());
    }

    public static void testDeadband(double input, double deadband) {
        TankDrive drive = new TankDrive(input, deadband);
        System.out.println(drive.getLeftOutput());
        System.out.println(drive.getRightOutput());
    }
}
