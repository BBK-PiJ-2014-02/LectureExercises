import java.util.Scanner;
public class NaiveSorting
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
System.out.println("Enter first number:"); 
String str1 = System.console().readLine();
int n1 = Integer.parseInt(str1);
System.out.println("Enter second number:"); 
String str2 = System.console().readLine();
int n2 = Integer.parseInt(str2);
System.out.println("Enter third number:"); 
String str3 = System.console().readLine();
int n3 = Integer.parseInt(str3);

if ( n1 < n2 ) {
  if ( n2 < n3 ) {
    System.out.println( n1 + " " + n2 + " " + n3 );
  } 
  else if ( n1 < n3 ) {
    System.out.println(n1 + " " + n3 + " " + n2);
  } 
  else {
    System.out.println(n3 + " " + n1 + " " + n2);
  }
} 
else {
  if ( n1 < n3 ) {
    System.out.println( n2 + " " + n1 + " " + n3 );
  } 
  else if ( n2 < n3 ) {
    System.out.println( n2 + " " + n3 + " " + n1 );
  } 
  else {
    System.out.println( n3 + " " + n2 + " " + n1 );
  }
} 

}}

