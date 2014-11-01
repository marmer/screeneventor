package com.asuscomm.hamsterdancer.bots.screeneventor.geometry;

import com.asuscomm.hamsterdancer.bots.screeneventor.utils.AreaUtils;

import org.apache.commons.math3.util.FastMath;


/**
 * Representation of a rectangle.
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class Rectangle implements Area {
	private final Point lowerLeft;
	private final Point upperRight;

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
		return AreaUtils.isBetween(point.x, lowerLeft.x, upperRight.x) &&
			AreaUtils.isBetween(point.y, lowerLeft.y, upperRight.y);
	}
}
