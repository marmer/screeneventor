package com.asuscomm.hamsterdancer.bots.screeneventor.utils;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.Point;


/**
 * TODO: doc
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class AreaUtilsTest {
	/** TODO: doc */
	@BeforeMethod
	public void beforeMethod() {}

	@Test
	public void getRandomPointOfCircleAreaPointint() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getRandomPointOfCircleAreaintintint() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getRandomPointOfRectableAreaRectangle() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getRandomPointOfRectableAreaPointPoint() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void getRandomPointOfRectableAreaintintintint() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void isInCircleAreaInsideOfArea() {
		assert AreaUtils.isInCircleArea(new Point(0, 0), 0, new Point(0, 0)) : "Same position same \"Circle\"";

		assert AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(0, 0)) : "Middle";
		assert AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(0, 1)) : "top border";
		assert AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(1, 0)) : "right border";
		assert AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(0, -1)) : "bottom border";
		assert AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(-1, 0)) : "left border";
	}

	@Test
	public void isInCircleOutsideOfArea() {
		assert !AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(0, 2)) : "outside top border";
		assert !AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(2, 0)) : "outside right border";
		assert !AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(0, -2)) : "outside bottom border";
		assert !AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(-2, 0)) : "outside left border";

		assert !AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(1, 1)) : "outside top right border";
		assert !AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(1, -1)) : "outside bottom right border";
		assert !AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(-1, 1)) : "outside top left border";
		assert !AreaUtils.isInCircleArea(new Point(0, 0), 1, new Point(-1, -1)) : "outside bottom leftleft border";
	}

	@Test
	public void isInRectangleAreaRectanglePoint() {
		throw new RuntimeException("Test not implemented");
	}

	@Test
	public void isInRectangleAreaRectangleintint() {
		throw new RuntimeException("Test not implemented");
	}
}
