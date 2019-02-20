package frc.lib.util;

import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 * Add your docs here.
 */
public class MACAddress {
    private byte[] mac = new byte[6];

    public MACAddress(byte[] defaultMac) {
        try {
            InetAddress address = InetAddress.getLocalHost();
            NetworkInterface nwi = NetworkInterface.getByInetAddress(address);
            mac = nwi.getHardwareAddress();
        } catch (Exception e) {
            e.printStackTrace();
            this.mac = defaultMac;
        }
    }

    public byte[] getMACAddress() {
        return mac;
    }
}
