package memorizedFibonacci;

public class MemFibonacciImpl implements Fibonacci {
	/**
	 * Pre-calculated values stored in memory.
	 */
	private int[] preCalculated = null;
	
	/**
	 * Returns the Fibonacci of index n.
	 * 
	 * @param n Fibonacci index
	 * @return Fibonacci value
	 */
	public int fib(int n) {
		if ( preCalculated == null ) {
			initPrecalculateArray(n);
		}
		if ( preCalculated[n-1] != -1 ) {
			return preCalculated[n-1];
		}
		else {
			int result = fib(n-1) + fib(n-2);
			preCalculated[n-1] = result;
			return result;
		}
	}
	
	private void initPrecalculateArray(int size) {
		preCalculated = new int[size];
		for ( int i = 0; i < preCalculated.length; i++ ) {
			preCalculated[i] = -1; // to indicate "not calculated yet"
		}
		preCalculated[0] = 1; // F(1)
		preCalculated[1] = 1; // F(2)
	}

}
