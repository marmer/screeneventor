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

	private transient int currentIteration;
	private transient long startTime;

	/** Starts the script. */
	public synchronized void start() {
		initExecution();

		while (isRunning()) {
			performIteration();
			currentIteration++;
		}
	}

	private void performIteration() {
		for (final Action currentAction : this) {
			if (isForceStopWhenTimeExpired() && !isTimeLeft()) {
				break;
			}

			currentAction.perform();
		}
	}

	private void initExecution() {
		startTime = System.currentTimeMillis();
		currentIteration = 0;
		running = true;
	}

	private boolean isIterationLeft() {
		return (maxIterations <= 0) || (currentIteration < maxIterations);
	}

	private boolean isTimeLeft() {
		final boolean maxTimeConfigured = maxExecutionTime <= 0;

		return maxTimeConfigured ? true
								 : ((System.currentTimeMillis() - startTime) < maxExecutionTime);
	}

	/**
	 * Stops the execution of the script. Calling {@link #start()} lets the script run from the
	 * beginning again.
	 */
	public void stop() {
		running = false;
	}

	public boolean isRunning() {
		running = running && (isTimeLeft() && isIterationLeft());

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
	 * @param forceStopWhenTimeExpired True when you want the script to stop right after the
	 *                                 {@link #maxExecutionTime} has been expired.
	 */
	public void setForceStopWhenTimeExpired(final boolean forceStopWhenTimeExpired) {
		this.forceStopWhenTimeExpired = forceStopWhenTimeExpired;
	}

	@Override
	public Object clone() {
		final ActionsScript clone = (ActionsScript) super.clone();

		clone.maxExecutionTime = maxExecutionTime;
		clone.maxIterations = maxIterations;
		clone.forceStopWhenTimeExpired = forceStopWhenTimeExpired;

		return clone;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = (prime * result) + (forceStopWhenTimeExpired ? 1231 : 1237);
		result = (prime * result) + maxExecutionTime;
		result = (prime * result) + maxIterations;

		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}

		if (!super.equals(obj)) {
			return false;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		final ActionsScript other = (ActionsScript) obj;

		if (forceStopWhenTimeExpired != other.forceStopWhenTimeExpired) {
			return false;
		}

		if (maxExecutionTime != other.maxExecutionTime) {
			return false;
		}

		if (maxIterations != other.maxIterations) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "ActionsScript [maxExecutionTime=" + maxExecutionTime +
			", maxIterations=" + maxIterations +
			", forceStopWhenTimeExpired=" + forceStopWhenTimeExpired +
			", actions=" + super.toString() +
			"]";
	}
}
