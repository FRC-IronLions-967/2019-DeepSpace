package frc.lib.drive;

import java.text.DecimalFormat;

import frc.lib.util.Utils;


/**
 * Add your docs here.
 */
public class ArcadeDrive {
    double xAxis;
    double yAxis;
    double R;
    double L;
    double max;
    double[] lookupTable;
    double driveDeadband;
    DecimalFormat df = new DecimalFormat("#.##");
    public ArcadeDrive(double xAxis, double yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.driveDeadband = 0.0;
        xAxis = Utils.Deadband(xAxis, driveDeadband);
        yAxis = Utils.Deadband(yAxis, driveDeadband);
        L = yAxis + xAxis;
        R = yAxis - xAxis;
        max = Math.abs(L);
        if(Math.abs(R) > max) {
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
        if(Math.abs(R) > max) {
            max = Math.abs(R);
        }
    }

    public ArcadeDrive(double xAxis, double yAxis, double[] lookupTable) {
        this.yAxis = yAxis;
        this.lookupTable = lookupTable;
        this.driveDeadband = 0.0;
        this.lookupTable = lookupTable;
        this.xAxis = lookupTable[(int)(Double.valueOf(df.format(Math.abs(this.xAxis)))*100)];
        if(this.xAxis > 0) {
            this.xAxis = -this.xAxis;
        }
        this.xAxis = Utils.Deadband(this.xAxis, driveDeadband);
        this.yAxis = Utils.Deadband(this.yAxis, driveDeadband);
    }

    public ArcadeDrive(double xAxis, double yAxis, double deadband, double[] lookupTable) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.driveDeadband = deadband;
        this.lookupTable = lookupTable;
        this.xAxis = lookupTable[(int)(Double.valueOf(df.format(Math.abs(this.xAxis)))*100)];
        if(this.xAxis > 0) {
            this.xAxis = -this.xAxis;
        }
        this.xAxis = Utils.Deadband(this.xAxis, deadband);
        this.yAxis = Utils.Deadband(this.yAxis, deadband);
    }

    public double getR() {
        if((Math.abs(yAxis) <= 1) && (Math.abs(xAxis) <= 1) && (max < 1)) {
            return R;
        } else {
            return (R/max);
        }
    }
    

    public double getL() {
        if((Math.abs(yAxis) <= 1) && (Math.abs(xAxis) <= 1) && (max < 1)) {
            return L;
        } else {
            return (L/max);
        }
    }
}
