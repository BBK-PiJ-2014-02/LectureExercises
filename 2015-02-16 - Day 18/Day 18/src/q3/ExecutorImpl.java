package q3;

import java.util.concurrent.Executor;

import q2.TimedTask;

public class ExecutorImpl extends TimedTask implements Executor {
	/**
	 * Total sleeping time
	 */
	private int totalSleepingTime = 0;

	/**
	 * {@inheritDoc}
	 */
	public ExecutorImpl(int sleeping) {
		super(sleeping);
		this.totalSleepingTime += sleep;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(Runnable runnable) {
		new Thread(runnable).start();
	}
	
	/**
	 * Max Pending time
	 */
	public int getMaxPendingTime() {
		return totalSleepingTime;
	}

}
