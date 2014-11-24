public class ListIntSortedList implements IntSortedList {
    /**
     *  Is first element
     */
	private boolean first = false;

    /**
     *  Private int value
     */
	private int value;

    /**
     *  Private next node
     */
    private IntSortedList next;

    /**
     *  Constructor for the first element
     */
    public ListIntSortedList(int i) {
		this.first = true;
		this.next = new ListIntSortedList(i);
	}

    /**
     *  Constructor for subsequent elements
     */
    public ListIntSortedList(int i, boolean first) {
		this.first = first;
		this.next = new ListIntSortedList(i,first);
	}

	/**
	 *  Adds a new int to the list so that the list remains sorted
	 *  A list can contain duplicated unlike a set.
	 */
	public void add(int i) {
		// First element is only a pointer to the start of the list
		if ( this.first ) {
			if ( this.next == null ) {
				this.next = new ListIntSortedList(i,false);
			}
			else if ( i > this.next.getValue() ) {
				this.next.add(i);
			}
			else {
				IntSortedList isl = new ListIntSortedList(i,false);
				isl.getNext().setNext(this.next);
				this.next = isl;
			}
		}
		else {
			if ( this.next == null ) {
				this.next = new ListIntSortedList(i,false);
			}
			else if ( i > this.next.getValue() ) {
				this.next.add(i);
			}
			else {
				IntSortedList isl = new ListIntSortedList(i,false);
				isl.getNext().setNext(this.next);
				this.next = isl;
			}
		}

 	}

    /**
     *  Sets next pointer
     */
    public void setNext(IntSortedList isl) {
		this.next = isl;
	}

    /**
     *  Retuns the value
     */
    public int getValue() {
		return this.value;
	}

	/**
	 *  Returns true if the number is in the list, false otherwise.
	 */
	public boolean contains(int i) {
		if ( i == value ) {
			return true;
		}
		else if ( next == null ) {
			return false;
		} else {
			return next.getNext().contains(i);
		}
	}

	/**
	 *  Returns a string with the values of the elements
	 *  in the list separated by commas.
	 */
	public String toString() {
		if ( next != null ) {
			return value + ", " + next.toString();
		}
		else {
			return ", " + value;
		}
	}

}