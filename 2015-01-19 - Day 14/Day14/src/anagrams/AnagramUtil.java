package anagrams;

import java.util.ArrayList;
import java.util.List;

public class AnagramUtil {
	/**
	 * Internal ListArray for all found examples.
	 */
	private static List<String> list = new ArrayList<String>();
	
	/**
	 * Building word
	 */
	private static String buildingWord;
	
	/**
	 * Given word.
	 */
	private static String givenWord;
	
	/**
	 * Calculate all possible words that can be made with given work.
	 * A list is returned with all results found.
	 * 
	 * @param word a String
	 * @return List with all words generated
	 */
	public static List<String> getAnagram(String word) {
		givenWord = word;
//		words = new String[calculateSizeNeeded(word)];
		anagramWord(word);
		return list;
	}

	/**
	 * Return the size of the array needed 
	 * for all maximum possible word combination for a given word.
	 * 
	 * @param word
	 */
	private static int calculateSizeNeeded(String word) {
		// Size = previous word length * previous calculation
		if ( word.length() <= 1 ) {
			return 1;
		}
		else { 
			return word.length() * calculateSizeNeeded(word.substring(1));
		}
	}

	/**
	 * Recursive method to calculate all word combination.
	 * 
	 * @param word String given
	 * @return String
	 */
	private static String anagramWord(String word) {
		if ( word.length() == 1 ) {
			list.add(word);
		}
		
        if ( word.length() == 2 ) {
        	// Add word found
		    list.add(word);
		    // Shift left and add second one
		    list.add(shiftLeft(word));
		}
        
		return word;
        
	}
	
	/**
	 * Simple String shift left
	 * 
	 * @param word String
	 * @return String word shifted
	 */
	private static String shiftLeft(String word) {
		return word.substring(1) + word.substring(0,1); 
	}
}
