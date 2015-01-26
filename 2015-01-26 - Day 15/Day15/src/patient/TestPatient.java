package patient;

import org.junit.Test;

/**
 * Testing Patient Constructor class.
 * 
 * @author vdiasf01
 *
 */
public class TestPatient {
	/**
	 * Test Patient constructor for exception on negative age.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPatientBadAge1() {
		new Patient("Name", 1200);
	}

	/**
	 * Test Patient constructor for exception on age above 130.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testPatientBadAge2() {
		new Patient("Name", 3000);
	}

	/**
	 * Test Patient constructor for good age given.
	 */
    @Test
	public void testPatientGoodAge() {
		new Patient("Name", 1985);
	}

}
