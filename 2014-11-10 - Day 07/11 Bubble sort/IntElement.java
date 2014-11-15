/** Day 7 - Exercise 11 - Bubble sort **/

public class IntElement {
    // The int value to store
    private int value;
    // Pointer to the next IntElement in list
    private IntElement next = null;

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
		}
		else {
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
		}
		else {
			if ( this.next.getValue() < ie.getValue() ) {
                this.next.addElementSorted(ie);
			}
			else {
				ie.next = this.next;
				this.next = ie;
			}
		}
	}

    // Check if need to swap or check next until null
    public void bubbleSort() {
        // If nothing next, no swap needed
		if ( this.next == null ) {
			return;
		}

        // No need to swap if next < next-next value
        if ( this.next.getNext() != null && this.next.getValue() <= this.next.getNext().getValue() ) {
		    this.next.bubbleSort();
		}

		// Swap this one if next is not null
		else if ( this.next.getNext() != null ) {
			IntElement pNext1 = this.next;
			IntElement pNext2 = this.next.getNext();
			IntElement pNext3 = this.next.getNext().getNext();

            if ( pNext1.getValue() > pNext2.getValue() ) {
                // swap pMext with pNext2
                pNext1.setNext(pNext3);
                pNext2.setNext(pNext1);
                this.next = pNext2;
                this.next.bubbleSort();
			}
			else {
				return;
			}
		}
	}

	public IntElement getNext() {
		return this.next;
	}

	public void setNext(IntElement ie) {
		this.next = ie;
	}

	public void print() {
		if ( this.next != null ) {
            System.out.print(" Next: "+this.next.getValue());
		}
		else {
			System.out.print(" null");
		}
	}
}