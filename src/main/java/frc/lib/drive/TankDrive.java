package frc.lib.drive;

import frc.lib.util.Utils;

/**
 * Add your docs here.
 */
public class TankDrive {
    private double leftYAxis;
    private double rightYAxis;
    private double driveDeadband = 0;

    public TankDrive(double leftYAxis, double rightYAxis) {
        this.leftYAxis = leftYAxis;
        this.rightYAxis = rightYAxis;
    }

    public TankDrive(double leftYAxis, double rightYAxis, double deadband) {
        this.leftYAxis = leftYAxis;
        this.rightYAxis = rightYAxis;
        this.driveDeadband = deadband;
    }

    public double getLeftOutput() {
        leftYAxis = Utils.Deadband(leftYAxis, driveDeadband);
        leftYAxis = leftYAxis * Math.abs(leftYAxis);
        return leftYAxis;
    }

    public double getRightOutput() {
        rightYAxis = Utils.Deadband(rightYAxis, driveDeadband);
        rightYAxis = rightYAxis * Math.abs(rightYAxis);
        return rightYAxis;
    }
}
