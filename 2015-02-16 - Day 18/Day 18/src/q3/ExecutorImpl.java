package q3;

import java.util.concurrent.Executor;

public class ExecutorImpl implements Executor {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void execute(Runnable runnable) {
		new Thread(runnable).start();
	}

}
