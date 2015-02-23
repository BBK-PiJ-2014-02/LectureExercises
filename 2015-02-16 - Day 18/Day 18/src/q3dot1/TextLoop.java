package q3dot1;

import java.util.concurrent.Executor;

/**
 * Question 1 Day 17
 * 
 * @author Vasco
 *
 */
public class TextLoop implements Runnable {
	/**
	 * Amount of Runnables to have
	 */
 	public static final int COUNT = 2;

 	/**
 	 * The thread name 
 	 */
	private final String threadName;
	
	/**
	 * The Executor
	 */
	private final Executor exec;
	
	/**
	 * Total sleeping time
	 */
	private int totalSleepingTime = 0;
	
	/**
	 * Constructor
	 * 
	 * @param name
	 */
	public TextLoop(String name, int sleep) {
		this.exec = new ExecutorImpl(sleep);
		this.totalSleepingTime += sleep;
		this.threadName = name;
	}

	/**
	 * Runnable
	 */
	@Override
	public void run() {
		for( int i = 0; i < COUNT; i++ ) {
			System.out.println("Loop: "+threadName+", iteration: "+i+".");
		}
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] arg) {
		String[] args = {"1"};
		TextLoop tl = new TextLoop("Main",1);
		tl.launch(args);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Total time: " + tl.totalSleepingTime);
		
	}
	
	/**
	 * Launching the application.
	 * 
	 * @param args
	 */
	private void launch(String[] args) {
		
		if ( args.length < 1 || (!args[0].equals("0") && !args[0].equals("1")) ) {
			System.out.println("USAGE: java TextLoop <mode>");
			System.out.println("       mode 0: without threads");
			System.out.println("       mode 1: with threads");
		}
		else if ( args[0].equals("0") ) {
			for ( int i = 0 ; i < 10; i++ ) {
				Runnable r = new TextLoop("Thread " + i, getRandom() ) ;
	    		r.run();
			}
		}
		else {
			for ( int i = 0 ; i < 10; i++ ) {
				TextLoop tl = new TextLoop("Thread " + i, getRandom() );
    			exec.execute(tl);
			}
		}
	}

	private int getRandom() {
		return (int)(Math.random()*2000);
	}

}
