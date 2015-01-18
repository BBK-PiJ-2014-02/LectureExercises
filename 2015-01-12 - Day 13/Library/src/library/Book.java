package library;

/**
 * Book Class
 * 
 * @author vdiasf01
 *
 */
public interface Book {

	/**
	 * The book title.
	 * 
	 * @return the title String
	 */
	String getTitle();
	
	/**
	 * The book author list.
	 * 
	 * @return list of author Strings
	 */
	String[] getAuthors();
	
	/**
	 * Check is the book is marked as taken.
	 * 
	 * @return true if taken.
	 */
	boolean isTaken();
	
	/**
	 * Sets the book as taken / borrowed.
	 */
	void setTaken(boolean taken);
}
