import java.util.Scanner;
public class YetAnotherLoop
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
String str = System.console().readLine();
int i = Integer.parseInt(str);
while (i < 10) {
  i++;
  str = System.console().readLine();
  int j = Integer.parseInt(str);
  if (j == 0) {
    break;
  } else if (j != 1) {
    System.out.println(j);
  }
}
System.out.println("finished!");
  
}}

