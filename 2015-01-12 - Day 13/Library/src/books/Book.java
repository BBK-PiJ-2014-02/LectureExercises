package books;

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
}
