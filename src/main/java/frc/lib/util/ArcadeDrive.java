/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.lib.util;

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
