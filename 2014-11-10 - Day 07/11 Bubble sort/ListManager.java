/** Day 7 - Exercise 11 - Bubble sort **/

public class ListManager {

    private IntElement first;
    private int listSize = 0;

    // Constructor
    public ListManager() {
		this.first = null;
	}

    // Insert element at the end of the list
    public void add(IntElement ie) {
		// Nothing given, return
		if ( ie == null ) {
			return;
		}

        // This is the first to add
		if ( this.first == null ) {
			this.first = ie;
			this.listSize++;
		}
		// Not the first element, find the last and set it after it
		else {
            this.first.addElement(ie);
            this.listSize++;
        }
	}

    // Insert elements sorted
    public void addSorted(IntElement ie) {
		// Nothing given, return
		if ( ie == null ) {
			return;
		}

        // This is the first to add
		if ( this.first == null ) {
			this.first = ie;
			this.listSize++;
		}
		// Not the first element, find the last and set it after it
		else {
			// Always check first with new element.
			// Trust the second to be the smallest in list
			if ( this.first.getValue() > ie.getValue() ) {
				IntElement newIe = this.first;
				ie.setNext(this.first.getNext());
				this.first = ie;
				this.first.addElementSorted(newIe);
                this.listSize++;
			}
			else {
				this.first.addElementSorted(ie);
                this.listSize++;
			}
        }
	}

    // BubbleSort once though the list and retuns true if any swap was done
    public void bubbleSort() {
        // If empty list, no swap needed
        if ( this.first == null ) {
            return;
        }

        // If no more elements, no swap needed
        if ( this.first.getNext() == null ) {
            return;
	    }

        do {
            // If the first element is bigger than the second, swap
            if ( this.first.getValue() > this.first.getNext().getValue() ) {
                IntElement pFirst  = this.first;
                IntElement pSecond = this.first.getNext();
                IntElement pThird  = pSecond.getNext();

                // swap first with second
                this.first = pSecond;
                this.first.setNext(pFirst);
                pFirst.setNext(pThird);
            }
            // Given the first is sorted with the second, we check the third onwards
            else {
                this.first.bubbleSort();
            }
		} while(!isSorted());
    }

    // Check if current list is sorted
    private boolean isSorted() {
        IntElement pointer = this.first;
        boolean sorted = true;
        do {
			if ( pointer == null ) {
				return true;
			}
			if ( pointer.getNext() == null ) {
				return true;
			}

			if ( pointer.getValue() > pointer.getNext().getValue() ) {
				return false;
			}
			pointer = pointer.getNext();
		} while ( pointer != null );
		return true;
    }

    // Return the list size
    public int getSize() {
		return this.listSize;
	}

    // Method to simulate indexes in the list like an array
    public IntElement get(int index) {
		IntElement e = this.first;
		if ( index == 0 ) {
			return e;
		}

        int i = 1;
		do {
			e = e.getNext();
			if ( i == index ) {
				break;
			}
			i++;
		} while ( e != null );

		return e;
	}

    // Method to print the full list of integers in sequence
    public void printList() {
		if ( this.first == null ) {
			System.out.println("The list is empty!");
			return;
		}

		IntElement ei = this.first;
		System.out.print("{");
		do {
			System.out.print(ei.getValue());
			ei = ei.getNext();
			if ( ei != null ) {
				System.out.print(", ");
			}
		} while (ei != null);
		System.out.println("}");
	}
}