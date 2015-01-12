package books;

public class MockBookImpl implements Book {

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

}
