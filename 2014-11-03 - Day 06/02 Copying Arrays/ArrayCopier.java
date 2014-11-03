/** Day 6 - Exercise 2 - Array Copier **/

public class ArrayCopier {

  public void copy(int[] src, int[] dst) {
	int srcLength = src.length;
    for( int i = 0; i < dst.length; i++ ) {
	  if ( srcLength > i ) {
        dst[i] = src[i];
      }
      else {
        dst[i] = 0;
      }
    }
  }

  public void initializeSrc(int[] src, int value) {
  	for(int i = 0; i < src.length; i++ ) {
      src[i] = value;
    }
  }

  public void printResults(int[] src, int[] dst) {
  	// Print source array
  	System.out.println("Source array:");
    for(int i = 0; i < src.length; i++ ) {
  	  System.out.print("\t"+src[i]);
    }
  	// Print destination array
  	System.out.println("\nDestination array:");
    for(int i = 0; i < dst.length; i++ ) {
      System.out.print("\t"+dst[i]);
    }
  }
}