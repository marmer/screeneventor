package com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse;

import java.awt.event.InputEvent;


/**
 * Right press action.
 *
 * @author MarMer
 * @since  2014-11-02
 */
public class RightPressAction extends MousePressAction {
	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 1L;

	@Override
	protected int getMouseButtonMask() {
		return InputEvent.BUTTON2_MASK;
	}

	@Override
	public String getTypeName() {
		return "Right Mouse Press";
	}
}
