import java.util.Scanner;
public class GoingUp
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
int i = 0, max = 0;
String str, result = "Yes";

while ( true ) {
  System.out.println("Please enter a positive number (-1 to end): ");
  str = System.console().readLine();
  i = Integer.parseInt(str);
  if ( i == -1 ) {
    break;
  }
  if ( i >= 0 && i > max && result == "Yes") {
      max = i;
  } else if ( i > 0 && max > i ) {
      result = "No";
  }
  System.out.println(" result: " + result + " m: " + max + " i: " + i);
}

System.out.println("The result is: " + result);
}}

