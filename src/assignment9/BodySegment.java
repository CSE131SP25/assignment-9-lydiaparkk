package assignment9;

import java.awt.Color;
import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {
    private double x;
    private double y;
    private Color color;

    public BodySegment(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void draw() {
        StdDraw.setPenColor(color);
        StdDraw.filledCircle(x, y, 0.02);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.circle(x, y, 0.02);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Color getColor() {
        return color;
    }
}