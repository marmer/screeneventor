package com.asuscomm.hamsterdancer.bots.screeneventor.geometry;

import org.testng.annotations.Test;


/**
 * TODO: doc
 *
 * @author MarMer
 * @since  2014-11-01
 */
public class RectangleTest {
	/** equalsTest. */
	@Test
	public void equalsTest() {
		assert new Rectangle(1, 2, 3, 4).equals(new Rectangle(1, 2, 3, 4)) : "Really equal";
		assert new Rectangle(1, 2, 3, 4).equals(new Rectangle(3, 4, 1, 2)) : "Switched corners";

		assert new Rectangle(1, 2, 3, 4).equals(new Rectangle(1, 4, 3, 2)) : "Not named corners";
		assert new Rectangle(1, 2, 3, 4).equals(new Rectangle(3, 2, 1, 4)) : "Not named corners switched";
	}

	/** hashCodeTest. */
	@Test
	public void hashCodeTest() {
		assert new Rectangle(1, 2, 3, 4).hashCode() == new Rectangle(1, 2, 3, 4).hashCode() : "Really equal";
		assert new Rectangle(1, 2, 3, 4).hashCode() == new Rectangle(3, 4, 1, 2).hashCode() : "Switched corners";

		assert new Rectangle(1, 2, 3, 4).hashCode() == new Rectangle(1, 4, 3, 2).hashCode() : "Not named corners";
		assert new Rectangle(1, 2, 3, 4).hashCode() == new Rectangle(3, 2, 1, 4).hashCode() : "Not named corners switched";
	}

	@Test
	public void isInArea() {
		assert new Rectangle(0, 0, 0, 0).isInArea(0, 0);
	}

	/** toStringTest. */
	@Test
	public void toStringTest() {
		assert "Rectangle [[1,2],[3,4]]".equals(new Rectangle(1, 2, 3, 4)
		        .toString());
	}
}
