package q3dot1;

import java.util.concurrent.Executor;

public class ExecutorImpl implements Executor {
	/**
	 * The thread manager which will manage how many
	 * threads should be running at the same time.
	 */
	private ThreadManager tm;
	
	/**
	 * Constructor.
	 */
	public ExecutorImpl(int concurrentThreads){
		this.tm = new ThreadManager(concurrentThreads);
		Thread t = new Thread(tm);
		t.start();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(Runnable runnable) {
		tm.add(new Thread(runnable));
	}
	
	/**
	 * End the ThreadManager.
	 */
	public void endThreadManager(){
		tm.endThreadManager();
	}
}
