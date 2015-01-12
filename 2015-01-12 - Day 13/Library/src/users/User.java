package users;

import library.Library;

public interface User {
	/**
	 * User id.
	 * 
	 * @return integer id.
	 */
	int getId();
	
	/**
	 * User name.
	 * 
	 * @return String name.
	 */
	String getName();
	
	/**
	 * Set user id.
	 */
	void setId(int id);
	
	/**
	 * Register user on the Library.
	 * 
	 * Obtains the user id at this point.
	 */
	void register(Library library);
	
	/**
	 * Retrieves the Library registered for this user.
	 */
	String getLibrary();
}
