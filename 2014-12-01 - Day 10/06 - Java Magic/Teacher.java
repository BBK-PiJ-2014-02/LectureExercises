public class Teacher {
    /**
     * Teacher name
     */
    private String name;

    /**
     * Constructor
     */
    public Teacher(String name) {
		this.name = name;
	}

	/**
	 * get teacher name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Lesson name teached
	 */
    public void teach( String lessonName ) {
        System.out.println("Teaching lesson: " + lessonName);
    }
}

