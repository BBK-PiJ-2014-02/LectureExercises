package q4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Day 17 - Responsive UI
 * 
 * Asks the user the length in milliseconds of ten tasks.
 * Tasks start running in the background as user enters the length.
 * 
 * @author vdiasf01
 *
 */
public class ResponsiveUI implements Runnable {
	/**
	 * Store queued tasks to be processed.
	 */
	private List<Task> taskQueue;
	
	/**
	 * Store queued tasks in progress.
	 */
	private List<Task> taskQueueInProgress;
	
	/**
	 * Store finished tasks to be reported after user enters a value.
	 */
	private List<Task> tasksFinished = null;
	
	/**
	 * Constructor.
	 */
    public ResponsiveUI() {
		if ( this.tasksFinished == null ) {
			this.tasksFinished = new ArrayList<Task>();
		}
		if ( this.taskQueue == null ) {
			this.taskQueue = new ArrayList<Task>();
		}
		if ( this.taskQueueInProgress == null ) {
			this.taskQueueInProgress = new ArrayList<Task>();
		}
    }
    
    /**
     * Adding a task to queue to be processed.
     * 
     * @param id
     * @param ms
     */
    public void add(int id, int ms) {
    	this.taskQueue.add(new Task(id,ms));
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ResponsiveUI rui = new ResponsiveUI();
		Scanner in = new Scanner(System.in);
		int i = 0;
		
		// Until user enters a value
		while(true) {
			System.out.println("Enter the duration (in ms) of task " + i + ": ");

			int ms;
			String userInput = null;
			
			while ( userInput == null ) {
			    try {
			    	userInput = in.nextLine();
				    ms = Integer.parseInt(userInput);
				    rui.add(i, ms);
	    		    Thread t = new Thread(rui);
	    		    t.start();
	    		    i++;
				
			    } catch (NumberFormatException nfe) {
    				if ( userInput != null && userInput.toUpperCase().equals("EXIT") ) break;
    				System.out.println("Please ente a valid integer number:");
    				userInput = null;
    			}
			}
			rui.printTasksFinished();
			if ( userInput.toUpperCase().equals("EXIT") ) break;

		}
		in.close();
		System.out.println("Exiting the program. Waiting for all threads to finish...");
		while(!rui.taskQueueInProgress.isEmpty()) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		rui.printTasksFinished();
		System.out.println("Finished.");
	}

	/**
	 * Grab a task from the queue and processes it.
	 * Then stores the result into the finished tasks list.
	 */
	@Override
	public void run() {
       	try {
       		Task t = getNextTask();
    		Thread.sleep(t.getMs());
    		taskQueueInProgress.remove(t);
	    	tasksFinished.add(t);

       	} catch (InterruptedException e) {
   			e.printStackTrace();
    	}
	}
	
	/**
	 * Picking up a task: one per thread.
	 *  
	 * @return
	 */
	private synchronized Task getNextTask() {
		if ( this.taskQueue.isEmpty() ) {
			return null;
		}
		
		Task t = taskQueue.remove(0);
		this.taskQueueInProgress.add(t);
		
		// Move all down the queue
		for( int i = 0; i < taskQueue.size(); i++ ) {
			taskQueue.set(0, taskQueue.get(i+1));
		}
		
		return t;
	}

	/**
	 * Display tasks finished.
	 * This must be done synchronised to avoid any other tasks 
	 * being finished and lost while clearing the completed list.
	 */
	private synchronized void printTasksFinished() {
		String finalTasks = "";
        for(Task task : this.tasksFinished) {
	        finalTasks += task.getId() + " ";
		}
        // Reset the List
        this.tasksFinished = new ArrayList<Task>();
        System.out.println("Finished tasks: " + finalTasks);
	}

}
