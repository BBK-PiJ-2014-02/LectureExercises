import java.util.Scanner;
public class GuessMyNumber
{
		private static Scanner scanner=new Scanner(System.in); static{scanner.useDelimiter(System.getProperty("line.separator"));}
	public static void main(String[] args)
	{
System.out.println("Try to guess my number!");
System.out.print("Tell me a number: ");
String str = System.console().readLine();
int guessedNumber = Integer.parseInt(str);
int guesses = 0;
int numberToGuess = (int) Math.abs(1000 * Math.random());

while (true) {
  guesses++;
  if ( numberToGuess == guessedNumber ) {
    System.out.println("CORRECT!\nYou needed "+guesses+" guess(es).");
    break;
  }
  else if ( numberToGuess > guessedNumber ) {
    System.out.println("No! My number is higher.");
  }
  else if ( numberToGuess < guessedNumber ) {
    System.out.println("No! My number is lower.");
  }

  System.out.print("Tell me a number: ");
  str = System.console().readLine();
  guessedNumber = Integer.parseInt(str);
}
}}

