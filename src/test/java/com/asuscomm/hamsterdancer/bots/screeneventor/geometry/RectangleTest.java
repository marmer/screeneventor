package com.asuscomm.hamsterdancer.bots.screeneventor.geometry;

import org.testng.annotations.Test;

import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Point;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Rectangle;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * TODO: doc
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class RectangleTest {
	/** equalsTest. */
	@Test
	public void equalsTest() {
		assert new Rectangle(1, 2, 3, 4).equals(new Rectangle(1, 2, 3, 4)) : "Really equal";
		assert new Rectangle(1, 2, 3, 4).equals(new Rectangle(3, 4, 1, 2)) : "Switched corners";

		assert new Rectangle(1, 2, 3, 4).equals(new Rectangle(1, 4, 3, 2)) : "Not named corners";
		assert new Rectangle(1, 2, 3, 4).equals(new Rectangle(3, 2, 1, 4)) : "Not named corners switched";
	}

	/** hashCodeTest. */
	@Test
	public void hashCodeTest() {
		assert new Rectangle(1, 2, 3, 4).hashCode() == new Rectangle(1, 2, 3, 4).hashCode() : "Really equal";
		assert new Rectangle(1, 2, 3, 4).hashCode() == new Rectangle(3, 4, 1, 2).hashCode() : "Switched corners";

		assert new Rectangle(1, 2, 3, 4).hashCode() == new Rectangle(1, 4, 3, 2).hashCode() : "Not named corners";
		assert new Rectangle(1, 2, 3, 4).hashCode() == new Rectangle(3, 2, 1, 4).hashCode() : "Not named corners switched";
	}

	@Test
	public void isInArea() {
		assert new Rectangle(0, 0, 0, 0).isInArea(0, 0);

		assert new Rectangle(-1, -1, 1, 1).isInArea(0, 0);

		assert new Rectangle(-1, -1, 1, 1).isInArea(0, 1);
		assert new Rectangle(-1, -1, 1, 1).isInArea(1, 0);
		assert new Rectangle(-1, -1, 1, 1).isInArea(0, -1);
		assert new Rectangle(-1, -1, 1, 1).isInArea(-1, 0);

		assert new Rectangle(-1, -1, 1, 1).isInArea(1, 1);
		assert new Rectangle(-1, -1, 1, 1).isInArea(1, -1);
		assert new Rectangle(-1, -1, 1, 1).isInArea(-1, 1);
		assert new Rectangle(-1, -1, 1, 1).isInArea(-1, -1);
	}

	@Test
	public void isInAreaNot() {
		assert !new Rectangle(0, 0, 0, 0).isInArea(1, 1);
		assert !new Rectangle(0, 0, 0, 0).isInArea(1, -1);
		assert !new Rectangle(0, 0, 0, 0).isInArea(-1, 1);
		assert !new Rectangle(0, 0, 0, 0).isInArea(-1, -1);

		assert !new Rectangle(0, 0, 0, 0).isInArea(1, 0);
		assert !new Rectangle(0, 0, 0, 0).isInArea(-1, 0);
		assert !new Rectangle(0, 0, 0, 0).isInArea(0, 1);
		assert !new Rectangle(0, 0, 0, 0).isInArea(-0, -1);
	}

	/** toStringTest. */
	@Test
	public void toStringTest() {
		assert "Rectangle [[1,2],[3,4]]".equals(new Rectangle(1, 2, 3, 4).toString());
	}

	@Test(dependsOnMethods = "isInArea")
	public void getRandomPoint() {
		Rectangle rectangle = new Rectangle(0, 0, 0, 0);

		for (int i = 0; i < 1000; i++) {
			final Point randomPoint = rectangle.getRandomPoint();
			assert rectangle.isInArea(randomPoint);
		}

		rectangle = new Rectangle(-2, -2, 2, 2);

		final Set<Point> allPossiblePoints = collectAllPossiblePoints(rectangle);

		for (int i = 0; i < 10000; i++) {
			final Point randomPoint = rectangle.getRandomPoint();
			assert rectangle.isInArea(randomPoint);
			allPossiblePoints.remove(randomPoint);
		}

		assert allPossiblePoints.isEmpty() : "all possible points should have been found";
	}

	private Set<Point> collectAllPossiblePoints(final Rectangle rectangle) {
		final Set<Point> possibilities = new LinkedHashSet<Point>();

		for (int x = rectangle.lowerLeft.x; x <= rectangle.upperRight.x; x++) {
			for (int y = rectangle.lowerLeft.y; y <= rectangle.upperRight.y; y++) {
				possibilities.add(new Point(x, y));
			}
		}

		return possibilities;
	}
}
