package com.asuscomm.hamsterdancer.bots.screeneventor.geometry;

/**
 * Area.
 *
 * @author MarMer
 * @since  01.11.2014
 */
public interface Area {

	public abstract boolean isInArea(final int x, final int y);

	public abstract boolean isInArea(final Point point);}
