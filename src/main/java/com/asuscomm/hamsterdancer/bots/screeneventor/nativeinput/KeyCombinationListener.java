package com.asuscomm.hamsterdancer.bots.screeneventor.nativeinput;

import org.jnativehook.keyboard.NativeKeyEvent;


/**
 * Listener for global key combinations.
 *
 * @author MarMer
 * @since  2014-11-08
 */
public interface KeyCombinationListener {
	/**
	 * Method is called when a key combination was triggered.
	 *
	 * @param keys Keys of the key combination.
	 *
	 * @see   NativeKeyEvent
	 */
	void keyCombinationPressed(Integer... keys);

	/**
	 * Method is called when a key combination was triggered and is not active
	 * anymore.
	 * 
	 * @param keys
	 *            Keys of the key combination.
	 * @see NativeKeyEvent
	 */
	void keyCombinationReleased(Integer... keys);
}
