/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.lib.util;

import frc.lib.util.Utils;
/**
 * Add your docs here.
 */
public class TankDrive {
    double leftYAxis;
    double rightYAxis;
    public TankDrive(double leftYAxis, double rightYAxis) {
        this.leftYAxis = leftYAxis;
        this.rightYAxis = rightYAxis;
    }

    public double getLeftOutput() {
        leftYAxis = Utils.Deadband(leftYAxis, .05);
        leftYAxis = leftYAxis*Math.abs(leftYAxis);
        return leftYAxis;
    }

    public double getRightOutput() {
        rightYAxis = Utils.Deadband(rightYAxis, .05);
        rightYAxis = rightYAxis*Math.abs(rightYAxis);
        return rightYAxis;
    }
}
