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
    private String constraintsPath;
    private String robotmapPath;
    public MACConfigChooser(byte[] mac, String[] macs, String[] constraintsPaths, String[] mapPaths) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < mac.length; i++) {
          builder.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
        }
        System.out.println("MAC: " + builder.toString());
        for(int i = 0; i < macs.length; i++) {
            if(builder.toString().equals(macs[i])) {
                this.constraintsPath = constraintsPaths[i];
                this.robotmapPath = mapPaths[i];
                break;
            }
        }
        if(constraintsPath == null) {
            constraintsPath = "/home/lvuser/deploy/greenBox/greenBoxConstraints.properties";
        }

        if(robotmapPath == null) {
            robotmapPath = "/home/lvuser/deploy/greenBox/greenBoxRobotmap.properties";
        }
    }

    public String getConstraintsPath() {
        return constraintsPath;
    }

    public String getRobotmapPath() {
        return robotmapPath;
    }
}
