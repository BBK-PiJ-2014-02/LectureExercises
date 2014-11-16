/** Day 7 - Exercise 13 - Quick sort **/

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
                pSecond.setPrev(null);
                this.first.setNext(pFirst);
                pFirst.setNext(pThird);
                pFirst.setPrev(pSecond);
            }
            // Given the first is sorted with the second, we check the third onwards
            else {
                this.first.bubbleSort();
            }
		} while(!isSorted());
    }

    // CocktailSort got through the list left to right and then right to left
    public void cocktailSort() {
        // If empty list, no swap needed
        if ( this.first == null ) {
            return;
        }

        // If no more elements, no swap needed
        if ( this.first.getNext() == null ) {
            return;
	    }

        do {
            // Left to right: If the first element is bigger than the second, swap
            if ( this.first.getValue() > this.first.getNext().getValue() ) {
                IntElement p1 = this.first;
                IntElement p2 = this.first.getNext();
                IntElement p3 = p2.getNext();

                // swap p1 with p2
                // BEFORE: p1 -> p2 -> p3 | null <- p1 <- p2 <- p3
                // AFTER:  p2 -> p1 -> p3 | null <- p2 <- p1 <- p3
                p2.setNext(p1);
                p1.setNext(p3);
                p2.setPrev(null);
                p1.setPrev(p2);
                p3.setPrev(p1);
                this.first = p2;
            }
            // Given the first is sorted with the second, we check the third onwards
            else {
                this.first.bubbleSort();
            }

            // Get last element and start from there backwards.
            IntElement last = getLastElement();

            if ( last != null && last.getPrev() != null ) {
                // Right to right: If the last element is smaller than the previous one, swap
                if ( last.getPrev().getValue() > last.getValue() ) {
                    IntElement pLast  = last.getPrev().getNext();
                    IntElement pPrev1 = last.getPrev();
                    IntElement pPrev2 = pPrev1.getPrev();

                    // swap last with previous
                    // BEFORE: pPrev2 -> pPrev1 -> pLast  | pPrev2 <- pPrev1 <- pLast
                    // AFTER:  pPrev2 -> pLast  -> pPrev1 | pPrev2 <- pLast  <- pPrev1
                    if ( pPrev2 != null ) {
						pPrev2.setNext(pLast);
					}

					pLast.setNext(pPrev1);
					pLast.setPrev(pPrev2);

                    pPrev1.setNext(null);
                    pPrev1.setPrev(pLast);
                }

                // The first element must be always returned and updated
                this.first = last.reverseBubbleSort();
			}
		} while(!isSorted());
    }

    // Need last element for reverseBubbleSort
    private IntElement getLastElement() {
		IntElement last = this.first;
		if ( this.first == null ) {
			return null;
		}

		if ( this.first.getNext() == null ) {
			return this.first;
		}

		last = this.first.getNext();

		while ( last.getNext() != null ) {
			last = last.getNext();
		}

		return last;
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

    // Method to print the full reversed list of integers in sequence
    public void printListReverse() {
		IntElement ei = getLastElement();
		System.out.print("{");
		do {
			System.out.print(ei.getValue());
			ei = ei.getPrev();
			if ( ei != null ) {
				System.out.print(", ");
			}
		} while (ei != null);
		System.out.println("}");
	}
}