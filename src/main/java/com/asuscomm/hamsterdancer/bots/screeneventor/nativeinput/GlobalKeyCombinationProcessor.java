package com.asuscomm.hamsterdancer.bots.screeneventor.nativeinput;

import com.asuscomm.hamsterdancer.bots.screeneventor.ScreenevatorException;

import org.apache.commons.collections4.CollectionUtils;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;


/**
 * This processor can be used.
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class GlobalKeyCombinationProcessor implements NativeKeyListener {
	private static Map<KeyCombinationListener, GlobalKeyCombinationProcessor> listeners =
		new LinkedHashMap<KeyCombinationListener, GlobalKeyCombinationProcessor>();

	static {
		java.util.logging.Logger.getLogger("org.jnativehook").setLevel(Level.OFF);
	}

	/** <key,flag>. */
	private final Map<Integer, Integer> keys;
	private boolean combinationActive;
	private final int expectedKeyFlags;
	private int currentlyPressedKeys;

	private final KeyCombinationListener listener;

	private GlobalKeyCombinationProcessor(final KeyCombinationListener listener,
		final Set<Integer> keys) {
		this.keys = new LinkedHashMap<Integer, Integer>(keys.size());

		int currentFlag = 0;
		int expectedFlags = 0;

		for (final Integer key : keys) {
			currentFlag = 1 << currentFlag++;
			this.keys.put(key, currentFlag);
			expectedFlags |= currentFlag;
		}

		expectedKeyFlags = expectedFlags;

		this.listener = listener;
	}

	/**
	 * Registers a {@link KeyCombinationListener} with some keys. Passing no key(s) or listener is
	 * like you've registered nothing.
	 *
	 * @param listener Listener to notify about changes.
	 * @param keys     Keys to listen for.
	 *
	 * @see   NativeKeyEvent
	 */
	public static void registerListener(final KeyCombinationListener listener,
		final Integer... keys) {
		final Set<Integer> cleanKeys = removeDoubles(keys);

		if (!CollectionUtils.isEmpty(cleanKeys)) {
			final GlobalScreen globalScreen = GlobalScreen.getInstance();

			synchronized (globalScreen) {
				try {
					GlobalScreen.registerNativeHook();
				} catch (final NativeHookException ex) {
					throw new ScreenevatorException(
						"There was a problem registering the native hook.",
						ex);
				}

				final GlobalKeyCombinationProcessor processor =
					new GlobalKeyCombinationProcessor(listener, cleanKeys);
				globalScreen.addNativeKeyListener(processor);
			}
		}
	}

	private static Set<Integer> removeDoubles(final Integer... keys) {
		final LinkedHashSet<Integer> cleanSet = new LinkedHashSet<Integer>(Arrays.asList(keys));
		cleanSet.remove(null); // make sure no nulls are in

		return cleanSet;
	}

	/**
	 * Removes a {@link KeyCombinationListener} again.
	 *
	 * @param listener {@link KeyCombinationListener} to remove.
	 */
	public static void removeListener(final KeyCombinationListener listener) {
		if (listener != null) {
			final GlobalScreen globalScreen = GlobalScreen.getInstance();

			synchronized (globalScreen) {
				final GlobalKeyCombinationProcessor processor = listeners.remove(listener);
				globalScreen.removeNativeKeyListener(processor);
			}
		}
	}

	@Override
	public synchronized void nativeKeyPressed(final NativeKeyEvent event) {
		final Integer flag = keys.get(event.getKeyCode());

		if (isKey(flag)) {
			set(flag);

			if (isFreshPress()) {
				activate();
			}
		}
	}

	private void activate() {
		combinationActive = true;
		listener.keyCombinationPressed(keys.keySet().toArray(new Integer[0]));
	}

	private boolean isFreshPress() {
		return !combinationActive && (expectedKeyFlags == currentlyPressedKeys);
	}

	private void set(final Integer flag) {
		currentlyPressedKeys |= flag;
	}

	@Override
	public synchronized void nativeKeyReleased(final NativeKeyEvent event) {
		final Integer flag = keys.get(event.getKeyCode());

		if (isKey(flag)) {
			if (isActive()) {
				deactivate();
			}

			unset(flag);
		}
	}

	private void deactivate() {
		listener.keyCombinationReleased(keys.keySet().toArray(new Integer[0]));
		combinationActive = false;
	}

	private boolean isActive() {
		return combinationActive && (expectedKeyFlags == currentlyPressedKeys);
	}

	private void unset(final Integer flag) {
		currentlyPressedKeys &= ~flag;
	}

	private boolean isKey(final Integer flag) {
		return flag != null;
	}

	@Override
	public void nativeKeyTyped(final NativeKeyEvent e) {
		// it's time to be ignorant (no implementationnot needed here)
	}
}
