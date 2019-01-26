package frc.lib.drive;

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
    public ArcadeDrive(double xAxis, double yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.driveDeadband = 0.0;
        findMax();
    }

    public ArcadeDrive(double xAxis, double yAxis, double deadband) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.driveDeadband = deadband;
        findMax();
    }

    /*public ArcadeDrive(double xAxis, double yAxis, double[] lookupTable) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.lookupTable = lookupTable;
        this.driveDeadband = 0.0;
        findMax();
    }

    public ArcadeDrive(double xAxis, double yAxis, double deadband, double[] lookupTable) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.driveDeadband = deadband;
        this.lookupTable = lookupTable;
        findMax();
    }*/

    public void findMax() {
        xAxis = Utils.Deadband(xAxis, driveDeadband);
        yAxis = Utils.Deadband(yAxis, driveDeadband);
        L = yAxis + xAxis;
        R = yAxis - xAxis;
        max = Math.abs(L);
        if(Math.abs(R) > max) {
            max = Math.abs(R);
        }
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
