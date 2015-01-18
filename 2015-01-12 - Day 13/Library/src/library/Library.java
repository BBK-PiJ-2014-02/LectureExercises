package library;


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
	void addBook(String title, String[] authors);
	
    /**
     * Set the number of maximum allowed books to be borrowed per user.
     */
	void setMaxBooksPerUser(int max);
	
	/**
	 * Get the number of maximum allowed books set to be borrowed per user.
	 * 
	 * @return the maximum allowed books borrowed per user.
	 */
	int getMaxBooksPerUser();
	
	/**
	 * If the book is not take, marks the book as taken and returns it.
	 * If the book is taken, null is returned.
	 */
	Book takeBook(String title);
	
	/**
	 * Marks the book as not taken.
	 */
	void returnBook(Book book);
	
    /**
     * The number of users registered in this Library.
     * 
     * @return number of users registered in Library
     */
	int getReaderCount();
	
	/**
	 * The number of books in this Library.
	 * 
	 * @return number of books in Library 
	 */
	int getBookCount();
	
	/**
	 * This number of borrowed books in library.
	 * 
	 * @return number of borrowed books in Library
	 */
	int getBookBorrowedCount();

    /**
     * Return a list of all users borrowing books.
     * 
     * @return User list borrowing.
     */
	User[] getUsersBorrowing();
	
	/**
	 * Return a list of all users.
	 * 
	 * @return User list of all users
	 */
	User[] getUsers();
	
	/**
	 * Return the name of the user borrowing a title.
	 * 
	 * @param title String book title
	 * @Return String User name
	 */
	String getUserBorrowingTitle(String title);
	
}
