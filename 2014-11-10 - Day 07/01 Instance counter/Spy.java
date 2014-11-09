/** Day 7 - Exercise 1 - Instance counter **/

public class Spy {
	// This static int is common to all Spy objects
	public static int spyCount;
    private int spyId;

    public Spy(int id) {
	    this.spyId = id;
	    spyCount++;
	    System.out.println("Created spy: "+id+". There are "+spyCount+" spies so far.");
    }

    public void die() {
	    spyCount--;
	    System.out.println("Spy "+this.spyId+" has been detected and eliminated.");
	    print();
    }

    public void print() {
	    System.out.println("There are "+spyCount+" spies so far.");
    }
}