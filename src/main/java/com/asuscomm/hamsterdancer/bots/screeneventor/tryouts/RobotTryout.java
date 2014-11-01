package com.asuscomm.hamsterdancer.bots.screeneventor.tryouts;

import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Point;
import com.asuscomm.hamsterdancer.bots.screeneventor.utils.AreaUtils;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;

import java.util.Random;


/**
 * TODO: doc
 *
 * @author MarMer
 * @since  2014-10-30
 */
public class RobotTryout {
	/**
	 * TODO: doc
	 *
	 * @param  args TODO: doc
	 *
	 * @throws AWTException TODO: doc
	 */
	public static void main(final String[] args) throws AWTException {
		final Robot r = new Robot();

		r.setAutoDelay(0);

		final Random rand = new Random();

		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final double width = screenSize.getWidth();
		final double height = screenSize.getHeight();

		System.out.println(width);
		System.out.println(height);

		// final int widthMin = 3000;
		// final int widthMax = 3250;
		// final int heightMin = 400;
		// final int heightMax = 700;
		final int left = 2950;
		final int right = 3300;
		final int top = 400;
		final int bottom = 725;

		final int timeToClickInMin = 1;
		final int timeToClickInSec = timeToClickInMin * 60; // approximate
		final int timeToClickInMs = timeToClickInSec * 1000;
		final int delay = 4;
		final int iterations = timeToClickInMs / delay;

		final boolean stop = false;

		for (int i = 0; (i < iterations) && !stop; i++) {
			final Point point = AreaUtils.getRandomPointOfRectableArea(left, right, top, bottom);
			performClick(r, point);

			r.delay(delay);
		}

		// r.mouseMove(left, bottom);
		performClick(r, 500, 500);
	}

	/**
	 * TODO: doc
	 *
	 * @param r     TODO: doc
	 * @param point TODO: doc
	 */
	private static void performClick(final Robot r, final Point point) {
		performClick(r, point.x, point.y);
	}

	/**
	 * TODO: doc
	 *
	 * @param r TODO: doc
	 * @param x TODO: doc
	 * @param y TODO: doc
	 */
	private static void performClick(final Robot r, final int x, final int y) {
		r.mouseMove(x, y);
		performClick(r);
	}

	/**
	 * TODO: doc
	 *
	 * @param r TODO: doc
	 */
	private static void performClick(final Robot r) {
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
	}
}
