package com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse;

import java.awt.event.InputEvent;


/**
 * Right Click Action.
 *
 * @author MarMer
 * @since  2014-11-02
 */
public class RightClickAction extends MouseClickAction {
	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 1L;

	@Override
	public String getTypeName() {
		return "Right Mouse Click";
	}

	@Override
	protected int getMouseButtonMask() {
		return InputEvent.BUTTON2_MASK;
	}
}
