package frc.lib.util;

/**
 * Add your docs here.
 */
public class Utils {
    public static double Deadband(double input, double deadband) {
        // upper deadband
        if (input >= +deadband) {
            return input;
        }
        // lower deadband
        else if (input <= -deadband) {
            return input;
        }
        // outside deadband
        return 0;
    }
}
