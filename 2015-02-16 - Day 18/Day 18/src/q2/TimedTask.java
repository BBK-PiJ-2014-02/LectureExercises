package q2;

public class TimedTask implements Runnable {
	/**
	 * Sleeping time at creation.
	 */
	protected int sleep;
	
	/**
	 * Constructor.
	 * 
	 * @param sleep
	 */
	public TimedTask(int sleep) {
		if ( sleep <= 1000 ) {
		    this.sleep = sleep;
		}
		else {
			this.sleep = 1000;
		}
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void run() {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
