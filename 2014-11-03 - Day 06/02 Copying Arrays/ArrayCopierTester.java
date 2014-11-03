/** Testing Array Copier class **/

public class ArrayCopierTester {

  public static void main( String[] args ) {
    int[] small  = new int[2];
    int[] medium = new int[5];
    int[] big    = new int[10];

    ArrayCopier ac = new ArrayCopier();
    ac.initializeSrc(small, 5);
    ac.initializeSrc(medium, 3);
    ac.initializeSrc(big, 1);
    ac.copy(small,medium);
    ac.printResults(small,medium);
  }
}