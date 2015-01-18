package library;


public class MockLibraryImpl implements Library {
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
	 * Book 1 title.
	 */
	private final String BOOK_1_TITLE  = "Book 1";
	
	/**
	 * Book 2 title.
	 */
	private final String BOOK_2_TITLE  = "Book 2";
	
	/**
	 * Library Name
	 */
	private final String libraryName;

	/**
	 * Books in library
	 */
	private Book[] libraryBooks;
	
	/**
	 * Maximum number of book borrowed per user.
	 */
	private int MAX_NUMBER_BOOKS_PER_PERSON = 3;
	
	/**
	 * Book count
	 */
	private int bookCount;
	
	/**
	 * User count
	 */
	private int userCount;
	
	/**
	 * Books borrowed count
	 */
	private int borrowedCount;
	
	/**
	 * Constructor. 
	 * 
	 * @param libraryName
	 */
	public MockLibraryImpl(String libraryName) {
		this.libraryName = libraryName;
		this.libraryBooks = null;
		this.userCount = 2;
	}

	/**
	 * The library name.
	 */
	public String getLibrary() {
		return this.libraryName;
	}

	/**
	 * Maximum borrowing allowance per user.
	 */
	public int getMaxBooksPerUser() {
		return this.MAX_NUMBER_BOOKS_PER_PERSON;
	}

	/**
	 * Maximum borrowing allowance per user.
	 */
	public void setMaxBooksPerUser(int max) {
		this.MAX_NUMBER_BOOKS_PER_PERSON = max;
	}

	/**
	 * Generated id unique to the library
	 */
	public int getId(String name) {
		if ( name == null ) {
			return 0;
		}
		
		if ( USER_NAME_1.equals(name) ) {
			return USER_ID_1;
		}
		else if ( USER_NAME_2.equals(name) ) {
			return USER_ID_2;
		}
		
		return 0;
	}
	
	/**
	 * Adds a new book to the list of books in this library.
	 */
	public void addBook(String title, String[] authors) {
		if ( this.libraryBooks == null ) {
			this.libraryBooks = new Book[1];
			this.libraryBooks[0] = new MockBookImpl(title, authors);
		}
		else {
			Book[] newBooks = new Book[this.libraryBooks.length+1];
			for(int i = 0; i < this.libraryBooks.length; i++) {
				newBooks[i] = this.libraryBooks[i];
			}
			this.libraryBooks = newBooks;
			this.libraryBooks[this.libraryBooks.length-1] = new MockBookImpl(title, authors);
		}
		this.bookCount++;
	}
	
	/**
	 * If the book is not taken, marks the book as taken and returns it.
	 * If the book is take, null is returned.
	 * 
	 * @param title of the book
	 * @return Book
	 */
	public Book takeBook(String title) {
		Book book = getBook(title);
		if ( book == null ) {
			return null;
		}
		else if ( book.isTaken() ) {
			return null;
		}
		else {
			this.borrowedCount++;
			book.setTaken(true);;
			return book;
		}
	}
	
	/**
	 * Internal method to search through the Library for the book
	 * given by its title.
	 * 
	 * @param title for the book.
	 * @return Book
	 */
	private Book getBook(String title) {
		if ( title == null ) {
			return null;
		}
		else {
			if ( this.libraryBooks == null ) {
				return null;
			}
			for( int i = 0; i < this.libraryBooks.length; i++ ) {
				Book b = this.libraryBooks[i];
				if ( b.getTitle().equals(title) ) {
					return b;
				}
			}
		}
		
		return null;
	}
	
	/**
	 * Marks the book as not taken.
	 */
	public void returnBook(Book book) {
		if ( book == null ) {
			return;
		}
		String title = book.getTitle();
		Book bookInLibrary = getBook(title);
		
		if ( bookInLibrary != null ) {
			for( int i = 0; i < this.libraryBooks.length; i++ ) {
				Book b = this.libraryBooks[i];
				if ( b.getTitle().equals(title) ) {
					libraryBooks[i].setTaken(false);
					this.borrowedCount--;
					return;
				}
			}
		}
	}

    /**
     * The number of users registered in this Library.
     * 
     * @return number of users registered in Library
     */
	public int getReaderCount() {
		return this.userCount;
	}

	/**
	 * The number of books in this Library.
	 * 
	 * @return number of books in Library 
	 */
	public int getBookCount() {
		return this.bookCount;
	}

	/**
	 * This number of borrowed books in library.
	 * 
	 * @return number of borrowed books in Library
	 */
	public int getBookBorrowedCount() {
		return this.borrowedCount;
	}

	/**
	 * List of all users currently borrowing books.
	 * 
	 * @return User list.
	 */
	public User[] getUsersBorrowing() {
		User users[] = { new MockUserImpl(USER_NAME_1) };
		return users;
	}

	/**
	 * List of all users.
	 * 
	 * @return User list.
	 */
	public User[] getUsers() {
		User users[] = { new MockUserImpl(USER_NAME_1), new MockUserImpl(USER_NAME_2) };
		return users;
	}

	/**
	 * User name of the user borrowing a given title.
	 * 
	 * @param title String book.
	 * @return User name String
	 */
	public String getUserBorrowingTitle(String title) {
		// No title supplied
		if ( title == null ) {
			return null;
		}

		// Title not in Library
		Book book = this.getBook(title);
		if ( book == null ) {
			return null;
		}
		
		// Mock: if title == title 1, return user 1.
		if ( title.equals(BOOK_1_TITLE) ) {
			return USER_NAME_1;
		}
		
		if ( title.equals(BOOK_2_TITLE) ) {
			return USER_NAME_2;
		}
		
		return null;
	}
}
