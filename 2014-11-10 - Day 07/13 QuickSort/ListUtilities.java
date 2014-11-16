/** Day 7 - Exercise 13 - Quick sort **/

public class ListUtilities {

    // Static public method to convert int arrays into
    // a list of type ListManager
    public static ListManager toList(int[] intArray) {
		ListManager lm = new ListManager();
		IntElement ie;

		for( int i = 0; i < intArray.length; i++ ) {
			ie = new IntElement(intArray[i]);
			lm.add(ie);
		}
		return lm;
	}

    // Static public method to bubble sort a ListManager list
    // into a sorted list of type ListManager
    public static void bubbleSort(ListManager list) {
        list.bubbleSort();
    }

    // Static public method to cocktail sort a ListManager list
    // into a sorted list of type ListManager
    public static void cocktailSort(ListManager list) {
        list.cocktailSort();
    }

    // Static public method to quickSort a ListManager list
    public static void quickSort(ListManager list) {
	}
}