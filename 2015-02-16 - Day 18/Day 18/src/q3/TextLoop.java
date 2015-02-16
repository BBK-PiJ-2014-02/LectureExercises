package q3;

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
	 * Constructor
	 * 
	 * @param name
	 */
	public TextLoop(String name, int sleep) {
		this.exec = new ExecutorImpl(sleep);
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
	}
	
	private void launch(String[] args) {
//		Executor exec = new ExecutorImpl((int)Math.random()*1000);
		
		if ( args.length < 1 || (!args[0].equals("0") && !args[0].equals("1")) ) {
			System.out.println("USAGE: java TextLoop <mode>");
			System.out.println("       mode 0: without threads");
			System.out.println("       mode 1: with threads");
		}
		else if ( args[0].equals("0") ) {
			for ( int i = 0 ; i < 10; i++ ) {
				TextLoop tl = new TextLoop("Thread " + i, (int)Math.random()*1000 );
    			exec.execute(tl);//.execute(tl);
			}
		}
		else {
			for ( int i = 0 ; i < 10; i++ ) {
				TextLoop tl = new TextLoop("Thread " + i, (int)Math.random()*1000  );
    			exec.execute(tl);//.execute(tl);
//				exec.execute(tl);
			}
		}
		System.out.println("Total time: " + exec.getMaxPendingTime());
	}

}
