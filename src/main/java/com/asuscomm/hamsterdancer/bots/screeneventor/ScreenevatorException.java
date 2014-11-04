package com.asuscomm.hamsterdancer.bots.screeneventor;

/**
 * Can be thrown by temporary lazy developers.
 *
 * @author MarMer
 * @since  2014-11-04
 */
public class ScreenevatorException extends RuntimeException {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** @see RuntimeException#RuntimeException() */
	public ScreenevatorException() {
		super();
	}

	/** @see RuntimeException#RuntimeException(String, Throwable) */
	public ScreenevatorException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/** @see RuntimeException#RuntimeException(String) */
	public ScreenevatorException(final String message) {
		super(message);
	}

	/** @see RuntimeException#RuntimeException( Throwable) */
	public ScreenevatorException(final Throwable cause) {
		super(cause);
	}
}
