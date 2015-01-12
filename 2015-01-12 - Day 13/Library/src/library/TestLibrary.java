package library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestLibrary {
	/**
	 * Library Name.
	 */
	private final String LIBRARY_NAME = "British Library";
	
	/**
	 * User Name 1.
	 */
	private final String USER_NAME_1 = "User Name 1";
	
	/**
	 * User Name 2.
	 */
	private final String USER_NAME_2 = "User Name 2";
	
	/**
	 * UserId 1.
	 */
	private final int USER_ID_1 = 25;
	
	/**
	 * User Name 2.
	 */
	private final int USER_ID_2 = 421;
	
	/**
	 * Library object.
	 */
	private Library library;
	
	/**
	 * Prepare the Test.
	 */
	@Before
	public void initalizations() {
		this.library = new MockLibraryImpl(LIBRARY_NAME);
	}
	
	/**
	 * Testing test initializations.
	 */
	@Test
	public void testInitializations() {
		assertEquals(LIBRARY_NAME,library.getLibrary());
	}
	
	/**
	 * Test getId().
	 */
	@Test
	public void testGetId() {
		assertEquals(USER_ID_1,library.getId(USER_NAME_1));
		assertEquals(USER_ID_2,library.getId(USER_NAME_2));
		assertTrue(USER_ID_1 == library.getId(USER_NAME_1));
		assertTrue(USER_ID_2 == library.getId(USER_NAME_2));
	}

}
