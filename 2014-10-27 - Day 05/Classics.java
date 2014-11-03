import java.util.Scanner;
public class Classics
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
/** Day 5 - Exercise 2 - Classics **/

/** a) Factorial **/
System.out.println("Hannoi(32): "+hannoi(2));


// Recursive
} private static int factorial( int n ) {
  if ( n <= 0 ) {
    return 1;
  }
  return factorial(n-1) * n;
}

// Iteractive
 private static int factorial2( int n ) {
  int result = 1;
  for(int i = n; i > 0; i--) {
    result *= i;
  }
  return result;
}


/** b) Fibonacci **/

// Recursive
 private static int fibo( int n ) {
  if ( n < 2 ) {
    return 1;
  }
  return ( fibo(n-1) + fibo(n-2) );
}

// Iteractive
 private static int fibo2( int n ) {
  int result   = 1;
  int prev     = 1;
  int prevprev = 1;
  for ( int i = n; i >= 2; i-- ){
    prevprev = prev;
    prev     = result;
    if ( prev > 0 && prevprev > 0 ) {
      result = prev + prevprev;
    } 
  }
  return result;
}


/** c) Hannoi towers **/
 private static long hannoi( int discs ) {
  if ( discs <= 1 ) {
    return 1;
  }
  return ( 2 * hannoi(discs-1) + 1 );
}
}

