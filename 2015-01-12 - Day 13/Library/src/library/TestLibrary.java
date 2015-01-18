package library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
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
	 * Default max borrowed books per user.
	 */
	private final int DEFAULT_MAX_BORROWED_BOOKS_PER_USER = 3;

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
	 * Prepare the Test.
	 */
	@Before
	public void initalizations() {
		library = new MockLibraryImpl(LIBRARY_NAME);
		book1   = new MockBookImpl("Book 1", BOOK_1_AUTHORS);
		book2   = new MockBookImpl("Book 2", BOOK_2_AUTHORS);
	}
	
	/**
	 * Testing test initializations.
	 */
	@Test
	public void testInitializations() {
		assertEquals(LIBRARY_NAME,library.getLibrary());
		Book returnedBook = library.takeBook(BOOK_1_TITLE);
		assertNull(returnedBook);
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

	/**
	 * Test max number of books borrowed per user.
	 */
	@Test
	public void testMaxBooksBorrowed() {
		assertEquals(DEFAULT_MAX_BORROWED_BOOKS_PER_USER,library.getMaxBooksPerUser());
		library.setMaxBooksPerUser(35);
		assertEquals(35,library.getMaxBooksPerUser());
	}

	/**
	 * Take a book.
	 */
	@Test
	public void testTakeBook() {
		// Add books and take first
		library.addBook(BOOK_1_TITLE, BOOK_1_AUTHORS);
		library.addBook(BOOK_2_TITLE, BOOK_2_AUTHORS);

		// Take added book 1
		Book book = library.takeBook(BOOK_1_TITLE);
		assertEquals(book.getTitle(), this.book1.getTitle());
		verifyArray(this.book1.getAuthors(), book.getAuthors());
		assertTrue(book.isTaken());
		
		// Return book 1
		library.returnBook(book);

		// Take book 1 again
		book = library.takeBook(BOOK_1_TITLE);
		assertEquals(book.getTitle(), this.book1.getTitle());
		verifyArray(this.book1.getAuthors(), book.getAuthors());
		assertTrue(book.isTaken());
		
		// Try taking it again
		book = library.takeBook(BOOK_1_TITLE);
		assertNull(book);
	}
	
	/**
	 * Test reader count
	 */
	@Test
	public void testReaderCount() {
		assertEquals(2,library.getReaderCount());
	}
	
	/**
	 * Test book count
	 */
	@Test
	public void testBookCount() {
		assertEquals(0,library.getBookCount());
		library.addBook(BOOK_1_TITLE, BOOK_1_AUTHORS);
		assertEquals(1,library.getBookCount());
		library.addBook(BOOK_2_TITLE, BOOK_2_AUTHORS);
		assertEquals(2,library.getBookCount());
	}
	
	/**
	 * Test borrowed count
	 */
	@Test
	public void testBorrowedCount() {
		// Add books and take first
		library.addBook(BOOK_1_TITLE, BOOK_1_AUTHORS);
		library.addBook(BOOK_2_TITLE, BOOK_2_AUTHORS);

		assertEquals(0,library.getBookBorrowedCount());
		library.takeBook(BOOK_1_TITLE);
		assertEquals(1,library.getBookBorrowedCount());
		library.takeBook(BOOK_1_TITLE);
		assertEquals(1,library.getBookBorrowedCount());
		library.takeBook(BOOK_2_TITLE);
		assertEquals(2,library.getBookBorrowedCount());
		library.takeBook(BOOK_2_TITLE);
		assertEquals(2,library.getBookBorrowedCount());
		library.returnBook(book1);
		assertEquals(1,library.getBookBorrowedCount());
		library.takeBook(BOOK_1_TITLE);
		assertEquals(2,library.getBookBorrowedCount());
		library.returnBook(book1);
		library.returnBook(book2);
	}

	/**
	 * Test for a list of all users borrowing books.
	 */
	@Test
	public void testListUsersBorrowing() {
		User expected = new MockUserImpl(USER_NAME_1);
		User found[] = library.getUsersBorrowing();
		assertNotNull(found);
		assertNotNull(found[0]);
		String expectedName = expected.getName();
		String foundName = found[0].getName();
		assertEquals(expectedName, foundName);
	}

	/**
	 * Test for a list of all users.
	 */
	@Test
	public void testListUsers() {
		User expected[] = { new MockUserImpl(USER_NAME_1), new MockUserImpl(USER_NAME_2) };
		User found[] = library.getUsers();
		assertNotNull(found);
		assertNotNull(found[0]);
		assertEquals(found.length,expected.length);
		for(int i = 0; i < expected.length; i++ ) {
			assertEquals(expected[i].getName(),found[i].getName());
		}
	}

	/**
	 * Test for the user name borrowing a title.
	 */
	@Test
	public void testUsersBorrowingTitle() {
		library.addBook(BOOK_1_TITLE, BOOK_1_AUTHORS);
		library.addBook(BOOK_2_TITLE, BOOK_2_AUTHORS);
		String found    = library.getUserBorrowingTitle(BOOK_1_TITLE);
		assertNotNull(found);
		assertEquals(USER_NAME_1,found);
	}

	/**
	 * Verify the expected String array matched found SAtring array.
	 * 
	 * @param expected String array
	 * @param found String array
	 */
	private void verifyArray(String[] expected, String[] found) {
		assertTrue(found != null); 
		assertEquals(expected.length,found.length);
		
		for( int i = 0; i < expected.length; i++ ) {
			assertEquals(expected[i], found[i]);
		}
	}

}