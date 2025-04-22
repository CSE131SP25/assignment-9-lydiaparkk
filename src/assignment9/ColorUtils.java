package assignment9;

import java.awt.Color;
import java.util.Random;

public class ColorUtils {
    private static Random random = new Random();
    
    public static Color solidColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
    
    public static Color generateNextColor(Color current) { 
        float[] hsb = Color.RGBtoHSB(
            current.getRed(), 
            current.getGreen(), 
            current.getBlue(), 
            null
        );
        float newHue = (hsb[0] + 0.02f) % 1.0f;
        return Color.getHSBColor(newHue, hsb[1], hsb[2]); //creates a cool gradient
    }
    
    public static Color darkenColor(Color color) { //darkens color each time so its lighter towards the head
        return new Color(
            Math.max((int)(color.getRed() * 0.8), 0),
            Math.max((int)(color.getGreen() * 0.8), 0),
            Math.max((int)(color.getBlue() * 0.8), 0)
        );
    }
    
    public static Color rainbowColor() {
        return Color.getHSBColor(random.nextFloat(), 0.8f, 0.8f);
    }
}