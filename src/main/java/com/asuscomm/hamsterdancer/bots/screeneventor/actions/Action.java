package com.asuscomm.hamsterdancer.bots.screeneventor.actions;

import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Area;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Point;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

import java.io.Serializable;


/**
 * Action which can be stored and performed.
 *
 * @author MarMer
 * @since  02.11.2014
 */
public abstract class Action implements Serializable {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Area the action can be performed in. */
	private Area area;

	private int preDelay;
	private int interDelay;
	private boolean cursorBack;

	private transient Robot robot;

	private transient java.awt.Point lastMousePosition;

	protected Robot getRobot() {
		if (robot == null) {
			try {
				robot = new Robot();
			} catch (final AWTException e) {
				// TODO handle me
			}
		}

		return robot;
	}

	/** Performs the action. */
	public final void perform() {
		remindCursorPosition();
		moveCursor();
		preDelay();
		performActionStart();
		interDelay();
		performActionEnd();
		resetCursorPosition();
	}

	private void moveCursor() {
		if (area != null) {
			final Point point = area.getRandomPoint();
			getRobot().mouseMove(point.x, point.y);
		}
	}

	/** What happens at the end of an action (e.g. the key up part of a key press) */
	protected abstract void performActionEnd();

	/** What happens at the beginning of an action (e.g. the key down part of a key press) */
	protected abstract void performActionStart();

	private void preDelay() {
		getRobot().delay(preDelay);
	}

	private void interDelay() {
		getRobot().delay(interDelay);
	}

	private void resetCursorPosition() {
		if (cursorBack) {
			robot.mouseMove(lastMousePosition.x, lastMousePosition.y);
		}
	}

	private void remindCursorPosition() {
		if (cursorBack) {
			lastMousePosition = MouseInfo.getPointerInfo().getLocation();
		}
	}

	/**
	 * Returns a name for the type.
	 *
	 * @return Returns a name for the type.
	 */
	public abstract String getTypeName();

	public Area getArea() {
		return area;
	}

	public void setArea(final Area area) {
		this.area = area;
	}

	public int getPreDelay() {
		return preDelay;
	}

	public void setPreDelay(final int delay) {
		preDelay = delay;
	}

	public int getInterDelay() {
		return interDelay;
	}

	public void setInterDelay(final int interDelay) {
		this.interDelay = interDelay;
	}

	public boolean isCursorBack() {
		return cursorBack;
	}

	public void setCursorBack(final boolean cursorBack) {
		this.cursorBack = cursorBack;
	}

	@Override
	public String toString() {
		return "Action [type=" + getTypeName() + "area=" + area + ", preDelay=" + preDelay +
			", interDelay=" + interDelay +
			", cursorBack=" +
			cursorBack + "]";
	}
}
