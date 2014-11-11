/** Day 7 - Exercise 11 - Bubble sort **/

public class TestBubbleSort {
    public static void main( String[] args ) {
		System.out.println("==== Welcome to the sorted ListUtilities World ===");

        int[] intArray = {5,6,4,7,3,8,2,9,1,15,12,14,13,11};
        ListManager listM = ListUtilities.toList(intArray);
        listM.printList();

        long start = System.currentTimeMillis();
        ListUtilities.bubbleSort(listM);
        long finish = System.currentTimeMillis();
        listM.printList();

        System.out.println("It took: "+(finish-start)+"ms");

//        IntElement e = listM.get(14);
//        System.out.println("element 0 = "+e.getValue());
	}
}