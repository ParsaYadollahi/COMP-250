package l8;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class testAbs {

	@Test
	public void testAbsolute() {
		assertEquals(1, Math.abs(-1));
	}
	@Test
	public void testOne() {
		assertEquals(1, Math.abs(1));
	}
	@Test
	public void testMax() {
		assertEquals(Integer.MAX_VALUE, Math.abs(Integer.MAX_VALUE));
	}
	// Quirk for min and max values, fails test
	@Test
	public void testMin() {
		assertEquals(Integer.MIN_VALUE, Math.abs(Integer.MAX_VALUE));
	}
}
