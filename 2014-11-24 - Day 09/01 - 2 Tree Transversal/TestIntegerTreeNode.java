/** Day 9 - Exercise 1.2 - Tree transversal **/

public class TestIntegerTreeNode {

    public static void main( String[] args ) {
		IntegerTreeNode itn = new IntegerTreeNodeImpl(6);
		itn.add(9);
		itn.add(5);
		itn.add(3);
		itn.add(8);
		itn.add(11);
		itn.add(12);

        System.out.println("contains: "+itn.contains(145));
        System.out.println("max: "+itn.getMax());
        System.out.println("min: "+itn.getMin());
        System.out.println(itn.toString());
	}
}
