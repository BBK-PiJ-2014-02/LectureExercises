package q3dot1;

import java.util.concurrent.Executor;

/**
 * Question 3.1 Day 18.
 * 
 * Running one Runnable at a time using Executor.
 * 
 * @author Vasco
 *
 */
public class TextLoop implements Runnable {
	/**
	 * Amount of Runnable to have simultaneously.
	 */
 	public static final int COUNT = 10;

 	/**
 	 * The thread name 
 	 */
	private final String threadName;
	
	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public TextLoop(String name) {
		this.threadName = name;
	}

	/**
	 * Runnable
	 */
	@Override
	public void run() {
		for( int i = 0; i < COUNT; i++ ) {
			long millis = 100;
			try {
				Thread.sleep(millis);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Loop: " + threadName + ", iteration: " + i + ".");
		}
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] arg) {
		TextLoop t1 = new TextLoop("1");
		t1.launch();
	}
	
	/**
	 * Launching the application.
	 */
	private void launch() {
		String[] args = {"1"};
		Executor exec = new ExecutorImpl(2);
		
		if ( args.length < 1 || (!args[0].equals("0") && !args[0].equals("1")) ) {
			System.out.println("USAGE: java TextLoop <mode>");
			System.out.println("       mode 0: without threads");
			System.out.println("       mode 1: with threads");
		}
		else if ( args[0].equals("0") ) {
			for ( int i = 0 ; i < 10; i++ ) {
				TextLoop t1 = new TextLoop("Thread " + i);
	    		t1.run();
			}
		}
		else {
			for ( int i = 0 ; i < 10; i++ ) {
				TextLoop tl = new TextLoop("Thread " + i);
    			exec.execute(tl);
			}
		}
	}
}
