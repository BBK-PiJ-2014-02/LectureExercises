/** Day 7 - Exercise 10 - A sorted list **/

public class ListUtilities {

    // Static public method to convert int arrays into
    // a list of type ListManager
    public static ListManager toList(int[] intArray) {
		ListManager lm = new ListManager();
		IntElement ie;

		for( int i = 0; i < intArray.length; i++ ) {
			ie = new IntElement(intArray[i]);
			lm.addSorted(ie);
		}
		return lm;
	}

}