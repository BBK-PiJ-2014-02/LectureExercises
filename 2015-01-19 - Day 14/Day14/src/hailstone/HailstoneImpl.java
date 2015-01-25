package hailstone;

import java.util.ArrayList;

/**
 * Hailstone numbers
 * 
 * @author Vasco
 *
 */
public class HailstoneImpl implements Hailstone {
    /**
     * Calculates the sequence of all Hailstone numbers 
     * from initial given number to convergent 1.
     * 
     * @param number Integer starting number
     * @return ArrayList<Integer> with all calculated number sequence
     */
	public ArrayList<Integer> getHailstone(Integer number) {
		if ( number == 1 ) {
			ArrayList<Integer> results = new ArrayList<Integer>();
			results.add(number);
			return results;
		}
		else {
			ArrayList<Integer> results = new ArrayList<Integer>();
			// If number is odd, n = 3n+1, if even, n = n/2
			results.add(number);
			if ( number % 2 == 0 ) {
				number = number / 2;
			}
			else {
				number = ( 3 * number ) + 1;
			}
			
			ArrayList<Integer> tmpArrayList = new ArrayList<Integer>();
			tmpArrayList = getHailstone(number);
			for( int i = 0; i < tmpArrayList.size(); i++ ) {
				results.add(tmpArrayList.get(i));
			}
			
			return results;
		}
	}
}
