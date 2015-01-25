package hailstone;

import java.util.ArrayList;

/**
 * Hailstone numbers
 * 
 * @author Vasco
 *
 */
public interface Hailstone {
    /**
     * Calculates the sequence of all Hailstone numbers 
     * from initial given number to convergent 1.
     * 
     * @param number Integer starting number
     * @return ArrayList<Integer> with all calculated number sequence
     */
	ArrayList<Integer> getHailstone(Integer number);
}
