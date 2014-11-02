package com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse;

import java.awt.event.InputEvent;


/**
 * Left press action.
 * 
 * @author MarMer
 * @since 2014-11-02
 */
public class LeftPressAction extends MousePressAction {
	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 1L;

	@Override
	protected int getMouseButtonMask() {
		return InputEvent.BUTTON1_MASK;
	}

	@Override
	public String getTypeName() {
		return "Left Mouse Press";
	}
}
