
public interface IntSet {
	/**
	 *  Adds a new int to the set.
	 *  If it is there already, nothing happens.
	 */
	void add(int i);

	/**
	 *  Returns true if the number is in the set
	 *  false otherwise.
	 */
	boolean contains(int i);

	/**
	 *  Returns the same values as the former method,
	 *  but for every element that is checked, prints
	 *  its value onthe screen.
	 */
	boolean containsVerbose(int i);

	/**
	 *  Returns a string with the valuyes of the elements
	 *  in the set separated by commas.
	 */
	String toString();
}
