package com.asuscomm.hamsterdancer.bots.screeneventor.geometry;

import org.testng.annotations.Test;


/**
 * Testclass for {@link Point}.
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class PointTest {
	@Test
	public void getDistanceNoDistance() {
		assert 0 == new Point(0, 0).getDistance(new Point(0, 0));
	}

	/** toStringTest. */
	@Test
	public void toStringTest() {
		assert "Point [1,2]".equals(new Point(1, 2).toString());
	}

	/**equalsTestEqual*/
	@Test
	public void equalsTestEqual() {
		assert new Point(1, 2).equals(new Point(1, 2));
	}

	/**equalsTestUnequal*/
	@Test
	public void equalsTestUnequal() {
		assert !new Point(2, 1).equals(new Point(1, 2));
	}
}
