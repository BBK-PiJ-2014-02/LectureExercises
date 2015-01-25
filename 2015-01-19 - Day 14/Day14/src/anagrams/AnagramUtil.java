package anagrams;

import java.util.ArrayList;
import java.util.List;

public class AnagramUtil {
	/**
	 * ListArray with all final found words.
	 */
	private static List<String> list = new ArrayList<String>();
	
	/**
	 * Calculate all possible words that can be made with given work.
	 * A list is returned with all results found.
	 * 
	 * @param word a String
	 * @return List with all words generated
	 */
	public static ArrayList<String> getAnagram(String word) {
		return calculateAnagram(word, word);
	}

	/**
	 * Recursive method to calculate all word combination.
	 * 
	 * @param originalWord String given
	 * @param subWord String to be calculated
	 * @return String
	 */
	private static ArrayList<String> calculateAnagram(String originalWord, String subWord) {
		// If the word has only one letter, no more calculations needed.
		if ( subWord.length() == 1 ) {
			ArrayList<String> arrayList = new ArrayList<String>();
			arrayList.add(subWord);
			return arrayList;
		}
		
		// If word has more than one letter, find all possible anagrams.
		else {
			ArrayList<String> arrayList = new ArrayList<String>();
			// Go over each letter of the word, concatenate all the other letters
			// and recalculate the anagram for those, to be returned in an arrayList
			// to which we then concatenate the current letter at the start of each list element.
			// This list is then returned.
			for( int i = 0; i < subWord.length(); i++ ) {
				String newSubWord = removeChar(subWord, i);
				ArrayList<String> tmpArrayList = calculateAnagram(originalWord, newSubWord);
				for(int j = 0; j < tmpArrayList.size(); j++) {
					arrayList.add(subWord.charAt(i)+tmpArrayList.get(j));
				}
			}
    		return arrayList;
		}
	}
	
	/**
	 * Return the String without the character at the given index
	 * 
	 * @param word String
	 * @param index of the char at word
	 * @return String word without chat at index
	 */
	private static String removeChar(String word, int index) {
		String finalWord = "";
		for( int i = 0; i < word.length(); i++ ) {
			if ( i == index ) { 
				continue;
			}
			else {
				finalWord += word.charAt(i);
			}
		}
		return finalWord;
	}
	
	private static void print(ArrayList<String> astr) {
		for(int i = 0; i < astr.size(); i++ ) {
			System.out.println("\tArrayList.get("+i+") = "+astr.get(i));
		}
	}
}
