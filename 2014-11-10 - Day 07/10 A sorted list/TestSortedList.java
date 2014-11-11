/** Day 7 - Exercise 10 - A sorted list **/

public class TestSortedList {
    public static void main( String[] args ) {
		System.out.println("==== Welcome to the sorted ListUtilities World ===");

        int[] intArray = {5,6,4,7,3,8,2,9,1,15,12,14,13,11};
        ListManager listM = ListUtilities.toList(intArray);

        listM.printList();
	}
}