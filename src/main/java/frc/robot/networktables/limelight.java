package frc.robot.networktables;


import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Add your docs here.
 */
public class limelight {

    private NetworkTable table;
    private NetworkTableEntry tv;
    private NetworkTableEntry tx;
    private NetworkTableEntry ty;
    private NetworkTableEntry ta;
    private NetworkTableEntry ts;
    private NetworkTableEntry tl;
    private NetworkTableEntry tshort;
    private NetworkTableEntry tlong;
    private NetworkTableEntry thor;
    private NetworkTableEntry tvert;
    private NetworkTableEntry getpipe;
    private NetworkTableEntry tx0;
    private NetworkTableEntry ty0;
    private NetworkTableEntry ta0;
    private NetworkTableEntry ts0;
    private NetworkTableEntry tx1;
    private NetworkTableEntry ty1;
    private NetworkTableEntry ta1;
    private NetworkTableEntry ts1;
    private NetworkTableEntry tx2;
    private NetworkTableEntry ty2;
    private NetworkTableEntry ta2;
    private NetworkTableEntry ts2;
    public limelight() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        tv = table.getEntry("tv");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        ts = table.getEntry("ts");
        tl = table.getEntry("tl");
        tshort = table.getEntry("tshort");
        tlong = table.getEntry("tlong");
        thor = table.getEntry("thor");
        tvert = table.getEntry("tvert");
        getpipe = table.getEntry("getpipe");
        tx0 = table.getEntry("tx0");
        ty0 = table.getEntry("ty0");
        ta0 = table.getEntry("ta0");
        ts0 = table.getEntry("ts0");
        tx1 = table.getEntry("tx1");
        ty1 = table.getEntry("ty1");
        ta1 = table.getEntry("ta1");
        ts1 = table.getEntry("ts1");
        tx2 = table.getEntry("tx2");
        ty2 = table.getEntry("ty2");
        ta2 = table.getEntry("ta2");
        ts2 = table.getEntry("ts2");
    }

    public double getTX() {
        return tx.getDouble(0.0);
    }
    public double getTY() {
        return ty.getDouble(0.0);
    }
    public double getTA() {
        return ta.getDouble(0.0);
    }
    public double getTV() {
        return tv.getDouble(0.0);
    }
    public double getTS() {
        return ts.getDouble(0.0);
    }
    public double getTL() {
        return tl.getDouble(0.0);
    }
    public double getTShort() {
        return tshort.getDouble(0.0);
    }
    public double getTLong() {
        return tlong.getDouble(0.0);
    }
    public double getTHor() {
        return thor.getDouble(0.0);
    }
    public double getTVert() {
        return tvert.getDouble(0.0);
    }
    public double getPipe() {
        return getpipe.getDouble(0.0);
    }
    public double getTX0() {
        return tx0.getDouble(0.0);
    }
    public double getTY0() {
        return ty0.getDouble(0.0);
    }
    public double getTA0() {
        return ta0.getDouble(0.0);
    }
    public double getTS0() {
        return ts0.getDouble(0.0);
    }
    public double getTX1() {
        return tx1.getDouble(0.0);
    }
    public double getTY1() {
        return ty1.getDouble(0.0);
    }
    public double getTA1() {
        return ta1.getDouble(0.0);
    }
    public double getTS1() {
        return ts1.getDouble(0.0);
    }
    public double getTX2() {
        return tx2.getDouble(0.0);
    }
    public double getTY2() {
        return ty2.getDouble(0.0);
    }
    public double getTA2() {
        return ta2.getDouble(0.0);
    }
    public double getTS2() {
        return ts2.getDouble(0.0);
    }
    public NetworkTableEntry[] getAllValues() {
        NetworkTableEntry[] values = {tv, tx, ty, ta, ts, tl, tshort, tlong, thor, tvert, getpipe, tx0, ty0,
             ta0, ts0, tx1, ty1, ta1, ts1, tx2, ty2, ta2, ts2};
        return values;
    }
}
