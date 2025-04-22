package assignment9;

import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class Food {
    public static final double FOOD_SIZE = 0.02;
    private double x, y;
    private boolean isSpecial;
    
    public Food() {
        this.x = FOOD_SIZE + Math.random() * (1.0 - 2 * FOOD_SIZE);
        this.y = FOOD_SIZE + Math.random() * (1.0 - 2 * FOOD_SIZE);
        this.isSpecial = Math.random() < 0.3;
    } //spawns the random food within the radius of the screen 
    //theres a 30% chance of the special in spawning and grows x2
    
    public void draw() {
        if (isSpecial) {
            StdDraw.setPenColor(ColorUtils.rainbowColor());
            StdDraw.filledCircle(x, y, FOOD_SIZE);
            StdDraw.setPenColor(Color.WHITE);
            StdDraw.text(x, y, "★");
        } else {
            StdDraw.setPenColor(Color.RED);
            StdDraw.filledCircle(x, y, FOOD_SIZE);
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isSpecial() {
        return isSpecial;
    }
}