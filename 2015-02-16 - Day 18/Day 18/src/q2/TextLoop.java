package q2;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Question 1 Day 17
 * 
 * @author Vasco
 *
 */
public class TextLoop implements Runnable {
	/**
	 * Core Pool Size
	 */
	private int corePoolSize = 8;
	
	/**
	 * Max Pool Size
	 */
	private int maxPoolSize = corePoolSize;
	
	/**
	 * Keep Alive Time
	 */
	private long keepAliveTime = 5000;
	
	/**
	 * Amount of Runnables to have
	 */
 	public static final int COUNT = 1;

 	/**
 	 * 
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
			System.out.println("Loop: "+threadName+", iteration: "+i+".");
		}
	}

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] arg) {
		TextLoop tl = new TextLoop("1");
		tl.launch();
	}
	
	private void launch() {
		String[] args = {"1"};
		Executor exec = new ThreadPoolExecutor(corePoolSize, 
				maxPoolSize, keepAliveTime, TimeUnit.MILLISECONDS, 
				new LinkedBlockingDeque<Runnable>()
		);

		if(args.length < 1 || (!args[0].equals("0") && !args[0].equals("1"))) {
			System.out.println("USAGE: java TextLoop <mode>");
			System.out.println("       mode 0: without threads");
			System.out.println("       mode 1: with threads");
		}
		else if (args[0].equals("0")) {
			for ( int i = 0 ; i < 10; i++ ) {
				TextLoop tl = new TextLoop("Thread " + i );
    			exec.execute(tl);
			}
		}
		else {
			for ( int i = 0 ; i < 10; i++ ) {
				TextLoop tl = new TextLoop("Thread " + i );
				exec.execute(tl);
			}
		}
		
	}
}
