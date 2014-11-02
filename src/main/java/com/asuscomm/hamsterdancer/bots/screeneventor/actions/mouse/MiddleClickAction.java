package com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse;

import java.awt.event.InputEvent;


/**
 * Middle Click Action.
 *
 * @author MarMer
 * @since  2014-11-02
 */
public class MiddleClickAction extends MouseClickAction {
	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 1L;

	@Override
	public String getTypeName() {
		return "Middle Mouse Click";
	}

	@Override
	protected int getMouseButtonMask() {
		return InputEvent.BUTTON3_MASK;
	}
}
