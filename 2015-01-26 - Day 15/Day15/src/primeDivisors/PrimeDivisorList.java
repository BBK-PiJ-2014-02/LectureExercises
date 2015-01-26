package primeDivisors;

public interface PrimeDivisorList {
	/**
	 * Adds only prime numbers to the list.
	 */
	void add(Integer primeNumber);
	
	/**
	 * Prints the list in a series of multiplications
	 * listing once each number to the power of times
	 * it is in the list.
	 * 
	 * Also displays the result in the following format:
	 * 
	 * [ 2 * 3^2 * 7 = 126 ]
	 */
	String toString();
	
}
