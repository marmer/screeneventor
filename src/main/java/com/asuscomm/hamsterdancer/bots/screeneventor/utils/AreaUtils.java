package com.asuscomm.hamsterdancer.bots.screeneventor.utils;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Area;

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
	 * Checks whether a given {@link Point} is within an {@link Area}.
	 *
	 * @param  area {@link Area}
	 * @param  point Point to check.
	 *
	 * @return true if point is in Area.
	 */
	public static boolean isInRectangleArea(final Rectangle area, final Point point) {
		return isInRectangleArea(area, point.x, point.y);
	}

	/**
	 * Checks whether a given {@link Point} is within an {@link Area}.
	 *
	 * @param  area {@link Area}.
	 * @param  xToCheck X Coordinate of point.
	 * @param  yToCheck Y Coordinate of point.
	 *
	 * @return true if point is in Area.
	 */
	public static boolean isInRectangleArea(final Rectangle area,
		final int xToCheck,
		final int yToCheck) {
		return area.contains(xToCheck, yToCheck);
	}

	/**
	 * Checks whether a point is within a circle.
	 *
	 * @param  center       Circles center
	 * @param  radius       Circles radius.
	 * @param  pointToCheck point to check.
	 *
	 * @return True if the point is in the center of the circle.
	 */
	public static boolean isInCircleArea(final Point center,
		final int radius,
		final Point pointToCheck) {
		return isInCircleArea(center, radius, pointToCheck.x, pointToCheck.y);
	}

	/**
	 * Checks whether a point is within a circle.
	 *
	 * @param  center   Circles center
	 * @param  radius   Circles radius.
	 * @param  xToCheck X Coordinate of the point to check.
	 * @param  yToCheck Y Coordinate of the point to check.
	 *
	 * @return True if the point is in the center of the circle.
	 */
	private static boolean isInCircleArea(final Point center,
		final int radius,
		final int xToCheck,
		final int yToCheck) {
		return radius >
			Math.sqrt(Math.pow(center.x - xToCheck, 2) + Math.pow(center.y - yToCheck, 2));
	}

	/**
	 * Creates a random Point within a given Area.
	 *
	 * @param  area to get a point from.
	 *
	 * @return a random Point within a given Area.
	 *
	 * @see    #getRandomPointOfRectableArea(int, int, int, int)
	 */
	public static Point getRandomPointOfRectableArea(final Rectangle area) {
		return getRandomPointOfRectableArea(
				area.x,
				area.x + area.width,
				area.y,
				area.y + area.width);
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

		// FIXME handle negative coordinates which is needed for multiple monitors.

		return new Point(x, y);
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
		final double r = radius * Math.sqrt(random.nextDouble());
		final double theta = 2 * Math.PI * Math.random();

		return new Point(x + (int) Math.round(r * Math.cos(theta)),
				y +
				(int) Math.round(r * Math.sin(theta)));
	}
}
