package q5;

/**
 * This class launched two heavy computations
 * sequentially first, then in parallel. 
 * Assuming there is more than one processor in 
 * the machine, parallel computations finish
 * earlier.
 */
public class ComputationLauncher {   
    /**
     * How many numbers to process? If too low, there is no noticeable
     * difference.
     */
     public static final int COUNT = 200000000;

     /**
      * Number of processors found in current machine
      */
     public static final int PROCESSORS = Runtime.getRuntime().availableProcessors();
     
     /**
      * The computations to be performed. Stored as fields so 
      * both methods (sequential and parallel) act on exactly 
      * the same data
      */
     private Computation[] computations = new Computation[PROCESSORS];
     
     /**
     * The main method that launches the computations
     *
     * @param args command-line arguments, ignored
     */
    public static void main(String args[]) {
	  ComputationLauncher c = new ComputationLauncher();
	  c.launch();
    }
   
    /**
     * Create a new double array with given size initialised with random numbers.
     * 
     * @param size int size of the array
     * @return double array.
     */
    private double[] createArray(int size) {
	  double[] result = new double[size];
	  for (int i = 0; i < result.length; i++) 
		{
		    result[i] = Math.random();
		}
	  return result;
    }
   
    /**
     * Launch method.
     */
    private void launch() {
    	// Amount of processors being used
        System.out.println("#CPU: " + PROCESSORS);

        long start, stop;

        for( int i = 0; i < PROCESSORS; i++ ) {
		    computations[i] = new Computation(createArray(COUNT/PROCESSORS));
		}

        start = System.currentTimeMillis();
        sequentialComputations();
        stop = System.currentTimeMillis();
	    System.out.println("Time without threads: " + (stop - start) + "ms");
	    start = System.currentTimeMillis();
	    parallelComputations();
	    stop = System.currentTimeMillis();
	    System.out.println("Time with threads: " + (stop - start) + "ms");
    }
   
    /**
     * Sequential computation.
     */
    private void sequentialComputations() {
    	for( int i = 0; i < PROCESSORS; i++ ) {
    		computations[i].run();
    	}

    	double result = 0;
	    for( int i = 0; i < PROCESSORS; i++ ) {
	  	    result += computations[i].getResult();
	    }
	    System.out.println("Result: " + (result));
    }
   
    /**
     * Parallel computation using threads.
     */
    private void parallelComputations() {
    	for( int i = 0; i < PROCESSORS; i++ ) {
    		Thread t = new Thread(computations[i]);
    		t.start();
    	}
      	  
    	double result = 0;
    	
    	for( int i = 0; i < PROCESSORS; i++ ) {
    		result += computations[i].getResult();
    	}
	    System.out.println("Result: " + (result));
    }
}
