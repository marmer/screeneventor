package com.asuscomm.hamsterdancer.bots.screeneventor.geometry;

/**
 * Representation of a circle in a 2D-Area.
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class Circle {
	private final Point center;
	private final int radius;

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
	public boolean isInCircleArea(final Point point) {
		return radius >= center.getDistance(point);
	}

	/**
	 * Checks whether the given Point is in the circles area (including the
	 * borders itself).
	 *
	 * @param point
	 *            {@link Point} to check.
	 * @return True if the given Point is in the circles area.
	 * @see {@link #isInCircleArea(Point)

	 */
	public boolean isInCircleArea(final int x, final int y) {
		return isInCircleArea(new Point(x, y));
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
		return "Circle [center=" + center + ", radius=" + radius + "]";
	}
}
