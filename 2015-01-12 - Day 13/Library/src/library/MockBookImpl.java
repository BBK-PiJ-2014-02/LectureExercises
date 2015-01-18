package library;

public class MockBookImpl implements Book {

	/**
	 * Flag set to true if book is borrowed/taken.
	 */
	private boolean isTaken;

	/**
	 * The book title.
	 */
	private final String title;

	/**
	 * The book authors.
	 */
	private final String authors[];
	
	/**
	 * Book constructor.
	 * 
	 * @param title String title
	 * @param authors String[] authors
	 */
	public MockBookImpl(String title, String[] authors) {
		this.title = title;
		this.authors = authors;
		this.isTaken = false;
	}
	
	/**
	 * The book title.
	 * 
	 * @return book title
	 */
	public String getTitle() {
		return this.title;
	}

    /**
     * The book authors.
     * 
     * @return String[] all book authors.
     */
	public String[] getAuthors() {
		return this.authors;
	}

	/**
	 * Check if the book is taken.
	 * 
	 * @return true if taken.
	 */
	public boolean isTaken() {
		return this.isTaken;
	}

	/**
	 * Sets the book as taken or not taken.
	 * 
	 * @param taken if borrowed.
	 */
	public void setTaken(boolean taken) {
		this.isTaken = taken;
	}

}
