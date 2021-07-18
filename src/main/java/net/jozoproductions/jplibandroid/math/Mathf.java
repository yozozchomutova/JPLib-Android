package net.jozoproductions.jplibandroid.math;

import java.util.Random;

public class Mathf {

    public static final Random random = new Random();

    public static boolean isInBounds(float value, float min, float max) {
        return value >= min && value <= max;
    }

    public static double distance(float x1, float y1, float x2, float y2) {
        return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
    }

    public static float getRandomFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    public static float checkForBounds(float value, float min, float max) {
        if (value > max)
            return max;

        if (value < min)
            return min;

        return value;
    }
}
