package library;

import books.Book;

public interface Library {
	/**
	 * Library Name to be returned at the Registration point.
	 * 
	 * @return Library name.
	 */
	String getLibrary();
	
	/**
	 * User id generated.
	 * 
	 * @return integer user id.
	 */
	int getId(String name);
	
	/**
	 * Adds a new book to the list of books in this library.
	 */
	void addBook(String title, String author);
	
	/**
	 * If the book is not take, marks the book as taken and returns it.
	 * If the book is take, null is returned.
	 */
	Book takeBook(String title);
	
	/**
	 * Marks the book as not taken.
	 */
	void returnBook(Book book);
	
}
