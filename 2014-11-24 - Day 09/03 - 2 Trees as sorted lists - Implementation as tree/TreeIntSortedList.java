public class TreeIntSortedList implements IntSortedList {
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
    public TreeIntSortedList(int i) {
		this.value = i;
	}

	/**
	 *  Adds a new int to the list so that the list remains sorted
	 *  A list can contain duplicated unlike a set.
	 */
	public void add(int i) {
		if ( i > value ) {
			if ( this.right == null ) {
				this.right = new TreeIntSortedList(i);
			}
			else {
				this.right.add(i);
			}
		}
		else {
			if ( this.left == null ) {
				this.left = new TreeIntSortedList(i);
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
		if ( left != null && right != null ) {
			return left.toString() + "," + value + "," + right.toString();
		}
		else if ( left != null && right == null ) {
			return left.toString() + "," + value;
		}
		else if ( left == null && right != null ) {
			return value + "," + right.toString();
		}
		else {
			return "" + value;
		}
	}

}