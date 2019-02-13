package frc.robot.networktables;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class limelight {

    public limelight() {
    }

    public double getTX() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0.0);
    }

    public double getTY() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty").getDouble(0.0);
    }

    public double getTA() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0.0);
    }

    public double getTV() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0.0);
    }

    public double getTS() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts").getDouble(0.0);
    }

    public double getTL() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tl").getDouble(0.0);
    }

    public double getTShort() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tShort").getDouble(0.0);
    }

    public double getTLong() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tLong").getDouble(0.0);
    }

    public double getTHor() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tHor").getDouble(0.0);
    }

    public double getTVert() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tVert").getDouble(0.0);
    }

    public double getPipe() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("getpipe").getDouble(0.0);
    }

    public double getTX0() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx0").getDouble(0.0);
    }

    public double getTY0() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty0").getDouble(0.0);
    }

    public double getTA0() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta0").getDouble(0.0);
    }

    public double getTS0() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts0").getDouble(0.0);
    }

    public double getTX1() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx1").getDouble(0.0);
    }

    public double getTY1() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty1").getDouble(0.0);
    }

    public double getTA1() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta1").getDouble(0.0);
    }

    public double getTS1() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts1").getDouble(0.0);
    }

    public double getTX2() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx2").getDouble(0.0);
    }

    public double getTY2() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ty2").getDouble(0.0);
    }

    public double getTA2() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta2").getDouble(0.0);
    }

    public double getTS2() {
        return NetworkTableInstance.getDefault().getTable("limelight").getEntry("ts2").getDouble(0.0);
    }
}