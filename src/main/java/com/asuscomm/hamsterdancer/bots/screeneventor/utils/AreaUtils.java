package com.asuscomm.hamsterdancer.bots.screeneventor.utils;

import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Circle;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Point;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Rectangle;

import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

import java.util.Random;


/**
 * Helper class related to areas.
 *
 * @author MarMer
 * @since  2014-10-31
 */
public final class AreaUtils {
	private static Random random = new Random();

	private AreaUtils() {
		// util class
	}

	/**
	 * checks whether a number is in a range (including the borders).
	 *
	 * @param  middle      the potential middle.
	 * @param  lowerBorder The lower border
	 * @param  upperBorder The upper border
	 *
	 * @return True if the middle is within the range or at a border (lowerBorder <= middle <=
	 *         topBorder).
	 */
	public static boolean isBetween(final int middle,
		final int lowerBorder,
		final int upperBorder) {
		return (FastMath.min(lowerBorder, upperBorder) <= middle) &&
			(middle <= FastMath.max(lowerBorder, upperBorder));
	}

	/**
	 * Creates a random {@link Point} within a given Area.
	 *
	 * @param  rectangle Rectangle you want to get a point of.
	 *
	 * @return a random Point within a given Area.
	 *
	 * @see    #getRandomPointOfRectableArea(int, int, int, int)
	 */
	public static Point getRandomPointOfRectableArea(final Rectangle rectangle) {
		return getRandomPointOfRectableArea(rectangle.lowerLeft, rectangle.upperRight);
	}

	/**
	 * Creates a random {@link Point} within a given Area.
	 *
	 * @param  startPoint Starting edge of an area.
	 * @param  endPoint   End edge of an area.
	 *
	 * @return a random Point within a given Area.
	 *
	 * @see    #getRandomPointOfRectableArea(int, int, int, int)
	 */
	public static Point getRandomPointOfRectableArea(final Point startPoint, final Point endPoint) {
		return getRandomPointOfRectableArea(startPoint.x, endPoint.x, startPoint.y, endPoint.y);
	}

	/**
	 * Creates a random {@link Point} within a given Area.
	 *
	 * @param  x1 First x coordinate
	 * @param  x2 Second x coordinate
	 * @param  y1 First y coordinate
	 * @param  y2 Second y coordinate
	 *
	 * @return a random Point within a given Area.
	 */
	public static Point getRandomPointOfRectableArea(final int x1,
		final int x2,
		final int y1,
		final int y2) {
		if (x1 > x2) {
			return getRandomPointOfRectableArea(x2, x1, y1, y2);
		} else if (y1 < y2) {
			return getRandomPointOfRectableArea(x1, x2, y2, y1);
		}

		final int x = x1 + random.nextInt((x2 - x1) + 1);
		final int y = y2 + random.nextInt((y1 - y2) + 1);

		return new Point(x, y);
	}

	/**
	 * Creates a random {@link Point} within a given circle.
	 *
	 * @param  circle the circle you want to get a {@link Point}.
	 *
	 * @return a random {@link Point} within a given Area.
	 */
	public static Point getRandomPointOfCircleArea(final Circle circle) {
		return getRandomPointOfCircleArea(circle.center, circle.radius);
	}

	/**
	 * Creates a random {@link Point} within a given circle.
	 *
	 * @param  center Center of the circle.
	 * @param  radius Radius of the circle.
	 *
	 * @return a random {@link Point} within a given Area.
	 */
	public static Point getRandomPointOfCircleArea(final Point center, final int radius) {
		return getRandomPointOfCircleArea(center.x, center.y, radius);
	}

	/**
	 * Creates a random Point within a given circle.
	 *
	 * @param  x      X Coordinate of the center of the circle.
	 * @param  y      Y Coordinate of the center of the circle.
	 * @param  radius Radius of the circle.
	 *
	 * @return a random Point within a given Area.
	 */
	public static Point getRandomPointOfCircleArea(final int x, final int y, final int radius) {
		final double r = radius * FastMath.sqrt(random.nextDouble());
		final double theta = MathUtils.TWO_PI * Math.random();

		return new Point(x + (int) FastMath.round(r * Math.cos(theta)),
				y +
				(int) Math.round(r * FastMath.sin(theta)));
	}
}
