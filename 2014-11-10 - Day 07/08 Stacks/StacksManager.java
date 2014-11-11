/** Day 7 - Exercise 8 - Stacks **/

public class StacksManager {

    private StackElement first;
    private boolean empty = true;

    // Constructor
    public StacksManager() {
		this.first = null;
	}

    // insert element at the start of the stack
    public void push(StackElement se) {
		// Nothing given, return
		if ( se == null ) {
			return;
		}

        // This is the first insert
		if ( this.first == null ) {
			this.first = se;
			this.empty = false;
		}
		// Set se to be first element before the currently set as first
		else {
			se.setNext(this.first);
			this.first = se;
	    }
	}

    // retrieve the first element of the stack
	public StackElement pop() {
		if ( this.first == null || this.empty ) {
			return null;
		}

        StackElement se = this.first;
        this.first = this.first.getNext();
        if ( this.first == null ) {
			this.empty = true;
		}
        return se;
	}

	public boolean empty() {
		return this.empty;
	}
}