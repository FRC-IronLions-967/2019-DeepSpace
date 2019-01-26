package test;

import frc.lib.drive.*;
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
                break;
        }
    }

    public static void testTankDrive(double leftYAxis, double rightYAxis) {
        TankDrive drive = new TankDrive(leftYAxis, rightYAxis);
        System.out.println(drive.getLeftOutput());
        System.out.println(drive.getRightOutput());
    }

    public static void testArcadeDrive(double xAxis, double yAxis) {
        ArcadeDrive drive = new ArcadeDrive(xAxis, yAxis);
        System.out.println(drive.getL());
        System.out.println(drive.getR());
    }

    public static void testDeadband(double input, double deadband) {
        TankDrive drive = new TankDrive(input, deadband);
        System.out.println(drive.getLeftOutput());
        System.out.println(drive.getRightOutput());
    }
}
