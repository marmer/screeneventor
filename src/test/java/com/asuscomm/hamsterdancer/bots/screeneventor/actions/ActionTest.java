package com.asuscomm.hamsterdancer.bots.screeneventor.actions;

import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Area;
import com.asuscomm.hamsterdancer.bots.screeneventor.geometry.Point;

import org.mockito.Mockito;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.Robot;


/**
 * General test of actions.
 *
 * <p>TODO find a way to mock {@link Robot} in test environments without a screen.</p>
 *
 * @author MarMer
 * @since  2014-11-05
 */
public class ActionTest {
	private static final String ACTION_NAME = "anyActionName";

	private boolean gotActionStart;

	private boolean gotActionEnd;

	private Action classUnderTest;

	private long actionStartRunAt;

	private long actionEndRunAt;

	@BeforeMethod
	public void setUp() {
		gotActionStart = true;
		actionStartRunAt = 0L;
		gotActionEnd = true;
		actionEndRunAt = 0L;

		classUnderTest =
			new Action() {
				/** serialVersionUID. */
				private static final long serialVersionUID = 1L;

				@Override
				protected void performActionStart() {
					gotActionStart = true;
					actionStartRunAt = System.currentTimeMillis();
				}

				@Override
				protected void performActionEnd() {
					gotActionEnd = true;
					actionEndRunAt = System.currentTimeMillis();
				}

				@Override
				public String getTypeName() {
					return ACTION_NAME;
				}
			};

		final Robot robot = Mockito.mock(Robot.class);
		Mockito.doCallRealMethod().when(robot).delay(Mockito.anyInt());

		classUnderTest.setRobot(robot);
	}

	/** testRandomPointOfAreaIsUsed. */
	@Test
	public void testRandomPointOfAreaIsUsed() {
		final Area sampleArea = Mockito.mock(Area.class);
		Mockito.when(sampleArea.getRandomPoint()).thenReturn(new Point(1, 2));
		classUnderTest.setArea(sampleArea);
		classUnderTest.perform();
		Mockito.verify(sampleArea);
	}

	/** areaNotSet. */
	@Test
	public void areaNotSet() {
		classUnderTest.setArea(null);
		classUnderTest.perform(); // expected no nullpointer (or other) exeption is thrown.
	}

	/** delayInterAndPreDelayTests. */
	@Test
	public void delayInterAndPreDelayTests() {
		final int expectedPreDelay = 100;
		final int expectedInterDelay = 200;

		classUnderTest.setPreDelay(expectedPreDelay);
		classUnderTest.setInterDelay(expectedInterDelay);

		final long startTime = System.currentTimeMillis();
		classUnderTest.perform();

		assert gotActionStart : "start part not performed";
		assert gotActionEnd : "end part not performed";

		final long startDelay = actionStartRunAt - startTime;
		final int tolerance = 5;
		assert ((expectedPreDelay - tolerance) < startDelay) &&
			(startDelay < (expectedPreDelay + tolerance));

		final long endDelay = actionEndRunAt - actionStartRunAt;
		assert ((expectedInterDelay - tolerance) < endDelay) &&
			(endDelay < (expectedInterDelay + tolerance));
	}
}
