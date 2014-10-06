import java.util.Scanner;
public class PrimeNumbers
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
System.out.println("Enter a number (q to quit):"); 
String str = System.console().readLine();
while ( true ) {
  if ( str.equals("Q") | str.equals("q") ) {
    break;
  } 
  else {
    int i = Integer.parseInt(str);
    if ( isPrime(i) ) {
      System.out.println (i + " is a prime number.");
    } 
    else {
      System.out.println (i + " is not a prime number.");
    }
  }
  str = System.console().readLine();
}

} private static boolean isPrime (int i) {
  if ( i == 1 ) { 
    return true; 
  }
  
  for ( int j = 2; j < i; j++ ) {
    if ( (i % j) == 0 ) {
      return false;
    }
  }
  return true;
}
}

