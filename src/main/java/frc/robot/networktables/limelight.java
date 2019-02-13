package frc.robot.networktables;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {

    private NetworkTable table;

    public Limelight() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
    }

    public double getTX() {
        return table.getEntry("tx").getDouble(0.0);
    }

    public double getTY() {
        return table.getEntry("ty").getDouble(0.0);
    }

    public double getTA() {
        return table.getEntry("ta").getDouble(0.0);
    }

    public double getTV() {
        return table.getEntry("tv").getDouble(0.0);
    }

    public double getTS() {
        return table.getEntry("ts").getDouble(0.0);
    }

    public double getTL() {
        return table.getEntry("tl").getDouble(0.0);
    }

    public double getTShort() {
        return table.getEntry("tShort").getDouble(0.0);
    }

    public double getTLong() {
        return table.getEntry("tLong").getDouble(0.0);
    }

    public double getTHor() {
        return table.getEntry("tHor").getDouble(0.0);
    }

    public double getTVert() {
        return table.getEntry("tVert").getDouble(0.0);
    }

    public double getPipe() {
        return table.getEntry("getpipe").getDouble(0.0);
    }

    public double getTX0() {
        return table.getEntry("tx0").getDouble(0.0);
    }

    public double getTY0() {
        return table.getEntry("ty0").getDouble(0.0);
    }

    public double getTA0() {
        return table.getEntry("ta0").getDouble(0.0);
    }

    public double getTS0() {
        return table.getEntry("ts0").getDouble(0.0);
    }

    public double getTX1() {
        return table.getEntry("tx1").getDouble(0.0);
    }

    public double getTY1() {
        return table.getEntry("ty1").getDouble(0.0);
    }

    public double getTA1() {
        return table.getEntry("ta1").getDouble(0.0);
    }

    public double getTS1() {
        return table.getEntry("ts1").getDouble(0.0);
    }

    public double getTX2() {
        return table.getEntry("tx2").getDouble(0.0);
    }

    public double getTY2() {
        return table.getEntry("ty2").getDouble(0.0);
    }

    public double getTA2() {
        return table.getEntry("ta2").getDouble(0.0);
    }

    public double getTS2() {
        return table.getEntry("ts2").getDouble(0.0);
    }
}
