package net.jozoproductions.jplibandroid.math;

public class Mathf {

    public static boolean isInBounds(float value, float min, float max) {
        return value >= min && value <= max;
    }
}
