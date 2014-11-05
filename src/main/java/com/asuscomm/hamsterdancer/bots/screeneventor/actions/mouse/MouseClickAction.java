package com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse;

import com.asuscomm.hamsterdancer.bots.screeneventor.actions.Action;


/**
 * Mouse Click Action.
 *
 * @author MarMer
 * @since  2014-11-02
 */
public abstract class MouseClickAction extends Action {
	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 1L;

	@Override
	protected void performActionEnd() {
		robot.mouseRelease(getMouseButtonMask());
	}

	protected abstract int getMouseButtonMask();

	@Override
	protected void performActionStart() {
		robot.mousePress(getMouseButtonMask());
	}
}
