package binarySearch;

import java.util.ArrayList;

public class BinarySearch {
	/**
	 * Searches for an integer in the list and returns true or false if found.
	 * 
	 * @param number to search for
	 * @return boolean true if found.
	 */
	public static boolean isIn(ArrayList<Integer> myList, Integer number) {
        // If nothing on the list, nothing to compare with, thus not in list.
		if ( myList.size() == 0 ) {
			return false;
		}
		// If the list has only one element, compare that element.
		else if ( myList.size() == 1 ) {
			if ( myList.get(0) == number ) {
				return true;
			}
			else {
				return false;
			}
		}
		// For all other cases, check from half way if we need to check 
		// the left or the right part of the list for this integer.
		else {
            return isIn(myList, number, 0, myList.size()-1);
		}
	}
	
	/**
	 * Recursive method to carry the search for a number in myList.
	 * 
	 * @param myList original ArrayList
	 * @param number Integer for the number to find in List
	 * @param index int for the current index we are searching in List
	 * @return boolean true if found.
	 */
	private static boolean isIn(ArrayList<Integer> myList, Integer number, int startIndex, int endIndex) {

		// When start and end indexes are equal, number was found
		if ( startIndex == endIndex && myList.get(startIndex) == number ) {
			return true;
		}

		// Search again.
		else {

			// Calculate the middle point between the two boundary indexes.
			int middleIndex = ( (endIndex - startIndex) / 2 ) + startIndex;

			if ( startIndex == middleIndex ) {
				if ( myList.get(startIndex) == number ) {
					return true;
				}
				
				if ( myList.get(endIndex) == number ) {
					return true;
				}
				return false;
			}
			
			// If number at middleIndex is bigger than number, need to go to the left.
			if ( myList.get(middleIndex) > number ) {
				endIndex = middleIndex;
			}

			// Number at middleIndex is smaller than number, need to go to the right.
			else if ( myList.get(middleIndex) < number ) {
                startIndex = middleIndex;
			}
			
			// Check if middleIndex is the actual place where number is found
			else if ( myList.get(middleIndex) == number ) {
				return true;
			}
			
			// If none of the above, then we won't find the number here.
			else {
				return false;
			}

			return isIn(myList, number, startIndex, endIndex);
		}
	}
}
