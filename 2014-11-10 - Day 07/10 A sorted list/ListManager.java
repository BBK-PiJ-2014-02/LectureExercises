/** Day 7 - Exercise 10 - A sorted list **/

public class ListManager {

    private IntElement first;

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
		}
		// Not the first element, find the last and set it after it
		else {
            this.first.addElement(ie);
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
			}
			else {
				this.first.addElementSorted(ie);
			}
        }
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
		System.out.print("}");
	}
}