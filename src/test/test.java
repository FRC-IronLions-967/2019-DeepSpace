/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.lib.test;

import frc.lib.util.*;
/**
 * Add your docs here.
 */
public class test {
    public static void main(String args[]) {
        TankDrive drive = new TankDrive(0.5, 0.5);
        System.out.println(drive.getLeftOutput());
        System.out.println(drive.getRightOutput());    
    }
}
