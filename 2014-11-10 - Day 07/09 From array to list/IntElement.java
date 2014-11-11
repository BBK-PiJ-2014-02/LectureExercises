/** Day 7 - Exercise 9 - From array to list **/

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

	public IntElement getNext() {
		return this.next;
	}
}