package library;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestBook {

	/**
	 * Testing title.
	 */
	private final String TITLE = "Book Title";
	
	/**
	 * Testing book authors.
	 */
	private final String[] AUTHORS = { "Author 1", "Author 2" };

    /**
     * Book Testing Object
     */
	private Book book;
	
	@Before
	public void initializations() {
		this.book = new MockBookImpl(TITLE, AUTHORS); 
	}
	
	/**
	 * Test Book getTitle and authors.
	 */
	@Test
	public void testBookInitializations() {
		assertEquals(TITLE, book.getTitle());
		verifyArray(AUTHORS, book.getAuthors());
	}
	
	/**
	 * Test if book is taken.
	 */
	@Test
	public void testIsTaken() {
		assertFalse(book.isTaken());
		book.setTaken(true);
		assertTrue(book.isTaken());
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
