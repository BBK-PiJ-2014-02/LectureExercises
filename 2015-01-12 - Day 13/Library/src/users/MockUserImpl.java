package users;

import library.Library;

public class MockUserImpl implements User {

	/**
	 * The user name.
	 */
	private final String name;
	
	/**
	 * Library user id.
	 */
	private int id;
	
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
	 * The user Id.
	 */
	public int getId() {
		return this.id;
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
		this.id = id;
	}

	/**
	 * Register user on the Library.
	 * 
	 * Obtains the user id at this point.
	 */
	public void register(Library library) {
		this.library = library;
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
}
