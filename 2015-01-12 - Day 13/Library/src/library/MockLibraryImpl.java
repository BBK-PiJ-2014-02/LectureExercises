package library;

import books.Book;
import books.MockBookImpl;

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
	 * Library Name
	 */
	private final String libraryName;

	/**
	 * Maximum number of book borrowed per user.
	 */
	private int MAX_NUMBER_BOOKS_PER_PERSON;
	
	/**
	 * Constructor. 
	 * 
	 * @param libraryName
	 */
	public MockLibraryImpl(String libraryName) {
		this.libraryName = libraryName;
		this.MAX_NUMBER_BOOKS_PER_PERSON = 3;
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
	public void addBook(String title, String author) {
		
	}
	
	/**
	 * If the book is not take, marks the book as taken and returns it.
	 * If the book is take, null is returned.
	 */
	public Book takeBook(String title) {
		String[] authors = {"e", "e"};
		Book book = new MockBookImpl(title, authors);
		return book;
	}
	
	/**
	 * Marks the book as not taken.
	 */
	public void returnBook(Book book) {
		// TODO Auto-generated method stub
		
	}
}
