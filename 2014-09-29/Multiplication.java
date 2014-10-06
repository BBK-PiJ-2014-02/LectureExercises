import java.util.Scanner;
public class Multiplication
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
System.out.println("Enter first number to multiply:"); 
String str1 = System.console().readLine();
int a = Integer.parseInt(str1);
System.out.println("Enter second number to multiply:"); 
String str2 = System.console().readLine();
int b = Integer.parseInt(str2);


int result = multiply(a,b);
System.out.println("The result is: " + a + " * " + b + " = " + result);


} private static int multiply (int a, int b) {
  int result = 0;
  for ( int j = 1; j <= b; j++ ) {
    result += a;
  }
  return result;
}

}

