package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private Food food;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		
		// Create new Snake and Food
		snake = new Snake();
		food = new Food();
	}
	
	public void play() {
		while (snake.isInBounds()) {
			int dir = getKeypress();
			
			// changes direction after a key is pressed 
			if (dir != -1) {
				snake.changeDirection(dir);
			}
			
			// 2. moves the snake
			snake.move();
			
			// 3. If the food has been eaten, creates a new food
			if (snake.eat(food)) {
				food = new Food();
			}
			
			// 4. Update the drawing
			updateDrawing();
		}
		
		// Game Over screen
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.text(0.5, 0.5, "Game Over!");
		StdDraw.show();
	}
	w
	private int getKeypress() {
		if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
			return 1;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
			return 2;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
			return 3;
		} else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
			return 4;
		} else {
			return -1;
		}
	}
	
	/**
	 * Clears the screen, draws the snake and food, pauses, and shows the content
	 */
	private void updateDrawing() {
		StdDraw.clear();
		
		snake.draw();
		food.draw();
		
		StdDraw.show();
		StdDraw.pause(100); // adjust speed here (ms)
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
