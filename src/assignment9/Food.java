package assignment9;

import java.awt.Color;
import java.util.Random;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

	public static final double FOOD_SIZE = 0.02;
	private double x, y;
	
	/**
	 * Creates a new Food at a random location
	 */
	public Food() {
		randomPosition();
	}
	
	/**
	 * Draws the Food
	 */
	public void draw() {
		 StdDraw.setPenColor(Color.RED);
	        StdDraw.filledCircle(x, y, FOOD_SIZE);
	}
	
	   public void randomPosition() {
	        Random rand = new Random();
	        // Keep food within visible range (padding for radius)
	        x = FOOD_SIZE + (1.0 - 2 * FOOD_SIZE) * rand.nextDouble();
	        y = FOOD_SIZE + (1.0 - 2 * FOOD_SIZE) * rand.nextDouble();
	    }

	    public double getX() {
	        return x;
	    }

	    public double getY() {
	        return y;
	    }
}
