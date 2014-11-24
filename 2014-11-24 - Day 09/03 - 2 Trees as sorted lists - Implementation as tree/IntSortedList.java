public interface IntSortedList {
	/**
	 *  Adds a new int to the list so that the list remains sorted
	 *  A list can contain duplicated unlike a set.
	 */
	void add(int i);

	/**
	 *  Returns true if the number is in the list, false otherwise.
	 */
	boolean contains(int i);

	/**
	 *  Returns a string with the values of the elements
	 *  in the list separated by commas.
	 */
	String toString();

}