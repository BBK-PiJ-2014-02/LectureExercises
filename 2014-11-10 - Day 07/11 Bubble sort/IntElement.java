/** Day 7 - Exercise 10 - A soerted list **/

public class IntElement {
    // The int value to store
    private int value;
    // Pointer to the next IntElement in list
    private IntElement next = null;
    // Pointer to previous IntElement in list
    // Simplifying bubble sort on swaping two elements
    private IntElement prev = null;

    // Constructor
    public IntElement(int v) {
		this.value = v;
	}

    // Set int value accessor
	public void setValue(int v) {
		this.value = v;
	}

    // Get int value accessor
	public int getValue() {
		return this.value;
	}

    // Add the next IntElement at the end of the list
	public void addElement(IntElement ie) {
        if ( ie == null ) {
			return;
		}

		if ( this.next == null ) {
			this.next = ie;
			ie.setPrev(this);
		}
		else {
			ie.setPrev(this);
			this.next.addElement(ie);
		}
	}

    // Add elements sorted in list
	public void addElementSorted(IntElement ie) {
        if ( ie == null ) {
			return;
		}

		if ( this.next == null ) {
			this.next = ie;
			ie.setPrev(this);
		}
		else {
			if ( this.next.getValue() < ie.getValue() ) {
				ie.setPrev(this);
                this.next.addElementSorted(ie);
			}
			else {
				this.next.setPrev(ie);
				ie.next = this.next;
				this.next = ie;
				ie.setPrev(this);
			}
		}
	}

    public boolean bubbleSort() {
        // If nothing next, no swap needed
		if ( this.next == null ) {
			return false;
		}

        if ( this.getValue() > this.next.getValue() ) {
			return this.swap();
		}
		else {
			return this.next.bubbleSort();
		}
	}

	// swaps current with the next, taking also prev pointer
	public boolean swap() {
        IntElement p = null;
        IntElement n = null;
        IntElement nn = null;

        // P -> this -> N -> NN swap to: P -> N -> this -> NN
        // P <- this <- N -> NN swap to: P <- N <- this <- NN
        if ( this.prev != null && this.next != null && this.next.getNext() != null ) {
			p  = this.prev;
			n  = this.next;
			nn = this.next.getNext();

            // Set P -> N
            p.setNext(n);
            // Set N -> this
            n.setNext(this);
            // Set this -> NN
            this.next = nn;

            // Set P <- N
            n.setPrev(p);
            // Set N <- this
            this.prev = n;
            // Set this <- NN
            nn.setPrev(this);

	    }
	    else if ( this.prev != null && this.next != null && this.next.getNext() == null ) {
			return false;
		}
		else if ( this.prev == null && this.next != null && this.next.getNext() != null ) {
			return false;
		}
		else if ( this.prev == null && this.next != null && this.next.getNext() == null ) {
			return false;
		}
		else {
			return false;
		}

        return true;
	}

	public IntElement getNext() {
		return this.next;
	}

	public void setNext(IntElement ie) {
		this.next = ie;
	}

	public IntElement getPrev() {
		return this.prev;
	}

	public void setPrev(IntElement ie) {
		this.prev = ie;
	}
}