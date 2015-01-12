package users;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import library.Library;
import library.MockLibraryImpl;

import org.junit.Before;
import org.junit.Test;

public class TestUser {
	/**
	 * Testing user name.
	 */
	private final String USER_NAME = "User Name";
	
	/**
	 * Testing user id.
	 */
	private final int ID = 13;
	
	/**
	 * The library object.
	 */
	private Library library;

	/**
	 * Library name.
	 */
	private final String LIBRARY_NAME = "Library Name";
	
	/**
	 * The User object.
	 */
	private User user;

	/**
	 * Test initializations.
	 */
	@Before
	public void initialization() {
		this.user = new MockUserImpl(USER_NAME); 
		this.library = new MockLibraryImpl(LIBRARY_NAME);
	}

	/**
	 * Test user name.
	 */
	@Test
	public void testUserName() {
		assertEquals(USER_NAME,user.getName());
	}

	/**
	 * Test user id.
	 */
	@Test
	public void testUserId() {
		user.setId(ID);
		assertEquals(ID,user.getId());
	}

	/**
	 * Test unregistered user.
	 */
	@Test
	public void testUnregisteredUser() {
		assertNull(null,user.getLibrary());
	}

	/**
	 * Test Library registration.
	 */
	@Test
	public void testUserRegistration() {
	    user.register(library);
    	assertEquals(LIBRARY_NAME,user.getLibrary());
	}
}
