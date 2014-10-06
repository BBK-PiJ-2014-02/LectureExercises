import java.util.Scanner;
public class HighLow
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
int current = 0, previous = 0;
String str, result = "Yes", method = null;

while ( true ) {
  System.out.println("Please enter a positive number (-1 to end): ");
  str = System.console().readLine();
  current = Integer.parseInt(str);

  if ( current == -1 ) {
    break;
  } else {
      if ( method == null ) {
          if ( previous > 0 ) {
              if ( previous > current ) {
                  method = "Low";
              } else if ( previous < current ) {
                  method = "High";
              } else {
                  // Nothing to be done when both are equal
              }
          }
      } else {
          if ( method == "Low" && previous <= current && result == "Yes" ) {
              result = "No"; 
          } 
          else if ( method == "High" && previous >= current && result == "Yes" ) {
              result = "No";
          }
      }
  }
  previous = current;
}

System.out.println("The result is: " + result);
}}

