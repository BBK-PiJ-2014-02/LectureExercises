/** Day 7 - Exercise 12 - Cocktail sort **/

public class IntElement {
    // The int value to store
    private int value;
    // Pointer to the next IntElement in list
    private IntElement next = null;
    // Pointer to the previous IntElement in list - for cocktail sorting
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
	public IntElement addElement(IntElement ie) {
        if ( ie == null ) {
			return null;
		}

		if ( this.next == null ) {
			ie.prev = this;
			return this.next = ie;
		}
		else {
			return this.next.addElement(ie);
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

            IntElement pThis0 = this.next.getPrev();
            IntElement pNext1 = this.next;
            IntElement pNext2 = this.next.getNext();
            IntElement pNext3 = this.next.getNext().getNext();

            if ( pNext1.getValue() > pNext2.getValue() ) {
                // swap pNext1 with pNext2
                pNext1.setNext(pNext3);
                pNext1.setPrev(pNext2);
                pNext2.setNext(pNext1);
                pNext2.setPrev(pThis0);
                this.next = pNext2;

                if ( pNext3 != null ) {
                    pNext3.setPrev(pNext1);
				}

                this.next.bubbleSort();
            }
            else {
                return;
            }
        }
    }

    // Start from last element going towards first when returns it
    public IntElement reverseBubbleSort() {
        // If nothing previous, no swap needed
		if ( this.prev == null ) {
			return this;
		}

        // No need to swap if prev < prev-prev value
        if ( this.prev.getPrev() != null && this.prev.getPrev().getValue() <= this.prev.getValue() ) {
            return this.prev.reverseBubbleSort();
        }

        // Swap prev-prev with prev if prev-prev is not null
        // BEFORE: pPrev3 -> pPrev2 -> pPrev1 -> pThis | pPrev3 <- pPrev2 <- pPrev1 <- pThis
        // AFTER:  pPrev3 -> pPrev1 -> pPrev2 -> pThis | pPrev3 <- pPrev1 <- pPrev2 <- pThis
        else if ( this.prev.getPrev() != null ) {

            IntElement pThis  = this.prev.getNext();
            IntElement pPrev1 = this.prev;
            IntElement pPrev2 = this.prev.getPrev();
            IntElement pPrev3 = this.prev.getPrev().getPrev();

            // ->
            if ( pPrev3 != null ) {
				pPrev3.setNext(pPrev1);
			}
			pPrev1.setNext(pPrev2);
			pPrev2.setNext(pThis);

			// <-
			pThis.setPrev(pPrev2);
			pPrev2.setPrev(pPrev1);
			pPrev1.setPrev(pPrev3);
			this.prev = pPrev2;

            return this.prev.reverseBubbleSort();

        // this.prev is the first element, let this shift be done by ListManager
        } else {
			return this.prev;
		}
	}

	public void cocktailSort() {
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

	public void print() {
		if ( this.prev != null ) {
			System.out.print(" Prev: "+this.prev.getValue());
		}
		else {
			System.out.print(" null");
		}

		System.out.print(" This: "+value);

		if ( this.next != null ) {
            System.out.print(" Next: "+this.next.getValue());
		}
		else {
			System.out.print(" null");
		}

		System.out.println("");
	}
}