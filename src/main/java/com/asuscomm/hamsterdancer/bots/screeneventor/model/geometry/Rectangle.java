package com.asuscomm.hamsterdancer.bots.screeneventor.model.geometry;

import org.apache.commons.math3.util.FastMath;

import java.util.Random;


/**
 * Representation of a rectangle.
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class Rectangle implements Area {
	private static Random random = new Random();

	/** lower Left Corner. */
	public final Point lowerLeft;

	/** upper Right Corner. */
	public final Point upperRight;

	/**
	 * Creates a new Rectangle object.
	 *
	 * @param pointA First Corner
	 * @param pointB Opposite Corner
	 */
	public Rectangle(final Point pointA, final Point pointB) {
		this(pointA.x, pointA.y, pointB.x, pointB.y);
	}

	/**
	 * Creates a new Rectangle object.
	 *
	 * @param x1 X Coordinate of first corner
	 * @param y1 Y Coordinate of first corner
	 * @param x2 X Coordinate of opposite corner
	 * @param y2 Y Coordinate of opposite corner
	 */
	public Rectangle(final int x1, final int y1, final int x2, final int y2) {
		lowerLeft = new Point(FastMath.min(x1, x2), FastMath.min(y1, y2));
		upperRight = new Point(FastMath.max(x1, x2), FastMath.max(y1, y2));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((lowerLeft == null) ? 0 : lowerLeft.hashCode());
		result = (prime * result) + ((upperRight == null) ? 0 : upperRight.hashCode());

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

		final Rectangle other = (Rectangle) obj;

		if (lowerLeft == null) {
			if (other.lowerLeft != null) {
				return false;
			}
		} else if (!lowerLeft.equals(other.lowerLeft)) {
			return false;
		}

		if (upperRight == null) {
			if (other.upperRight != null) {
				return false;
			}
		} else if (!upperRight.equals(other.upperRight)) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "Rectangle [" + lowerLeft + "," + upperRight + "]";
	}

	@Override
	public boolean isInArea(final int x, final int y) {
		return isInArea(new Point(x, y));
	}

	@Override
	public boolean isInArea(final Point point) {
		return Rectangle.isBetween(point.x, lowerLeft.x, upperRight.x) &&
			Rectangle.isBetween(point.y, lowerLeft.y, upperRight.y);
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
	 * @param  startPoint Starting edge of an area.
	 * @param  endPoint   End edge of an area.
	 *
	 * @return a random Point within a given Area.
	 *
	 * @see    #getRandomPointOfRectableArea(int, int, int, int)
	 */
	public static Point getRandomPointOfRectableArea(final Point startPoint, final Point endPoint) {
		return new Rectangle(startPoint, endPoint).getRandomPoint();
	}

	/**
	 * Creates a random {@link Point} within a given Area.
	 *
	 * @param  left   First x coordinate
	 * @param  bottom First y coordinate
	 * @param  top    Second x coordinate
	 * @param  right  y2 Second y coordinate
	 *
	 * @return a random Point within a given Area.
	 */
	public static Point getRandomPointOfRectableArea(final int left,
		final int bottom,
		final int top,
		final int right) {
		return getRandomPointOfRectableArea(new Point(left, bottom), new Point(top, right));
	}

	@Override
	public Point getRandomPoint() {
		final int x = lowerLeft.x + random.nextInt((upperRight.x - lowerLeft.x) + 1);
		final int y = lowerLeft.y + random.nextInt((upperRight.y - lowerLeft.y) + 1);

		return new Point(x, y);
	}
}
