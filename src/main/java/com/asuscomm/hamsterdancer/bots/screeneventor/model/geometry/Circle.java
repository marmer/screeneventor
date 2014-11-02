package com.asuscomm.hamsterdancer.bots.screeneventor.model.geometry;

import java.util.Random;

import org.apache.commons.math3.util.FastMath;
import org.apache.commons.math3.util.MathUtils;

/**
 * Representation of a circle.
 *
 * @author MarMer
 * @since 2014-11-01
 */
public class Circle implements Area {
	private static Random random = new Random();
	/** Circles center */
	public final Point center;
	/** Circles radius */
	public final int radius;

	/**
	 * Creates a new Circle object.
	 *
	 * @param center Circles center
	 * @param radius Circles radius
	 */
	public Circle(final Point center, final int radius) {
		this.center = center;
		this.radius = radius;
	}

	/**
	 * Creates a new Circle object.
	 *
	 * @param x      Circles center X-Coordinate
	 * @param y      Circles center Y-Coordinate
	 * @param radius radius.
	 */
	public Circle(final int x, final int y, final int radius) {
		center = new Point(x, y);
		this.radius = radius;
	}

	/**
	 * Checks whether the given Point is in the circles area (including the borders itself).
	 *
	 * @param  point {@link Point} to check.
	 *
	 * @return True if the given Point is in the circles area.
	 */
	@Override
	public boolean isInArea(final Point point) {
		return radius >= center.getDistance(point);
	}

	/**
	 * Checks whether the given Point is in the circles area (including the
	 * borders itself).
	 * 
	 * @param x
	 *            X-Coordinate of point to check.
	 * @param y
	 *            Y-Coordinate of point to check.
	 * @return True if the given Point is in the circles area.
	 * @see {@link #isInArea(Point)
	 */
	@Override
	public boolean isInArea(final int x, final int y) {
		return isInArea(new Point(x, y));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((center == null) ? 0 : center.hashCode());
		result = (prime * result) + radius;

		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		final Circle other = (Circle) obj;

		if (center == null) {
			if (other.center != null) {
				return false;
			}
		} else if (!center.equals(other.center)) {
			return false;
		}

		if (radius != other.radius) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "Circle [" + center + "," + radius + "]";
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
		return new Circle(center, radius).getRandomPoint();
	}

	/**
	 * Creates es a random Point within a given circle.
	 *
	 * @param x
	 *            X Coordinate of the center of the circle.
	 * @param y
	 *            Y Coordinate of the center of the circle.
	 * @param radius
	 *            Radius of the circle.
	 * @return a random Point within a given Area.
	 */
	public static Point getRandomPointOfCircleArea(final int x, final int y, final int radius) {
		return getRandomPointOfCircleArea(new Point(x, y), radius);

	}

	@Override
	public Point getRandomPoint() {
		final double r = radius * FastMath.sqrt(random.nextDouble());
		final double theta = MathUtils.TWO_PI * Math.random();

		return new Point(center.x + (int) FastMath.round(r * Math.cos(theta)),
		        center.y + (int) Math.round(r * FastMath.sin(theta)));
	}
}
