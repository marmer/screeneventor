package com.asuscomm.hamsterdancer.bots.screeneventor;

import com.asuscomm.hamsterdancer.bots.screeneventor.actions.Action;

import org.mockito.Mockito;

import org.mockito.invocation.InvocationOnMock;

import org.mockito.stubbing.Answer;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Tests {@link ActionsScript}.
 *
 * @author MarMer
 * @since  2014-11-07
 */
public class ActionsScriptTest {
	private static final int DEFAULT_PRE_DELAY = 5;
	private Action action1;
	private Action action2;
	private ActionsScript classUnderTest;

	private int callCountAction1;
	private int callCountAction2;

	/** bforeMethod. */
	@BeforeMethod
	public void setUp() {
		callCountAction1 = 0;
		callCountAction2 = 0;

		action1 = Mockito.mock(Action.class);
		Mockito.doAnswer(new Answer() {
	   				@Override
	   				public Object answer(final InvocationOnMock invocation) throws Throwable {
	   					callCountAction1++;

	   					Thread.sleep(DEFAULT_PRE_DELAY);

	   					return null;
	   				}
	   			}).when(action1).perform();

		action2 = Mockito.mock(Action.class);
		Mockito.doAnswer(new Answer<Action>() {
	   				@Override
	   				public Action answer(final InvocationOnMock invocation) throws Throwable {
	   					callCountAction2++;

	   					Thread.sleep(DEFAULT_PRE_DELAY);

	   					return action2;
	   				}
	   			}).when(action2).perform();

		classUnderTest = new ActionsScript();
		classUnderTest.add(action1);
		classUnderTest.add(action2);
	}

	@Test(dependsOnMethods = { "setMaxExecutionTime" })
	public void setForceStopWhenTimeExpiredToFalse() {
		classUnderTest.clear();
		classUnderTest.setMaxExecutionTime(10);
		classUnderTest.setForceStopWhenTimeExpired(false);

		final int expectedNumberOfActioncallsWhenNotStopped = 100;

		for (int i = 0; i < expectedNumberOfActioncallsWhenNotStopped; i++) {
			classUnderTest.add(action1);
		}

		classUnderTest.start();

		assert expectedNumberOfActioncallsWhenNotStopped == callCountAction1 : "Expected Number of Actioncalls " +
			expectedNumberOfActioncallsWhenNotStopped + " performed action calls: " +
			callCountAction1;
	}

	@Test(dependsOnMethods = { "setMaxExecutionTime" })
	public void setForceStopWhenTimeExpiredToTrue() {
		classUnderTest.clear();
		classUnderTest.setMaxExecutionTime(10);
		classUnderTest.setForceStopWhenTimeExpired(true);

		final int expectedNumberOfActioncallsWhenNotStopped = 100;

		for (int i = 0; i < expectedNumberOfActioncallsWhenNotStopped; i++) {
			classUnderTest.add(action1);
		}

		classUnderTest.start();

		assert expectedNumberOfActioncallsWhenNotStopped > callCountAction1 : "Not expected Number of Actioncalls " +
			expectedNumberOfActioncallsWhenNotStopped + " performed action calls: " +
			callCountAction1;
	}

	@Test
	public void setMaxExecutionTime() {
		final int expectedTime = 100;
		classUnderTest.setMaxExecutionTime(expectedTime);

		final long startTime = System.currentTimeMillis();
		classUnderTest.start();

		final long timeRun = System.currentTimeMillis() - startTime;
		assertTimeRun(expectedTime, 10, timeRun);
		assert callCountAction1 > 0 : "Action 1 did not really run";
		assert callCountAction2 > 0 : "Action 2 did not really run";
	}

	@Test
	public void setMaxExecutionTimeWithMoreIterations() {
		final int expectedTime = 100;
		final int tollerance = DEFAULT_PRE_DELAY * 2;
		classUnderTest.setMaxExecutionTime(expectedTime);

		final int lessIterationsThanTimeNeeded = expectedTime;
		classUnderTest.setMaxIterations(lessIterationsThanTimeNeeded);

		final long startTime = System.currentTimeMillis();
		classUnderTest.start();

		final long timeRun = System.currentTimeMillis() - startTime;

		assertTimeRun(expectedTime, tollerance, timeRun);
		assert callCountAction1 > 0 : "Action 1 did not really run";
		assert callCountAction2 > 0 : "Action 2 did not really run";
	}

	@Test
	public void setMaxExecutionTimeWithLessIterations() {
		final int configuredTime = 10000;
		classUnderTest.setMaxExecutionTime(configuredTime);

		final int moreIterationsThanTimeNeeded = 2;
		classUnderTest.setMaxIterations(moreIterationsThanTimeNeeded);

		final long startTime = System.currentTimeMillis();
		classUnderTest.start();

		final long timeRun = System.currentTimeMillis() - startTime;

		assert timeRun < configuredTime;
		assert callCountAction1 == moreIterationsThanTimeNeeded : "Action 1 did not really run as many times as configured";
		assert callCountAction2 == moreIterationsThanTimeNeeded : "Action 2 did not really run as many times as configured";
	}

	private void assertTimeRun(final int expectedTime, final int tollerance, final long timeRun) {
		final int expectedTimeMin = expectedTime - tollerance;
		final int expectedTimeMax = expectedTime + tollerance;
		assert (expectedTimeMin <= timeRun) &&
			(timeRun <= expectedTimeMax) : "Expected execution time: " + expectedTime +
			" with tollerance: " + tollerance + " does not fit to real execution time: " + timeRun;
	}

	@Test
	public void setMaxIterations() {
		final int expectedIterationCount = 5;
		classUnderTest.setMaxIterations(expectedIterationCount);
		classUnderTest.start();
		assert callCountAction1 == expectedIterationCount : "Expected iterations: " +
			expectedIterationCount + " real iterations: " + callCountAction1;
	}

	/**
	 * stopAtMaxExecutionTimeSet.
	 *
	 * @throws InterruptedException InterruptedException
	 */
	@Test(timeOut = 5000)
	public void stopAtMaxExecutionTimeSet() throws InterruptedException {
		new Thread(new Runnable() {
				@Override
				public void run() {
					classUnderTest.start();
				}
			}).start();
		Thread.sleep(100);

		assert classUnderTest.isRunning() : "The script is not running";
		assert callCountAction1 > 0 : "no action run but at least one should";

		classUnderTest.stop();
	}

	/**
	 * stopAtMaxExecutionTimeSetWithManyIterationsSet.
	 *
	 * @throws InterruptedException InterruptedException
	 */
	@Test(timeOut = 5000)
	public void stopAtMaxExecutionTimeSetWithManyIterationsSet() throws InterruptedException {
		classUnderTest.setMaxIterations(5000000);
		new Thread(new Runnable() {
				@Override
				public void run() {
					classUnderTest.start();
				}
			}).start();
		Thread.sleep(100);

		assert classUnderTest.isRunning() : "The script is not running";
		assert callCountAction1 > 0 : "no action run but at least one should";

		classUnderTest.stop();
	}

	/**
	 * stopAtMaxExecutionTimeSetWithMuchTimeSet.
	 *
	 * @throws InterruptedException InterruptedException
	 */
	@Test(timeOut = 5000)
	public void stopAtMaxExecutionTimeSetWithMuchTimeSet() throws InterruptedException {
		classUnderTest.setMaxExecutionTime(50000000);
		new Thread(new Runnable() {
				@Override
				public void run() {
					classUnderTest.start();
				}
			}).start();
		Thread.sleep(100);

		assert classUnderTest.isRunning() : "The script is not running";
		assert callCountAction1 > 0 : "no action run but at least one should";

		classUnderTest.stop();
	}

	/** dependsOnMethods. */
	@Test(dependsOnMethods = { "setMaxExecutionTime", "setMaxIterations" })
	public void testBlockOnMultipleTiresToStart() {
		final int expectedCalls = 50;
		classUnderTest.setMaxIterations(expectedCalls);
		classUnderTest.start();
		assert callCountAction1 == expectedCalls : "expected calls: " + expectedCalls +
			" real calls " + callCountAction1;

		final int intermediateResults = callCountAction1;
		classUnderTest.setMaxIterations(0);
		classUnderTest.setMaxExecutionTime(50);
		classUnderTest.start();
		assert callCountAction1 != intermediateResults : "something should have been happening";

		final long startTime = System.currentTimeMillis();
		classUnderTest.setMaxExecutionTime(50);
		classUnderTest.start();
		classUnderTest.setForceStopWhenTimeExpired(true);
		classUnderTest.setMaxExecutionTime(50);
		classUnderTest.start();
		classUnderTest.setMaxExecutionTime(50);
		classUnderTest.start();

		final long endTime = System.currentTimeMillis();
		final long timeTaken = endTime - startTime;
		assert timeTaken >= 150 : "Blocking methods would run at least 150 ms here but the time it has taken is: " +
			timeTaken;
	}

	/** emptyScriotRun. */
	@Test(timeOut = 1000, description = "Empty Scripts should not run.")
	public void emptyScriotRun() {
		classUnderTest.clear();
		classUnderTest.start();
	}
}
