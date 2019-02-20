package frc.lib.drive;

import java.text.DecimalFormat;

import frc.lib.util.Utils;

/**
 * Class for easy creation of arcade drive methods in the subsystems
 */
public class ArcadeDrive {
    public double[] lookupTable;
    private double xAxis;
    private double yAxis;
    private double R;
    private double L;
    private double max;
    private double driveDeadband;
    private DecimalFormat df = new DecimalFormat("#.##");

    public ArcadeDrive(double xAxis, double yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.driveDeadband = 0.0;
        xAxis = Utils.Deadband(xAxis, driveDeadband);
        yAxis = Utils.Deadband(yAxis, driveDeadband);
        L = yAxis + xAxis;
        R = yAxis - xAxis;
        max = Math.abs(L);
        if (Math.abs(R) > max) {
            max = Math.abs(R);
        }
    }

    public ArcadeDrive(double xAxis, double yAxis, double deadband) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.driveDeadband = deadband;
        xAxis = Utils.Deadband(xAxis, driveDeadband);
        yAxis = Utils.Deadband(yAxis, driveDeadband);
        L = yAxis + xAxis;
        R = yAxis - xAxis;
        max = Math.abs(L);
        if (Math.abs(R) > max) {
            max = Math.abs(R);
        }
    }

    public ArcadeDrive(double xAxis, double yAxis, double[] lookupTable) {
        this.yAxis = yAxis;
        this.lookupTable = lookupTable;
        this.driveDeadband = 0.0;
        this.xAxis = Utils.Deadband(xAxis, 0.1);
        this.yAxis = Utils.Deadband(yAxis, 0.1);
        this.xAxis = lookupTable[(int) (Double.valueOf(df.format(Math.abs(this.xAxis))) * 100)];
        if (this.xAxis > 0) {
            this.xAxis = -this.xAxis;
        }
        L = yAxis + xAxis;
        R = yAxis - xAxis;
    }

    public ArcadeDrive(double xAxis, double yAxis, double deadband, double[] lookupTable) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.driveDeadband = deadband;
        this.lookupTable = lookupTable;
        this.xAxis = Utils.Deadband(xAxis, this.driveDeadband);
        System.out.println(this.xAxis);
        this.yAxis = Utils.Deadband(yAxis, this.driveDeadband);
        System.out.println(this.yAxis);
        this.xAxis = this.lookupTable[(int) (Double.valueOf(df.format(Math.abs(this.xAxis))) * 100)];
        if (this.xAxis > 0) {
            this.xAxis = -this.xAxis;
        }
        L = yAxis + xAxis;
        R = yAxis - xAxis;
        
        // System.out.println(this.xAxis);
        // System.out.println(this.yAxis);
    }

    public double getR() {
        if ((Math.abs(yAxis) <= 1) && (Math.abs(xAxis) <= 1) && (max < 1)) {
            // System.out.println(R);
            return R;
        } else {
            // System.out.println(R/max);
            return (R / max);
        }
    }

    public double getL() {
        if ((Math.abs(yAxis) <= 1) && (Math.abs(xAxis) <= 1) && (max < 1)) {
            // System.out.println(L);
            return L;
        } else {
            // System.out.println(L/max);
            return (L / max);
        }
    }
}
