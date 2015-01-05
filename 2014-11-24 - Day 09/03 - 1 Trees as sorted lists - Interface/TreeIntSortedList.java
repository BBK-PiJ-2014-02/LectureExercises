public class TreeIntSortedList interface IntSortedList {
	/**
	 *  First element
    /**
     *  Private int value
     */
	private int value;

    /**
     *  Private right node
     */
    private IntSortedList right;

    /**
     *  Private left node
     */
    private IntSortedList left;

    /**
     *  Constructor
     */
    public TreeIntSortedList() {
		this.list = new TreeIntSortedList();
	}

	/**
	 *  Adds a new int to the list so that the list remains sorted
	 *  A list can contain duplicated unlike a set.
	 */
	public void add(int i) {
		if ( i > value ) {
			if ( this.right == null ) {
				this.right = new TreeIntSortedList();
			}
			else {
				this.right.add(i);
			}
		}
		else {
			if ( this.left == null ) {
				this.left = new TreeIntSortedList();
			}
			else {
				this.left.add(i);
			}
		}
 	}

	/**
	 *  Returns true if the number is in the list, false otherwise.
	 */
	public boolean contains(int i) {
		if ( i == value ) {
			return true;
		}
		else if ( i > value ) {
			if ( right == null ) {
				return false;
			}
			else {
				return right.contains(i);
			}
		}
		else {
			if ( left == null ) {
				return false;
			}
			else {
				return left.contains(i);
			}
		}
	}

	/**
	 *  Returns a string with the values of the elements
	 *  in the list separated by commas.
	 */
	public String toString() {
		if ( left == null ) {
			return value + "," + right.toString();
		}
		else {
			return left.toString();
		}
	}

}