/** Day 7 - Exercise 9 - From array to list **/

public class TestArrayToList {
    public static void main( String[] args ) {
		System.out.println("==== Welcome to the ListUtilities World ===");

        int[] intArray = {1,2,3,4,5,6,7,8,9};
        ListManager listM = ListUtilities.toList(intArray);

        listM.printList();
	}
}