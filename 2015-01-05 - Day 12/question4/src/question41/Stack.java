package question41;

public interface Stack {
	/**
	 * Push into the Stack given integer.
	 * 
	 * @param integer to add to stack
	 */
    void push(int integer);
    
    /**
     * Pop lastly added integer from stack.
     * 
     * @return integer
     */
    int pop();
    
    /**
     * True if stack is empty.
     * 
     * @return true if empty.
     */
    boolean empty();
}
