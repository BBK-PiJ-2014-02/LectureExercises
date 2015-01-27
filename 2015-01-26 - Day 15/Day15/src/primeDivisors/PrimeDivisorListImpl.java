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
		this.list    = new ArrayList<Integer>();
	}
	
	/**
	 * Adds only prime numbers to the list.
	 */
	public void add(Integer primeNumber) {
		if ( !isPrime(primeNumber) ) {
			throw new IllegalArgumentException();
		}
		
		list.add(primeNumber);
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
        if ( list.size() == 0 ) {
        	return "[]";
        }

        int times[] = calculateDups();
		String finalString = "";

		long result = 0;
		for( int i = 0; i < list.size(); i++ ) {
			if ( result == 0 ) {
				result = list.get(i);

			} else {
				result *= list.get(i);
			}
		}

		for( int i = 0; i < times.length; i++ ) {

			if ( times[i] == 1 ) {
				finalString += list.get(i);
			}

			else if ( times[i] > 1 ){
				boolean multiple = false;
				for( int j = 0; j < i; j++ ) {
					if ( list.get(j).equals(list.get(i))) {
						multiple = true;
					}
				}
				
				if ( !multiple ) {
					finalString += list.get(i)+"^"+times[i];
				}
				else {
					continue;
				}
			}
			else {
				finalString += list.get(i);
			}

			if ( i < times.length - 1) {
				finalString += " * ";
			}
		}
		return "[ " + finalString + " = " + result + " ]";
	}
	
	/**
	 * Calculate amount of same numbers.
	 */
	private int[] calculateDups() {
		int times[] = new int[list.size()];
		
		for( int i = 0; i < list.size(); i++ ) {
			Integer integer = list.get(i);
			times[i] = 0;
			for( int j = 0; j < list.size(); j++ ) {
				if ( list.get(j).equals(integer)) {
					times[i]++;
				}
			}
		}
		return times;
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
