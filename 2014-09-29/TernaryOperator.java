import java.util.Scanner;
public class TernaryOperator
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
int currentYear = 2012;
System.out.print("When were you born (year)?");
String str = System.console().readLine();
int birthYear = Integer.parseInt(str);
int ageAprox = currentYear - birthYear;
String result = (ageAprox > 17) ? "" : "not ";
System.out.println("It seems you are " + result + "an adult.");
}}

