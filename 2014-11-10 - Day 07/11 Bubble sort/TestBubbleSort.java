/** Day 7 - Exercise 11 - Bubble sort **/

public class TestBubbleSort {
    public static void main( String[] args ) {
		System.out.println("==== Welcome to the sorted ListUtilities World ===");

        int[] intArray = {
			6,2,12,33,5,56,67,45,45,6,546,45,657,567,54,43,5,46,76,567,56,756,
			75,67,567,5,4,7,3,8,2,9,1,15,12,14,13,11,45,23,35,345,56,476,5,457,
			56,54,645,76,456,456,456,45,645,34
		};

        ListManager listM = ListUtilities.toList(intArray);
        listM.printList();

        long start = System.currentTimeMillis();
        ListUtilities.bubbleSort(listM);
        long finish = System.currentTimeMillis();

        System.out.println("It took: "+(finish-start)+"ms");
        listM.printList();

	}
}