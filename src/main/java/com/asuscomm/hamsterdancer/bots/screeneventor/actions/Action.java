package com.asuscomm.hamsterdancer.bots.screeneventor.actions;

import com.asuscomm.hamsterdancer.bots.screeneventor.ScreenevatorException;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Area;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Point;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Robot;

import java.io.IOException;
import java.io.Serializable;


/**
 * Action which can be stored and performed.
 *
 * @author MarMer
 * @since  02.11.2014
 */
public abstract class Action implements Serializable, Cloneable {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Robot used to perform mouse actions. */
	protected transient Robot robot;

	/** Area the action can be performed in. */
	private Area area;

	private int preDelay;
	private int interDelay;
	private boolean cursorBack;

	private String comment;

	private transient java.awt.Point lastCursorPosition;

	/**
	 * Constructor used for tests.
	 *
	 * @param robot {@link Robot} instance to use.
	 */
	public Action(final Robot robot) {
		this.robot = robot;
	}

	/** Creates a new Action object. */
	public Action() {
		initRobot();
	}

	private void initRobot() {
		if (robot == null) {
			try {
				robot = new Robot();
			} catch (final AWTException e) {
				throw new ScreenevatorException("Not able to initialize Robot", e);
			}
		}
	}

	private void readObject(final java.io.ObjectInputStream in) throws IOException,
		ClassNotFoundException {
		in.defaultReadObject();
		initRobot();
	}

	/** Performs the action. */
	public void perform() {
		preDelay();
		remindCursorPosition();
		moveCursor();
		performActionStart();
		interDelay();
		performActionEnd();
		resetCursorPosition();
	}

	private void moveCursor() {
		if (area != null) {
			final Point point = area.getRandomPoint();
			robot.mouseMove(point.x, point.y);
		}
	}

	/** What happens at the end of an action (e.g. the key up part of a key press) */
	protected abstract void performActionEnd();

	/** What happens at the beginning of an action (e.g. the key down part of a key press) */
	protected abstract void performActionStart();

	private void preDelay() {
		robot.delay(preDelay);
	}

	private void interDelay() {
		robot.delay(interDelay);
	}

	private void resetCursorPosition() {
		if (cursorBack) {
			robot.mouseMove(lastCursorPosition.x, lastCursorPosition.y);
		}
	}

	private void remindCursorPosition() {
		if (cursorBack) {
			lastCursorPosition = MouseInfo.getPointerInfo().getLocation();
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
			cursorBack +
			", comment=" +
			comment + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((area == null) ? 0 : area.hashCode());
		result = (prime * result) + (cursorBack ? 1231 : 1237);
		result = (prime * result) + interDelay;
		result = (prime * result) + preDelay;
		result = (prime * result) + ((comment == null) ? 0 : comment.hashCode());

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

		final Action other = (Action) obj;

		if (area == null) {
			if (other.area != null) {
				return false;
			}
		} else if (!area.equals(other.area)) {
			return false;
		}

		if (cursorBack != other.cursorBack) {
			return false;
		}

		if (interDelay != other.interDelay) {
			return false;
		}

		if (preDelay != other.preDelay) {
			return false;
		}

		if (comment != other.comment) {
			return false;
		}

		return true;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(final String comment) {
		this.comment = comment;
	}
}
