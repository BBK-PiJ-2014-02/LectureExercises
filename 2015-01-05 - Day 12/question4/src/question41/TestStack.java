package question41;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Testing the Stack interface.
 * 
 * @author Vasco
 *
 */
public class TestStack {
	/**
	 * Integer test sequence.
	 */
	private int[] integerSequence = { 1,2,3,4,5,6,7,8,9,10 };

	/**
	 * Default integer value to be tested with.
	 */
	private int INTEGER = 2;
	
	/**
	 * The Stack
	 */
	private Stack stack;
	
	/**
	 * Initialise Stack.
	 */
	@Before
	public void inialiseStack() {
		this.stack = new StackListImpl();
	}

	/**
	 * Test Stack is empty at the end of all tests.
	 */
	@After
	public void testEmptyAtTheEnd() {
		boolean expected = true;
		boolean result   = stack.empty();
		
		assertEquals(expected, result);
	}
	
	/**
	 * Test Stack is empty initially.
	 */
	@Test
	public void testEmpty() {
		boolean expected = true;
		boolean result   = stack.empty();

		assertEquals(expected, result);
	}
	
    /**
     * Test Stack for all end-points with one element. 
     */
	@Test
	public void testEmptyPushEmptyPopEmpty() {
		stack.push(INTEGER);

		int result = stack.pop();
		int expected = INTEGER;
		
		assertEquals(expected, result);
	}

    /**
     * Test Stack for all end-points with random N-elements. 
     */
	@Test
	public void testStackAdd1000AndPop1000Elements() {
		// push 1000 integers into stack
		for (int i = 0; i < 1000; i++) {
		    stack.push(INTEGER);
		}

		// Check that 1000 integers are popped
		for (int i = 0; i < 1000; i++) {
		    int result = stack.pop();
		    assertEquals(INTEGER, result);
		}
	}
	
	/**
	 * Test if pushed elements are popped in sequence.
	 */
	@Test
	public void testPushPopSequence() {
		// push all integers in the integerSequence
		for (int i = 0; i < this.integerSequence.length; i++) {
			stack.push(this.integerSequence[i]);
		}
		
		// Check that the integerSequence are popped out in reverse sequence
		for( int i = this.integerSequence.length -1; i >= 0; i--) {
			int result = stack.pop();
			assertEquals(this.integerSequence[i], result);
		}
		
	}
}
