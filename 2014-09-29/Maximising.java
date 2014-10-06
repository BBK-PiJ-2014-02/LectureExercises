import java.util.Scanner;
public class Maximising
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
System.out.println("Please enter a positive number (-1 to end): ");
String str = System.console().readLine();
int i = Integer.parseInt(str);
int max = 0;
while ( true ) {
  if ( i == -1 ) {
    break;
  }
  System.out.println("Please enter a positive number (-1 to end): ");
  str = System.console().readLine();
  i = Integer.parseInt(str);
  if ( i > max ) {
      max = i;
  }
}

System.out.println("The maximum nunber entered was: " + max);
}}

