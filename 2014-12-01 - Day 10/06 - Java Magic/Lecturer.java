public class Lecturer extends Teacher {
	/**
	 * Constructor
	 */
	public Lecturer(String name) {
		super(name);
	}

	/**
	 * Reseache topic to do
	 */
	public void doResearch(String topic) {
		System.out.println("Doing research on " + topic );
	}
}