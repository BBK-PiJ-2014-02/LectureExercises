/** Day 7 - Exercise 1 - Instance Counter **/

public class TestCounter {
    public static void main( String[] args ) {
		Spy s1 = new Spy(1);
		Spy s2 = new Spy(2);
		Spy s3 = new Spy(3);
		Spy s4 = new Spy(4);
		Spy s5 = new Spy(5);
		Spy s6 = new Spy(6);

        s1.die();
        s3.die();
        s2.die();
        s5.die();
        s4.die();
        s6.die();
    }
}