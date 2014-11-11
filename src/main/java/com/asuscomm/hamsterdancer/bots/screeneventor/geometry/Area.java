package com.asuscomm.hamsterdancer.bots.screeneventor.geometry;

import java.io.Serializable;


/**
 * Area.
 *
 * @author MarMer
 * @since  01.11.2014
 */
public interface Area extends Serializable {
	/**
	 * Checks whether a given Point is part of the area including the areas border.
	 *
	 * @param  x X-Coordinate of the point to perform the check for.
	 * @param  y X-Coordinate of the point to perform the check for.
	 *
	 * @return true if the point is within the area.
	 */
	boolean isInArea(final int x, final int y);

	/**
	 * Checks whether a given Point is part of the area including the areas border.
	 *
	 * @param  point Point to perform the check for.
	 *
	 * @return true if the point is within the area.
	 */
	boolean isInArea(final Point point);

	/**
	 * Returns a random point within the area. Border Points are possible.
	 *
	 * @return Returns a random point within the area. Border Points are possible.
	 */
	Point getRandomPoint();

	/**
	 * Numeric area description with squared brackets around.
	 *
	 * @return numeric area description with squared brackets around.
	 */
	String getAreaCoordinates();
}
