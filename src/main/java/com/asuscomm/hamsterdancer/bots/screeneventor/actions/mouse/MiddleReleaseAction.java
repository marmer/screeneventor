package com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse;

import java.awt.event.InputEvent;


/**
 * Middle release action.
 *
 * @author MarMer
 * @since  2014-11-02
 */
public class MiddleReleaseAction extends MouseReleaseAction {
	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 1L;

	@Override
	protected int getMouseButtonMask() {
		return InputEvent.BUTTON3_MASK;
	}

	@Override
	public String getTypeName() {
		return "Middle Mouse Release";
	}
}
