import java.util.Scanner;
public class RockPaperScissors
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
System.out.println("Please enter the list of results separated by space: (PP PR PS RP RR RS SP SR SS) ");
String str = System.console().readLine();
String plays[] = str.split(" ");
int score[] = new int[2]; // To store player 1 and 2 scores

for(int i = 0; i < plays.length; i++ ) {
  String player1 = plays[i].substring(0,1);
  String player2 = plays[i].substring(1,2);
  if ( player1.equals(player2) ) {
      continue;
  }
  System.out.println(plays[i] + " " + player1 + " " + player2);
}

}}

