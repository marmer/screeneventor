package com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse;

import java.awt.event.InputEvent;


/**
 * Left Click Action.
 *
 * @author MarMer
 * @since  2014-11-02
 */
public class LeftClickAction extends MouseClickAction {
	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 1L;

	@Override
	public String getTypeName() {
		return "Left Mouse Click";
	}

	@Override
	protected int getMouseButtonMask() {
		return InputEvent.BUTTON1_MASK;
	}
}
