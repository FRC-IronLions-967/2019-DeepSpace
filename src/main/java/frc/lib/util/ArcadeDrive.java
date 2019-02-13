/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.lib.util;

import java.text.DecimalFormat;

/**
 * Add your docs here.
 */
public class ArcadeDrive {
    private double xAxis;
    private double yAxis;
    private double R;
    private double L;
    private double max;
    private double[] lookupTable;
    private double driveDeadband;
    private boolean isLookUp = false; 

    private DecimalFormat df = new DecimalFormat("#.##");

    public ArcadeDrive(double xAxis, double yAxis) {
        this.isLookUp = false;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.driveDeadband = 0.0;
        findMax();
    }

    public ArcadeDrive(double xAxis, double yAxis, double deadband) {
        this.isLookUp = false;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.driveDeadband = deadband;
        findMax();
    }

    public ArcadeDrive(double xAxis, double yAxis, double[] lookupTable) {
        this.isLookUp = true;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.lookupTable = lookupTable;
        this.driveDeadband = 0.0;
        findMax();
    }

    public ArcadeDrive(double xAxis, double yAxis, double deadband, double[] lookupTable) {
        this.isLookUp = true;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.driveDeadband = deadband;
        this.lookupTable = lookupTable;
        findMax();
    }

    public double lookUpConverted() {
        return lookupTable[(int)(Double.valueOf(df.format(Math.abs(xAxis)))*100)];
    }

    public void findMax() {
        if (isLookUp) {
            xAxis = lookUpConverted();
        }

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
