public class TestListIntSet {
    public static void main( String[] args ) {
		IntSet is = new ListIntSet(0);
		is.add(1);
		is.add(20);
		is.add(20);
		is.add(3);
		is.add(4);
		is.add(5);
		is.add(6);
		System.out.println("contains 1: "+is.containsVerbose(3));
    }
}

