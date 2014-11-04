package com.asuscomm.hamsterdancer.bots.screeneventor;

import com.asuscomm.hamsterdancer.bots.screeneventor.actions.Action;

import java.io.Serializable;

import java.util.ArrayList;


/**
 * Executable Script of Actions.
 *
 * @author MarMer
 * @since  2014-11-04
 */
public class ActionsScript extends ArrayList<Action> implements Serializable {
	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	private transient boolean running;

	private int maxExecutionTime;
	private int maxIterations;
	private boolean forceStopWhenTimeExpired = false;

	/**
	 * starts and stops the script.
	 *
	 * @return True if the script is running after calling the method or false if it is not.
	 */
	public synchronized boolean startStop() {
		return false;
	}

	public synchronized boolean isRunning() {
		return running;
	}

	public void setMaxExecutionTime(final int timeInMs) {
		maxExecutionTime = timeInMs;
	}

	public int getMaxExecutionTime() {
		return maxExecutionTime;
	}

	public void setMaxIterations(final int maxIterations) {
		this.maxIterations = (maxIterations < 0) ? 1 : maxIterations;
	}

	public int getMaxIterations() {
		return maxIterations;
	}

	public boolean isForceStopWhenTimeExpired() {
		return forceStopWhenTimeExpired;
	}

	/**
	 * Switch which decides whether the script stops immediately when the execution time is expired
	 * or whether to finish the current iteration first.
	 *
	 * @param forceStopWhenTimeExpired TODO: doc
	 */
	public void setForceStopWhenTimeExpired(final boolean forceStopWhenTimeExpired) {
		this.forceStopWhenTimeExpired = forceStopWhenTimeExpired;
	}
}
