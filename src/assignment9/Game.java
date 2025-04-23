package assignment9;

import java.awt.event.KeyEvent;

import edu.princeton.cs.introcs.StdDraw;

public class Game {
	
	private Snake snake;
	private Food food;
	private int score = 0;
	
	public Game() {
		StdDraw.enableDoubleBuffering();
		snake = new Snake();
		food = new Food();
	}
	
	public void play() {
		while (snake.isInbounds()) { //TODO: Update this condition to check if snake is in bounds
			int dir = getKeypress();
			//Testing only: you will eventually need to do more work here
			System.out.println("Keypress: " + dir);
			
			/*
			 * 1. Pass direction to your snake
			 * 2. Tell the snake to move
			 * 3. If the food has been eaten, make a new one
			 * 4. Update the drawing
			 */
			if (dir != -1) {
				snake.changeDirection(dir);
			}

			//Step 2: Move the snake
			snake.move();

			// Step 3: Check for food collision
			if (snake.eatFood(food)) {
				snake.grow();
				food = new Food(); // new food after eating
				score += 10;
			}

			// Step 4: Redraw game
			updateDrawing();
		}
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.text(0.5, 0.5, "Game Over!");
		StdDraw.show();
	}
	
	private int getKeypress() {
		if(StdDraw.isKeyPressed(KeyEvent.VK_W)) {
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
		//FIXME
		
		/*
		 * 1. Clear screen
		 * 2. Draw snake and food
		 * 3. Pause (50 ms is good)
		 * 4. Show
		 */
		StdDraw.clear();
		snake.draw();
		food.draw();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.textLeft(0.05, 0.95, "Score: " + score);
		StdDraw.pause(50); 
		StdDraw.show();
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		g.play();
	}
}
