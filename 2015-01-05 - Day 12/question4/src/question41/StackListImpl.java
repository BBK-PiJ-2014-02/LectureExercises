package question41;

public class StackListImpl implements Stack {
	/**
	 * This previous Stack element
	 */
	private Stack prev;
	
	/**
	 * This next Stack element
	 */
	private Stack next;
	
	/**
	 * The stack size.
	 */
	private int size;

	/**
	 * The integer value.
	 */
	private int value;
	
	/**
	 * Is first element
	 */
	private final boolean first;
	
	/**
	 * Constructor.
	 */
	public StackListImpl() {
		this.size  = 0;
		this.next  = null;
		this.prev  = null;
		this.value = 0;
		this.first = true;
	}
	
	/**
	 * Constructor with given integer and previous to be set.
	 */
	public StackListImpl(int integer, Stack prev) {
		this.size  = 0;
		this.next  = null;
		this.prev  = prev;
		this.value = integer;
		this.first = false;
	}
	
	/**
	 * Push into the Stack given integer.
	 * 
	 * Add new elements to the end of the list.
	 * 
	 * @param integer to add to stack
	 */
    public void push(int integer) {
    	// Add the first element.
    	if ( this.first && this.next == null ) {
    		if ( this.size == 0 ) {
    			this.value = integer;
    			this.size++;
    		}
    	}
    	
    	// Add subsequent elements to the stack
    	else {
    		// next is null, this is where we add new element.
    		if ( this.next == null ) {
    			this.next = new StackListImpl(integer, this);
    		}
    		else {
    			this.next.push(integer);
    		}
    		
    		if ( this.first ) {
    			this.size++;
    		}
    	}

    }
    
    /**
     * Pop lastly added integer from stack.
     * 
     * Pop the last element of the list.
     * 
     * @return integer
     */
    public int pop() {

    	// Decrease list size only for the first element.
    	if ( this.first ) {
    		this.size--;
    	}

    	// If first and next is null, return this value
    	if ( this.first && this.next == null ) {
    		return this.value;
    	}
    	
    	// If next is null, return this value
    	else if ( this.next == null ) {
    		return this.value;
    	}

    	// Check for the last element.
    	else {
   	    	return this.next.pop();
    	}
    }

    /**
     * True if stack is empty.
     * 
     * @return true if empty.
     */
    public boolean empty() {
    	if ( this.size == 0 ) {
    		return true;	
    	}
    	return false;
    }
}