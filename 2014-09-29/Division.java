import java.util.Scanner;
public class Division
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
System.out.println("Enter the dividend:"); 
String str1 = System.console().readLine();
int dividend = Integer.parseInt(str1);

System.out.println("Enter the divisor:"); 
String str2 = System.console().readLine();
int divisor = Integer.parseInt(str2);

int result = 0;
int remainder = 0;

if ( divisor > dividend ) {
    remainder = dividend;
} else if ( divisor == dividend ) {
    result = 1;
} else {
    while ( (result * divisor) <= dividend ) {
        result++;
    }
    result--;
    remainder = ( dividend - (result * divisor) );
}

System.out.println(dividend+" divided by "+divisor+" is "+result+", remainder "+remainder);
}}

