package question41;

public class StackArrayImpl implements Stack {
	
	/**
	 * The Array Stack.
	 */
	private int stack[];
	
	/**
	 * Size of stack.
	 */
	private int size;
	
	/**
	 * Constructor.
	 */
	public StackArrayImpl() {
		this.stack = new int[1];
		this.size = 0;
	}
	
	/**
	 * Push into the Stack given integer.
	 * 
	 * @param integer to add to stack
	 */
    public void push(int integer) {
    	if ( this.size == this.stack.length - 1 ) extendStack();
    	this.size++;
    	this.stack[this.size] = integer;
    }
    
    /**
     * Pop lastly added integer from stack.
     * 
     * @return integer
     */
    public int pop() {
    	int popped = this.stack[this.size];
    	this.stack[this.size] = 0;
    	this.size--;
    	return popped;
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
    	else {
    		return false;
    	}
    }
    
    /**
     * Extend Stack by 10.
     */
    private void extendStack() {
    	int currentLength = this.stack.length;
    	int newLength     = currentLength + 10;
    	int newStack[]    = new int[newLength];
    	
    	// Copy stack over
    	for (int i = 0; i < this.stack.length; i++) {
    		newStack[i] = this.stack[i];
    	}
    	
    	this.stack = newStack;
    }
}
