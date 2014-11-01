package com.asuscomm.hamsterdancer.bots.screeneventor.geometry;

import org.testng.annotations.Test;


/**
 * Tests for class {@link Circle}.
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class CircleTest {
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
		assert new Circle(0, 0, 0).isInCircleArea(0, 0) : "No Radius no Circle";

		assert new Circle(0, 0, 1).isInCircleArea(0, 0) : "Middle";
		assert new Circle(0, 0, 1).isInCircleArea(0, 1) : "top border";
		assert new Circle(0, 0, 1).isInCircleArea(1, 0) : "right border";
		assert new Circle(0, 0, 1).isInCircleArea(0, -1) : "bottom border";
		assert new Circle(0, 0, 1).isInCircleArea(1, 0) : "left border";
	}

	@Test
	public void isInCircleOutsideOfArea() {
		assert !new Circle(0, 0, 1).isInCircleArea(0, 2) : "outside top border";
		assert !new Circle(0, 0, 1).isInCircleArea(2, 0) : "outside right border";
		assert !new Circle(0, 0, 1).isInCircleArea(0, -2) : "outside bottom border";
		assert !new Circle(0, 0, 1).isInCircleArea(2, 0) : "outside left border";

		assert !new Circle(0, 0, 1).isInCircleArea(1, 1) : "outside top right border";
		assert !new Circle(0, 0, 1).isInCircleArea(1, -1) : "outside bottom right border";
		assert !new Circle(0, 0, 1).isInCircleArea(1, 1) : "outside top left border";
		assert !new Circle(0, 0, 1).isInCircleArea(1, -1) : "outside bottom leftleft border";
	}

	/** Test. */
	@Test
	public void toStringTest() {
		assert "Circle [center=[1,2], radius=3]".equals(new Circle(new Point(1, 2), 3).toString());
	}
}
