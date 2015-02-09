package q4;


/**
 * Task class to be used by the ResponsiveUI
 * 
 * @author vdiasf01
 *
 */
public class Task {
	/**
	 * The task id.
	 */
	private int id;
	
	/**
	 * The delay in ms.
	 */
	private int ms;
	
	/**
	 * Constructor.
	 * 
	 * @param id
	 * @param ms
	 */
	public Task(int id, int ms) {
		this.id = id;
		this.ms = ms;
	}
	
	/**
	 * Getting the task id.
	 * 
	 * @return
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Getting the set delay in ms.
	 * 
	 * @return
	 */
	public int getMs() {
		return this.ms;
	}
}
