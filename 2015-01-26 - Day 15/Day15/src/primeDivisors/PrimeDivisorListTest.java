package primeDivisors;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests for PrimeDivisors
 * 
 * @author vdiasf01
 *
 */
public class PrimeDivisorListTest {

	/**
	 * Test NullPointerExceptions when adding null
	 */
	@Test(expected=NullPointerException.class)
	public void testAddNull() {
		PrimeDivisorList pdl = new PrimeDivisorListImpl();
		pdl.add(null);
	}
	
	/**
	 * Test non-prime number added exception
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testNonPrimeAdd() {
		PrimeDivisorList pdl = new PrimeDivisorListImpl();
		pdl.add(6);
	}

	/**
	 * Test toString
	 */
	@Test()
	public void testToString() {
		// Expected String
		String expected = "[ 2 * 3^2 * 7 = 126 ]";
		
		PrimeDivisorList pdl = new PrimeDivisorListImpl();
		// Add required prime numbers for the above expected string.
		pdl.add(2);
		pdl.add(3);
		pdl.add(3);
		pdl.add(7);
		
		// An now the checkS
		assertEquals(expected, pdl.toString());
	}
}
