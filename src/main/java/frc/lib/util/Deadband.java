package frc.lib.util;

public class Deadband {

    double input;
    double deadband;

    public Deadband(double input, double deadband) {
        this.input = input;
        this.deadband = deadband;
    }

    public double get() {
        // upper deadband
        if(input >= +deadband) {
            return input;
        } 
        // lower deadband
        else if(input <= -deadband) {
            return input;
        }
        // outside deadband
        return 0;
    }
}