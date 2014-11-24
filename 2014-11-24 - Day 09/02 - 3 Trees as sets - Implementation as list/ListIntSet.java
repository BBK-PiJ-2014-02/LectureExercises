public class ListIntSet implements IntSet {
	/**
	 *  The int value
	 */
	private int value;

	/**
	 *  The next node
	 */
	private IntSet next;

	/**
	 *  Constructor
	 */
	public ListIntSet(int value) {
		this.value = value;
	}

	/**
	 *  Adds a new int to the set.
	 *  If it is there already, nothing happens.
	 */
	public void add(int i) {
		if ( this.value == i ) {
			return;
		}

		if ( this.next == null ) {
			this.next = new ListIntSet(i);
		}
		else {
			this.next.add(i);
		}
	}

	/**
	 *  Returns true if the number is in the set
	 *  false otherwise.
	 */
	public boolean contains(int i) {
		if ( this.value == i ) {
			return true;
		}
		else if ( this.next != null ) {
            this.next.contains(i);
		}
		return false;
	}

	/**
	 *  Returns the same values as the former method,
	 *  but for every element that is checked, prints
	 *  its value onthe screen.
	 */
	public boolean containsVerbose(int i) {
		System.out.println(this.toString());
		if ( this.value == i ) {
			return true;
		}
		else if ( this.next != null ) {
			return this.next.containsVerbose(i);
	    }
		else {
			return false;
		}
	}

	/**
	 *  Returns a string with the valuyes of the elements
	 *  in the set separated by commas.
	 */
	@Override
	public String toString() {
		return "[" + this.value + "]";
	}
}