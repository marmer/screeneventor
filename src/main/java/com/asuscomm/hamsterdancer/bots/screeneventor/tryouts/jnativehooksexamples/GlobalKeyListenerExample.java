package com.asuscomm.hamsterdancer.bots.screeneventor.tryouts.jnativehooksexamples;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


/**
 * TODO: doc
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class GlobalKeyListenerExample implements NativeKeyListener {
	@Override
	public void nativeKeyPressed(final NativeKeyEvent e) {
		System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));

		if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
			GlobalScreen.unregisterNativeHook();
		}
	}

	@Override
	public void nativeKeyReleased(final NativeKeyEvent e) {
		System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void nativeKeyTyped(final NativeKeyEvent e) {
		System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
	}

	/**
	 * TODO: doc
	 *
	 * @param args TODO: doc
	 */
	public static void main(final String[] args) {
		try {
			GlobalScreen.registerNativeHook();
		} catch (final NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());

			System.exit(1);
		}

		// Construct the example object and initialze native hook.
		GlobalScreen.getInstance().addNativeKeyListener(new GlobalKeyListenerExample());
	}
}
