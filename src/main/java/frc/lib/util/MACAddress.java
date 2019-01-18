/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.lib.util;

import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * Add your docs here.
 */
public class MACAddress {
    private byte[] mac;
    public MACAddress() {
        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
            mac = nwi.getHardwareAddress();
        } catch (Exception e) {
            e.printStackTrace();
		} 
    }

    public byte[] getMACAddress() {
        return mac;
    }
}
