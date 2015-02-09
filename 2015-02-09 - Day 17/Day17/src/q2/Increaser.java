package q2;
/**
 * Question 2 - Increaser
 * 
 * @author vdiasf01
 *
 */
public class Increaser implements Runnable {
    private Counter c;
    
    public Increaser(Counter counter) {
    	this.c = counter;
    }
    
    public static void main(String args[]) {
    	// Initiating the counter outside the for loop
    	// Will pass the same Counter reference to the Increaser.
    	// Threads will then share the same counter 
//    	Counter counter = new Counter();
    	for( int i = 0; i < 1000; i++ ) {
    		Increaser increaserTask = new Increaser(new Counter());
        	Thread    t             = new Thread(increaserTask);
            t.start();
    	}
    }
    
    public void run() {
    	System.out.println("Starting at " + c.getCount());
    	for( int i = 0; i < 1000; i++ ){
    		c.increase();
    	}
    	System.out.println("Stopping at " + c.getCount());
    }
}
