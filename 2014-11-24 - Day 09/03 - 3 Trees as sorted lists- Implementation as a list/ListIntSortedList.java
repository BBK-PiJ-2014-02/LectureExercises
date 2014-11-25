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
		if ( this.first && this.next == null ) {
			this.next = new ListIntSortedList(i,false);
		}
		else {
    		if ( this.next == null && i >= this.value ) {
    			this.next = new ListIntSortedList(i,false);
    		}
    		else if ( this.next == null && i < this.value ) {
    			ListIntSortedList tmp = new ListIntSortedList(i,false);
    			tmp.setNext(this);
    			this.next = null;
    			System.out.println("hey");
    		}
    		else if ( this.value < i && i <= this.next.getValue() ) {
      			ListIntSortedList tmp = new ListIntSortedList(i,false);
     			tmp.setNext(this.next);
    			this.next = tmp;
    		}
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