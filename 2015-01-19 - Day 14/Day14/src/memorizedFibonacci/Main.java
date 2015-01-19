package memorizedFibonacci;

/**
 * Testing Fibonacci efficiency 
 * using memorized and non-memorized 
 * dynamic programming.
 * 
 * @author vdiasf01
 *
 */
public class Main {

	/**
	 * Main. 
	 * 
	 * @param arg
	 */
	public static void main(String[] arg) {
		// Initializing the non memorized Fibonacci.
		Fibonacci f = new FibonacciImpl();
		
		// Initializing the memorized Fibonacci.
		Fibonacci fm = new MemFibonacciImpl();
		
		// Current starting time.
		long fiboStartTime    = System.currentTimeMillis();
		
		int nonMem = f.fib(50);
		
		// Current ending time / starting time for memorized Fibonacci.
		long fiboEndTime      = System.currentTimeMillis();
		
		int mem = fm.fib(50);
		
		// Finished time
		long memFiboEndTime   = System.currentTimeMillis();
		
		// Displaying results.
		System.out.println("Normal    Fibonacci: "+nonMem+" took: "+(fiboEndTime - fiboStartTime)+"ms");
		System.out.println("Memorized Fibonacci: "+mem+" took: "+(memFiboEndTime - fiboEndTime)+"ms");
	}
}
