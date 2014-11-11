/** Day 7 - Exercise 10 - A sorted list **/

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
		do {
			// Keep swapping elements until no more swap is needed
		} while(list.bubbleSort());
    }
}