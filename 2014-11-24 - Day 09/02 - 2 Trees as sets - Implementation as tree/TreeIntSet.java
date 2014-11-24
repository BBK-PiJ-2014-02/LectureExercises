public class TreeIntSet implements IntSet {
	/**
	 *  The int value
	 */
	private int value;

	/**
	 *  The right node
	 */
	private IntSet right;

	/**
	 *  The left node
	 */
	private IntSet left;

	/**
	 *  Constructor
	 */
	public TreeIntSet(int value) {
		this.value = value;
	}

	/**
	 *  Adds a new int to the set.
	 *  If it is there already, nothing happens.
	 */
	public void add(int i) {
		if ( i > this.value ) {
			if ( this.right == null ) {
				this.right = new TreeIntSet(i);
			}
			else {
				this.right.add(i);
			}
		}
		else {
			if ( this.left == null ) {
				this.left = new TreeIntSet(i);
			}
			else {
				this.left.add(i);
			}
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
		else if ( i > value ) {
			if ( this.right == null ) {
				return false;
			}
			else {
				this.right.contains(i);
			}
		}
		else {
			if ( this.left == null ) {
				return false;
			}
			else {
				this.left.contains(i);
			}
		}

		return true;
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
		else if ( i > value ) {
			if ( this.right == null ) {
				return false;
			}
			else {
				return this.right.containsVerbose(i);
			}
		}
		else {
			if ( this.left == null ) {
				return false;
			}
			else {
  				return this.left.containsVerbose(i);
			}
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