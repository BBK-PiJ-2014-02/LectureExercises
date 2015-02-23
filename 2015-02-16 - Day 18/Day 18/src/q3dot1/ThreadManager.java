package q3dot1;

import java.util.ArrayDeque;
import java.util.Queue;

public class ThreadManager implements Runnable {
	/**
	 * Amount of threads running now.	
	 */
	private int threadsRunning = 0;

	/**
	 * Maximum amount of threads to run at any time.
	 */
	private final int maxConcurrentThreads;
	
	/**
	 * Threads running.
	 */
	private Queue<Thread> running   = new ArrayDeque<Thread>();
	
	/**
	 * Thread queue to be be executed.
	 */
	private Queue<Thread> taskQueue = new ArrayDeque<Thread>();

	/**
	 * ThreadManager switch.
	 */
	boolean finished = false;
	
	/**
	 * Constructor.
	 * 
	 * @param concurrentThreads
	 */
	public ThreadManager(int concurrentThreads) {
		this.maxConcurrentThreads = concurrentThreads;
	}
	
	/**
	 * Add a new thread to the queue to run.
	 * 
	 * @param t
	 */
	public void add(Thread t) {
		taskQueue.add(t);
		threadsRunning++;
	}

	/**
	 * Pull the plug, terminate the ThreadManager
	 */
	public void endThreadManager(){
		this.finished = true;
	}
	
	/**
	 * Run forever checking the task queue and the running queue
	 * to see if we need to pull more threads to run.
	 */
	@Override
	public void run() {
		while(! (finished && running.isEmpty() && taskQueue.isEmpty()) ) {
   			for(Thread t: running) {
    			if( !t.isAlive() ) {
   					System.out.println("Task finished: "+t.toString());
    				running.remove(t);
	    			threadsRunning--;
				}
			}
				
   			if ( running.size() < maxConcurrentThreads ) {
   				if ( !taskQueue.isEmpty() ) {
   					Thread t = taskQueue.poll();
   					running.add(t);
   					threadsRunning++;
   					t.start();
   					System.out.println("Task started: " + t.toString());
   				}
			}
		}
	}
}
