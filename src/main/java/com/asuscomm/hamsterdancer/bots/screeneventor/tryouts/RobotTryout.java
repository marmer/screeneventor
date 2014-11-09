package com.asuscomm.hamsterdancer.bots.screeneventor.tryouts;

import com.asuscomm.hamsterdancer.bots.screeneventor.ActionsScript;
import com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse.LeftClickAction;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Point;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Rectangle;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


/**
 * Just a tryout class.
 *
 * @author MarMer
 * @since  2014-10-30
 */
public class RobotTryout {
	/**
	 * Just main.
	 *
	 * @param  args just args
	 *
	 * @throws AWTException just an exception
	 */
	public static void main(final String[] args) throws AWTException {
		final Robot r = new Robot();

		//
		// r.setAutoDelay(0);
		//
		// final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); final double
		// width = screenSize.getWidth(); final double height = screenSize.getHeight();
		//
		// System.out.println(width); System.out.println(height);
		//
		// final int widthMin = 3000; // final int widthMax = 3250; // final int heightMin = 400; //
		// final int heightMax = 700;
		final int left = 2950;
		final int right = 3300;
		final int top = 400;
		final int bottom = 725;

		//
		final double timeToClickInMin = 0.75;
		final double timeToClickInSec = timeToClickInMin * 60; // approximately
		final int timeToClickInMs = (int) timeToClickInSec * 1000;
		final int delay = 10;

		final LeftClickAction lca = new LeftClickAction();
		lca.setArea(new Rectangle(new Point(left, bottom), new Point(right, top)));
		lca.setPreDelay(delay);

		final ActionsScript script = new ActionsScript();
		script.setMaxExecutionTime(timeToClickInMs);

		script.add(lca);

		script.start();

		performClick(r, 1000, 500);
	}

	private static void moveMouse(final Robot r, final Point point) {
		r.mouseMove(point.x, point.y);
	}

	private static void performClick(final Robot r, final Point point) {
		performClick(r, point.x, point.y);
	}

	private static void performClick(final Robot r, final int x, final int y) {
		r.mouseMove(x, y);
		performClick(r);
	}

	private static void performClick(final Robot r) {
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
	}
}
