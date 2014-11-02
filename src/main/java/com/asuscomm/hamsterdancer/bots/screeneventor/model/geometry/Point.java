package com.asuscomm.hamsterdancer.bots.screeneventor.model.geometry;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.io.Serializable;


/**
 * Representation of a point.
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class Point implements Serializable, Area {
	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 1L;

	private transient Vector2D vector;

	/** X-Coordinate. */
	public final int x;

	/** Y-Coordinate. */
	public final int y;

	/**
	 * Initializes the point with coordinates.
	 *
	 * @param x X-Coordinate
	 * @param y Y-Coordinate
	 */
	public Point(final int x, final int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Gets the distance to another point.
	 *
	 * @param  other the other point you want to get the distance to.
	 *
	 * @return the distance btween theese points.
	 */
	public double getDistance(final Point other) {
		return getVector().distance(other.getVector());
	}

	private Vector2D getVector() {
		if (vector == null) {
			vector = new Vector2D(x, y);
		}

		return vector;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + x;
		result = (prime * result) + y;

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

		final Point other = (Point) obj;

		if (x != other.x) {
			return false;
		}

		if (y != other.y) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}

	@Override
	public boolean isInArea(final int x, final int y) {
		return (this.x == x) && (this.y == y);
	}

	@Override
	public boolean isInArea(final Point point) {
		return equals(point);
	}

	@Override
	public Point getRandomPoint() {
		return this;
	}
}
