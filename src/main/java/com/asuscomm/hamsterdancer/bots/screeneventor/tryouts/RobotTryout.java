package com.asuscomm.hamsterdancer.bots.screeneventor;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Robot;
import java.awt.Toolkit;

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

		for (int i = 0; i < 50000; i++) {
			// r.mouseMove(rand.nextInt((int) width), rand.nextInt((int) height));
			r.mouseMove(500, 500);
		}
	}
}
