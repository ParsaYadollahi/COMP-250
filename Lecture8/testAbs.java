package Lecture8;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class testAbs {

	@Test
	public void testAbs() {
		assertEquals(1, Math.abs(-1));
	}
	@Test
	public void testone() {
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
