package library;


public class MockUserImpl implements User {
	/**
	 * Books borrowed.
	 */
	private Book[] borrowed;
	
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
	 * The user name.
	 */
	private final String name;
	
	/**
	 * Library user id.
	 */
	private int libraryId;
	
	/**
	 * Registered Library.
	 */
	private Library library;
	
	/**
	 * Constructor
	 * @param name the user name.
	 */
	public MockUserImpl(String name) {
		this.name = name;
	}
	
	/**
	 * The user library_Id.
	 */
	public int getLibraryId() {
		return this.libraryId;
	}

	/**
	 * The user name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the user id.
	 */
	public void setId(int id) {
		this.libraryId = id;
	}

	/**
	 * Register user on the Library.
	 * 
	 * Obtains the user id at this point.
	 */
	public void register(Library library) {
		this.library = library;
		this.borrowed = new Book[2];
		this.borrowed[0] = new MockBookImpl(BOOK_1_TITLE, BOOK_1_AUTHORS);
		this.borrowed[1] = new MockBookImpl(BOOK_2_TITLE, BOOK_2_AUTHORS);
	}
	
	/**
	 * Retrieves the Library registered for this user.
	 * Also sets the User id
	 */
	public String getLibrary() {
		if ( this.library == null ) {
			return null;
		}
		else {
			return "Library Name";	
		}
	}

	/**
	 * Returns a list of all borrowed books by the user.
	 */
	public Book[] getBorrowed() {
		return this.borrowed;
	}
}
