/** Day 9 - Exercise 1.1 - Integer Binary Tree **/


public class TestIntegerTreeNode {

    public static void main( String[] args ) {
		IntegerTreeNode itn = new IntegerTreeNodeImpl(10);

		for(int i = 0; i < 10000; i++ ) {
			itn.add(i);
		}

		for(int i = 10000; i < 0; i-- ) {
			itn.add(i);
		}

        System.out.println("contains: "+itn.contains(145));
        System.out.println("max: "+itn.getMax());
        System.out.println("min: "+itn.getMin());
	}
}
