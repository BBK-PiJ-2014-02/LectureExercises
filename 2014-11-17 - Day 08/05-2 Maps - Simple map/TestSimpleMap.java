/** Day 8 - Exercise 5.1 - Hash function **/

public class TestSimpleMap {
    static public void main( String[] args ) {
		SimpleMap sp = new SimpleMapImpl();
		sp.put(5,"This is a test");
		System.out.println("get: "+sp.get(5));
		System.out.println("isEmpty: "+sp.isEmpty());
//		System.out.println("get: "+sp.get(0));
//		System.out.println("get: "+sp.get(0));

	}
}