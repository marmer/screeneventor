package com.asuscomm.hamsterdancer.bots.screeneventor.nativeinput;

import org.apache.commons.lang3.ArrayUtils;

import org.jnativehook.GlobalScreen;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.swing.text.JTextComponent;


/**
 * Records key combinations.
 *
 * @author MarMer
 * @since  2014-11-15
 */
public class KeyCombinationRecorder implements NativeKeyListener {
	private Set<Integer> possibleCombo = new LinkedHashSet<Integer>();
	private final Set<Integer> currentlyPressed = new LinkedHashSet<Integer>();

	private boolean lasEventWasPress = false;
	private final JTextComponent inputSource;

	/**
	 * Creates a new KeyCombinationRecorder object.
	 *
	 * @param sourceComponent Component used for key recording.
	 * @param defaultKeyCombi TODO: doc
	 */
	public KeyCombinationRecorder(final JTextComponent sourceComponent,
		final int... defaultKeyCombi) {
		inputSource = sourceComponent;

		configureKeyListening();
		suppressInputsOnSourceComponent();

		prepareDefaults(defaultKeyCombi);
	}

	private void prepareDefaults(final int... defaultKeyCombi) {
		possibleCombo.addAll(Arrays.asList(ArrayUtils.toObject(defaultKeyCombi)));
		displayPossibleComboInComponent();
	}

	private void configureKeyListening() {
		inputSource.addFocusListener(new FocusListener() {
				@Override
				public void focusGained(final FocusEvent arg0) {
					startRecording();
				}

				@Override
				public void focusLost(final FocusEvent arg0) {
					stopRecording();
				}
			});
	}

	private void suppressInputsOnSourceComponent() {
		inputSource.addKeyListener(KeyEventConsumer.getInstance());
	}

	/**
	 * The recorded keys.
	 *
	 * @return The recorded keys.
	 */
	public Integer[] getKeyCombinationToListenFor() {
		return possibleCombo.toArray(new Integer[0]);
	}

	@Override
	public synchronized void nativeKeyPressed(final NativeKeyEvent e) {
		final int keyCode = e.getKeyCode();
		currentlyPressed.add(keyCode);

		if (lasEventWasPress || possibleCombo.isEmpty()) {
			possibleCombo.add(keyCode);
		} else {
			possibleCombo = new HashSet<Integer>(currentlyPressed);
		}

		displayPossibleComboInComponent();

		lasEventWasPress = true;
	}

	/** Resets the last recorded key combo. */
	public void reset() {
		possibleCombo.clear();
		inputSource.setText("");
	}

	private void displayPossibleComboInComponent() {
		String displayText = "";
		boolean first = true;

		for (final int keyCode : possibleCombo) {
			displayText += (first ? "" : " + ") + NativeKeyEvent.getKeyText(keyCode);
			first = false;
		}

		inputSource.setText(displayText);
	}

	@Override
	public synchronized void nativeKeyReleased(final NativeKeyEvent e) {
		currentlyPressed.remove(e.getKeyCode());

		lasEventWasPress = false;
	}

	@Override
	public void nativeKeyTyped(final NativeKeyEvent e) {
		// does not matter
	}

	private void startRecording() {
		GlobalScreen.getInstance().addNativeKeyListener(this);
	}

	private void stopRecording() {
		GlobalScreen.getInstance().removeNativeKeyListener(this);
	}
}
