package com.asuscomm.hamsterdancer.bots.screeneventor.tryouts.jnativehooksexamples;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


/**
 * TODO: doc
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class SwingExample extends JFrame implements NativeKeyListener, WindowListener {
	/** Use serialVersionUID for interoperability. */
	private static final long serialVersionUID = 1L;

	/** Creates a new SwingExample object. */
	public SwingExample() {
		setTitle("JNativeHook Swing Example");
		setSize(300, 150);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		setVisible(true);
	}

	@Override
	public void windowOpened(final WindowEvent e) {
		// Initialze native hook.
		try {
			GlobalScreen.registerNativeHook();
		} catch (final NativeHookException ex) {
			System.err.println("There was a problem registering the native hook.");
			System.err.println(ex.getMessage());
			ex.printStackTrace();

			System.exit(1);
		}

		GlobalScreen.getInstance().addNativeKeyListener(this);
	}

	@Override
	public void windowClosed(final WindowEvent e) {
		// Clean up the native hook.
		GlobalScreen.unregisterNativeHook();
		System.runFinalization();
		System.exit(0);
	}

	@Override
	public void windowClosing(final WindowEvent e) { /* Unimplemented */
	}

	@Override
	public void windowIconified(final WindowEvent e) { /* Unimplemented */
	}

	@Override
	public void windowDeiconified(final WindowEvent e) { /* Unimplemented */
	}

	@Override
	public void windowActivated(final WindowEvent e) { /* Unimplemented */
	}

	@Override
	public void windowDeactivated(final WindowEvent e) { /* Unimplemented */
	}

	@Override
	public void nativeKeyReleased(final NativeKeyEvent e) {
		if (e.getKeyCode() == NativeKeyEvent.VC_SPACE) {
			SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						JOptionPane.showMessageDialog(
							null,
							"This will run on Swing's Event Dispatch Thread.");
					}
				});
		}
	}

	@Override
	public void nativeKeyPressed(final NativeKeyEvent e) { /* Unimplemented */
	}

	@Override
	public void nativeKeyTyped(final NativeKeyEvent e) { /* Unimplemented */
	}

	/**
	 * TODO: doc
	 *
	 * @param args TODO: doc
	 */
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					new SwingExample();
				}
			});
	}
}
