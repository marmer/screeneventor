package com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse;

import com.asuscomm.hamsterdancer.bots.screeneventor.actions.Action;


/**
 * Mouse Press Action.
 *
 * @author MarMer
 * @since  2014-11-02
 */
public abstract class MousePressAction extends Action {
	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 1L;

	@Override
	protected void performActionEnd() {}

	protected abstract int getMouseButtonMask();

	@Override
	protected void performActionStart() {
		robot.mousePress(getMouseButtonMask());
	}
}
