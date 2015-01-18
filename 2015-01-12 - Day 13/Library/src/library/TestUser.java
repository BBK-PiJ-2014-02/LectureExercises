package library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestUser {
	/**
	 * Testing user name.
	 */
	private final String USER_NAME = "User Name";
	
	/**
	 * Testing user libraryId.
	 */
	private final int LIBRARY_ID = 13;
	
	/**
	 * The library object.
	 */
	private Library library;

	/**
	 * Library name.
	 */
	private final String LIBRARY_NAME = "Library Name";

	/**
	 * Book1.
	 */
	private Book book1;
	
	/**
	 * Book2.
	 */
	private Book book2;
	
	/**
	 * Book 1 authors.
	 */
	private final String[] BOOK_1_AUTHORS  = { "Book 1 Author 1", "Book 1 Author 2" };
	
	/**
	 * Book 1 title.
	 */
	private final String BOOK_1_TITLE  = "Book 1";
	
	/**
	 * Book 2 authors.
	 */
	private final String[] BOOK_2_AUTHORS  = { "Book 2 Author 1", "Book 2 Author 2" };
	
	/**
	 * Book 2 title.
	 */
	private final String BOOK_2_TITLE  = "Book 2";
	
	/**
	 * The User object.
	 */
	private User user;

	/**
	 * Test initializations.
	 */
	@Before
	public void initialization() {
		this.user    = new MockUserImpl(USER_NAME); 
		this.library = new MockLibraryImpl(LIBRARY_NAME);
		this.library.addBook(BOOK_1_TITLE, BOOK_1_AUTHORS);
		this.library.addBook(BOOK_2_TITLE, BOOK_2_AUTHORS);
		this.book1 = new MockBookImpl(BOOK_1_TITLE, BOOK_1_AUTHORS);
		this.book2 = new MockBookImpl(BOOK_2_TITLE, BOOK_2_AUTHORS);
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
		user.setId(LIBRARY_ID);
		assertEquals(LIBRARY_ID,user.getLibraryId());
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

	/**
	 * Test Empty Borrowed list.
	 */
	@Test
	public void testEmptyBorrowedList() {
	    assertNull(user.getBorrowed());
	}

	/**
	 * Test Borrowed list.
	 */
	@Test
	public void testBorrowedList() {
	    user.register(library);
	    assertNotNull(user.getBorrowed());
	    Book expected[] = new Book[2];
	    expected[0] = book1;
	    expected[1] = book2;
	    assertNotNull(expected);
	    assertEquals(expected[0].getTitle(), user.getBorrowed()[0].getTitle());
	    verifyBookArray(expected,user.getBorrowed());
	}

	/**
	 * Verify the expected Bookg array matched found Book array.
	 * 
	 * @param expected Book array
	 * @param found Book array
	 */
	private void verifyBookArray(Book[] expected, Book[] found) {
		assertTrue(found != null); 
		assertEquals(expected.length,found.length);
		
		for( int i = 0; i < expected.length; i++ ) {
			assertEquals(expected[i].getTitle(), found[i].getTitle());
			verifyStringArray(expected[i].getAuthors(), found[i].getAuthors());
		}
	}

	/**
	 * Verify the expected String array matched found String array.
	 * 
	 * @param expected String array
	 * @param found String array
	 */
	private void verifyStringArray(String[] expected, String[] found) {
		assertTrue(found != null); 
		assertEquals(expected.length,found.length);
		
		for( int i = 0; i < expected.length; i++ ) {
			assertEquals(expected[i], found[i]);
		}
	}
}
