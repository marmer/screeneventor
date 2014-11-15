package com.asuscomm.hamsterdancer.bots.screeneventor.nativeinput;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Class used to suppress key events on input fields.
 *
 * @author MarMer
 * @since  15.11.2014
 */
final class KeyEventConsumer implements KeyListener {
	private static KeyEventConsumer instance;

	private KeyEventConsumer() {
		// singleton
	}

	public static KeyEventConsumer getInstance() {
		if (instance == null) {
			instance = new KeyEventConsumer();
		}

		return instance;
	}

	@Override
	public void keyTyped(final KeyEvent arg0) {
		arg0.consume();
	}

	@Override
	public void keyReleased(final KeyEvent arg0) {
		arg0.consume();
	}

	@Override
	public void keyPressed(final KeyEvent arg0) {
		arg0.consume();
	}
}
