public class ListIntSortedList implements IntSortedList {
    /**
     *  Private int value
     */
	private int value;

    /**
     *  Private first element flag
     */
	private boolean first = false;

    /**
     *  Private next node
     */
    private ListIntSortedList next;

    /**
     *  Constructor
     */
    public ListIntSortedList(int i) {
		this.first = true;
		this.next  = new ListIntSortedList(i,false);
	}

    /**
     *  Constructor
     */
    public ListIntSortedList(int i, boolean first) {
		this.value = i;
		this.first = first;
	}

	/**
	 *  Adds a new int to the list so that the list remains sorted
	 *  A list can contain duplicated unlike a set.
	 */
	public void add(int i) {
		// First element of the list start on the next of first elemt
		// This is to allow the swap of the first with a smaller value
		// without losing the reference of the first element.
		if ( this.first && this.next == null ) {
			this.next = new ListIntSortedList(i,false);
		}
		// We have a next element.
		else {
			// If we do not have a next element and this value is smaller,
			// next will be a new element with this i value
    		if ( this.next == null && i >= this.value ) {
    			this.next = new ListIntSortedList(i,false);
    		}
    		// If next is null and i is smaller than this value,
    		// add a new element here and assign this element to the next
    		// of the newly created element.
    		else if ( this.next == null && i < this.value ) {
    			ListIntSortedList tmp = new ListIntSortedList(i,false);
    			tmp.setNext(this);
    			this.next = null;
    			System.out.println("hey");
    		}
    		// If this value is smaller than given i and i is also smaller than
    		// the next element's value, a new element should be added between this
    		// element and the next with the i value
    		else if ( this.value < i && i <= this.next.getValue() ) {
      			ListIntSortedList tmp = new ListIntSortedList(i,false);
     			tmp.setNext(this.next);
    			this.next = tmp;
    		}
    		// For all other cases, recall add from the next element.
    		else {
    			this.next.add(i);
    		}
		}
 	}

    /**
     *  Sets next pointer
     */
    public void setNext(ListIntSortedList isl) {
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
		}
		else {
			return next.contains(i);
		}
	}

	/**
	 *  Returns a string with the values of the elements
	 *  in the list separated by commas.
	 */
	public String toString() {
		if ( this.next == null ) {
			if ( this.first ) {
				return "";
			}
			else {
				return "" + value;
			}
		}
		else {
			if ( this.first ) {
				return this.next.toString();
			}
			else {
				return value + ", " + this.next.toString();
			}
		}
	}
}