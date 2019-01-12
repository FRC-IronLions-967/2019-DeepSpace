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
public class MACConfigChooser {
    public String constraintsPath;
    public String robotmapPath;
    public MACConfigChooser(byte[] mac) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < mac.length; i++) {
          builder.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        System.out.println("MAC: " + builder.toString());
        if(builder.toString().equals("00-80-2F-19-0C-F3")) {
          constraintsPath = "/home/lvuser/deploy/greenBox/greenBoxConstraints.properties";
          robotmapPath = "/home/lvuser/deploy/greenBox/greenBoxRobotmap.properties";
        } else {
          System.out.println("Unrecognized MAC Address");
          constraintsPath = null;
          robotmapPath = null;
        }
    }

    public String getConstraintsPath() {
        return constraintsPath;
    }

    public String getRobotmapPath() {
        return robotmapPath;
    }
}
