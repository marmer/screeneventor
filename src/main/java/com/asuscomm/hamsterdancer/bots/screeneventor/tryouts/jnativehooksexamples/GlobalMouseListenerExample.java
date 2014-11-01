package com.asuscomm.hamsterdancer.bots.screeneventor.tryouts.jnativehooksexamples;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;


/**
 * TODO: doc
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class GlobalMouseListenerExample implements NativeMouseInputListener {
	@Override
	public void nativeMouseClicked(final NativeMouseEvent e) {
		System.out.println("Mosue Clicked: " + e.getClickCount());
	}

	@Override
	public void nativeMousePressed(final NativeMouseEvent e) {
		System.out.println("Mosue Pressed: " + e.getButton());
	}

	@Override
	public void nativeMouseReleased(final NativeMouseEvent e) {
		System.out.println("Mosue Released: " + e.getButton());
	}

	@Override
	public void nativeMouseMoved(final NativeMouseEvent e) {
		System.out.println("Mosue Moved: " + e.getX() + ", " + e.getY());
	}

	@Override
	public void nativeMouseDragged(final NativeMouseEvent e) {
		System.out.println("Mosue Dragged: " + e.getX() + ", " + e.getY());
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

		// Construct the example object.
		final GlobalMouseListenerExample example = new GlobalMouseListenerExample();

		// Add the appropriate listeners for the example object.
		GlobalScreen.getInstance().addNativeMouseListener(example);
		GlobalScreen.getInstance().addNativeMouseMotionListener(example);
	}
}
