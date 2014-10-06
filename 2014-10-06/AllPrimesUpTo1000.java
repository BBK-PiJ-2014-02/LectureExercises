import java.util.Scanner;
public class AllPrimesUpTo1000
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
int primesFound = 0;
int number = 1;

while( number <= 1000 ) {
  number++;  
  if ( isPrime(number) ) {
    primesFound++;
    System.out.println("Found the "+primesFound+"th prime: "+number);
  }
}

System.out.println("Finished!");

} private static boolean isPrime(int number) {
  for( int i = 2; i < number; i++ ) {
    if ( number%i == 0 ) {
      return false;
    }
  }
  return true;
}
}

