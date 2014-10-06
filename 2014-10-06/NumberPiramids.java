import java.util.Scanner;
public class NumberPiramids
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
for(int i = 0; i <= 7 ; i++ ) {
  for(int j = 0; j < i; j++ ) {
    System.out.print(i);
  }
  System.out.println();
}

System.out.println("\\ldots");
}}

