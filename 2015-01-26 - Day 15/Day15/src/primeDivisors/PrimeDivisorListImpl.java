package primeDivisors;

import java.util.ArrayList;
import java.util.List;

/**
 * Class implementation for the PrimeDivisorList
 * 
 * @author vdiasf01
 *
 */
public class PrimeDivisorListImpl implements PrimeDivisorList {
	/**
	 * List of Integers added.
	 */
	private List<Integer> list;
	
	/**
	 * Constructor
	 */
	public PrimeDivisorListImpl() {
		this.list = new ArrayList<Integer>();
	}
	
	/**
	 * Adds only prime numbers to the list.
	 */
	public void add(Integer primeNumber) {
//		if (primeNumber == null ) {
//			throw new NullPointerException();
//		}
		if ( !isPrime(primeNumber) ) {
			throw new IllegalArgumentException();
		}
		
//		list.add(primeNumber);
	}

	/**
	 * Prints the list in a series of multiplications
	 * listing once each number to the power of times
	 * it is in the list.
	 * 
	 * Also displays the result in the following format:
	 * 
	 * [ 2 * 3^2 * 7 = 126 ]
	 */
	@Override
	public String toString() {
		String finalString = "";
        long result = 0;
        
        if ( list.size() == 0 ) {
        	return finalString;
        }
        
		for( int i = 0; i < list.size(); i++ ) {
			if ( result == 0 ) {
				result = list.get(i);

			} else {
				result *= list.get(i);
				finalString += " * ";
			}

			finalString += list.get(i);
		}

		return "[ " + finalString + " = " + result + " ]";
	}
	
	/**
	 * Checks if a given number is prime.
	 * 
	 * @param number Integer
	 * @return true if prime number
	 */
	private boolean isPrime(Integer number) {
		if ( number == 1 || number == 2 ) {
			return true;
		}
		else {
			for( int i = 2; i < number; i++ ) {
				if (number % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
