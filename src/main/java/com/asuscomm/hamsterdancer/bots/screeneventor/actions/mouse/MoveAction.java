package com.asuscomm.hamsterdancer.bots.screeneventor.actions.mouse;

import com.asuscomm.hamsterdancer.bots.screeneventor.actions.Action;

/**
 * Left Click Action.
 *
 * @author MarMer
 * @since 2014-11-02
 */
public class MoveAction extends Action {
	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 1L;

	@Override
	public String getTypeName() {
		return "Mouse Move";
	}

	@Override
	protected void performActionEnd() {
	}

	@Override
	protected void performActionStart() {
	}

}
