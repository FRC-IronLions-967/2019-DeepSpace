package frc.robot.networktables;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class limelight {

    private NetworkTable table;

    public limelight() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
    }

    public double getTX() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("tx").getDouble(0.0);
    }

    public double getTY() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("ty").getDouble(0.0);
    }

    public double getTA() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("ta").getDouble(0.0);
    }

    public double getTV() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("tv").getDouble(0.0);
    }

    public double getTS() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("ts").getDouble(0.0);
    }

    public double getTL() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("tl").getDouble(0.0);
    }

    public double getTShort() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("tShort").getDouble(0.0);
    }

    public double getTLong() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("tLong").getDouble(0.0);
    }

    public double getTHor() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("tHor").getDouble(0.0);
    }

    public double getTVert() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("tVert").getDouble(0.0);
    }

    public double getPipe() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("getpipe").getDouble(0.0);
    }

    public double getTX0() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("tx0").getDouble(0.0);
    }

    public double getTY0() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("ty0").getDouble(0.0);
    }

    public double getTA0() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("ta0").getDouble(0.0);
    }

    public double getTS0() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("ts0").getDouble(0.0);
    }

    public double getTX1() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("tx1").getDouble(0.0);
    }

    public double getTY1() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("ty1").getDouble(0.0);
    }

    public double getTA1() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("ta1").getDouble(0.0);
    }

    public double getTS1() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("ts1").getDouble(0.0);
    }

    public double getTX2() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("tx2").getDouble(0.0);
    }

    public double getTY2() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("ty2").getDouble(0.0);
    }

    public double getTA2() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("ta2").getDouble(0.0);
    }

    public double getTS2() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        return table.getEntry("ts2").getDouble(0.0);
    }
}
