package assignment9;

import java.util.LinkedList;
import java.awt.Color;

public class Snake {
    private static final double SEGMENT_SIZE = 0.02;
    private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;

    private LinkedList<BodySegment> segments;
    private double deltaX;
    private double deltaY;
    private Color headColor;
    private boolean specialFoodActive;
    private int specialFoodTimer;

    public Snake() {
        segments = new LinkedList<>();
        headColor = ColorUtils.solidColor();
        segments.add(new BodySegment(0.5, 0.5, headColor));
        deltaX = 0;
        deltaY = 0;
        specialFoodActive = false;
        specialFoodTimer = 0;
    }

    public void changeDirection(int direction) {
        if (direction == 1 && deltaY == 0) { // up
            deltaY = MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 2 && deltaY == 0) { // down
            deltaY = -MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 3 && deltaX == 0) { // left
            deltaY = 0;
            deltaX = -MOVEMENT_SIZE;
        } else if (direction == 4 && deltaX == 0) { // right
            deltaY = 0;
            deltaX = MOVEMENT_SIZE;
        }
    }

    public void move() {
        if (deltaX == 0 && deltaY == 0) {
            return;
        }
// current head position
        BodySegment head = segments.getFirst();
        double newX = head.getX() + deltaX;
        double newY = head.getY() + deltaY;
//adds new head at new position from the last one 
        headColor = ColorUtils.generateNextColor(headColor);
        segments.addFirst(new BodySegment(newX, newY, headColor));
        segments.removeLast(); //removes the last one to make it seem like its moving

        if (specialFoodActive) {
            specialFoodTimer--;
            if (specialFoodTimer <= 0) {
                specialFoodActive = false;
            }
        }
    }

    public void draw() {
        for (BodySegment segment : segments) {
            segment.draw();
        }
    }

    public boolean eat(Food food) {
        BodySegment head = segments.getFirst();
        double distance = Math.sqrt(Math.pow(head.getX() - food.getX(), 2) + 
                         Math.pow(head.getY() - food.getY(), 2));
        //when the snake touching the food 
        //only if the food is special theres an increas in size by 2x
        if (distance < SEGMENT_SIZE + Food.FOOD_SIZE) {
            if (food.isSpecial()) {
                specialFoodActive = true;
                specialFoodTimer = 50;
            }
// adds the segments from the last body segment and darkens the color from the head
            int segmentsToAdd = specialFoodActive ? 2 : 1;
            for (int i = 0; i < segmentsToAdd; i++) {
                BodySegment last = segments.getLast();
                segments.addLast(new BodySegment(last.getX(), last.getY(), 
                    ColorUtils.darkenColor(last.getColor())));
            }
            return true;
        }
        return false;
    }

    public boolean isInBounds() {
        BodySegment head = segments.getFirst();
        return head.getX() >= 0 && head.getX() <= 1 && 
               head.getY() >= 0 && head.getY() <= 1;
    }
}