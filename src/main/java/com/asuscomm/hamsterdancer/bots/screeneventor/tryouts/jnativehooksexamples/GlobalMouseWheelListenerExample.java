package com.asuscomm.hamsterdancer.bots.screeneventor.tryouts.jnativehooksexamples;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;


/**
 * TODO: doc
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class GlobalMouseWheelListenerExample implements NativeMouseWheelListener {
	@Override
	public void nativeMouseWheelMoved(final NativeMouseWheelEvent e) {
		System.out.println("Mosue Wheel Moved: " + e.getWheelRotation());
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
			ex.printStackTrace();

			System.exit(1);
		}

		// Construct the example object and initialze native hook.
		GlobalScreen
		.getInstance().addNativeMouseWheelListener(new GlobalMouseWheelListenerExample());
	}
}
