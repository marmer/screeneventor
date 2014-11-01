package com.asuscomm.hamsterdancer.bots.screeneventor.geometry;

import org.testng.annotations.Test;


/**
 * Tests for class {@link Circle}.
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class CircleTest {
	/** sample circle with a radius of 6. */
	int[][] sampleCircle = {
			{ 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0 },
			{ 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 },
			{ 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0 }
		};

	/** Test. */
	@Test
	public void equalsAndConstructorTest() {
		assert new Circle(new Point(1, 2), 3).equals(new Circle(1, 2, 3)) : "Same Circle";
		assert !new Circle(new Point(1, 2), 4).equals(new Circle(1, 2, 3)) : "Different radius";
		assert !new Circle(new Point(1, 4), 3).equals(new Circle(1, 2, 3)) : "Different Point";
	}

	/** Test. */
	@Test
	public void hashCodeTest() {
		assert new Circle(new Point(1, 2), 3).hashCode() ==
			new Circle(new Point(1, 2), 3).hashCode();
		assert new Circle(new Point(1, 2), 4).hashCode() !=
			new Circle(new Point(1, 2), 3).hashCode();
		assert new Circle(new Point(1, 4), 3).hashCode() !=
			new Circle(new Point(1, 2), 3).hashCode();
	}

	@Test
	public void isInCircleArea() {
		assert new Circle(0, 0, 0).isInArea(0, 0) : "No Radius no Circle";

		assert new Circle(0, 0, 1).isInArea(0, 0) : "Middle";
		assert new Circle(0, 0, 1).isInArea(0, 1) : "top border";
		assert new Circle(0, 0, 1).isInArea(1, 0) : "right border";
		assert new Circle(0, 0, 1).isInArea(0, -1) : "bottom border";
		assert new Circle(0, 0, 1).isInArea(1, 0) : "left border";
	}

	@Test
	public void isInCircleOutsideOfArea() {
		assert !new Circle(0, 0, 1).isInArea(0, 2) : "outside top border";
		assert !new Circle(0, 0, 1).isInArea(2, 0) : "outside right border";
		assert !new Circle(0, 0, 1).isInArea(0, -2) : "outside bottom border";
		assert !new Circle(0, 0, 1).isInArea(2, 0) : "outside left border";

		assert !new Circle(0, 0, 1).isInArea(1, 1) : "outside top right border";
		assert !new Circle(0, 0, 1).isInArea(1, -1) : "outside bottom right border";
		assert !new Circle(0, 0, 1).isInArea(1, 1) : "outside top left border";
		assert !new Circle(0, 0, 1).isInArea(1, -1) : "outside bottom leftleft border";
	}

	@Test
	public void getRandomPoint() {
		final int radius = 6;
		final int diameter = (radius * 2) + 1;

		// initialize array
		final int[][] randomPoints = new int[diameter][];

		for (int i = 0; i < diameter; i++) {
			randomPoints[i] = new int[13];
		}

		final Circle circle = new Circle(new Point(0, 0), radius);

		for (int i = 0; i < 10000; i++) {
			final Point randomPoint = circle.getRandomPoint();
			randomPoints[radius + randomPoint.x][radius + randomPoint.y] = 1;
		}

		// compare arrays
		for (int x = 0; x < diameter; x++) {
			for (int y = 0; y < diameter; y++) {
				assert sampleCircle[x][y] == randomPoints[x][y];
			}
		}
	}

	/** Test. */
	@Test
	public void toStringTest() {
		assert "Circle [[1,2],3]".equals(new Circle(new Point(1, 2), 3).toString());
	}
}
