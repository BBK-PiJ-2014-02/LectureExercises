package errorHandlingOnUserInput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MeanAverage {

	/**
	 * Main method.
	 * 
	 * @param arg
	 */
	public static void main(String[] arg) {
		MeanAverage ma = new MeanAverage();
		ma.launch();
	}
	
	/**
	 * Launching method.
	 */
	public void launch() {
		int userInt[] = new int[10];
		
		for ( int i = 0; i < 10; i++ ) {
			System.out.println("Please supply an integer "+i+" of 10: ");
			UserResponse ur = getInt();
			if ( ur.hasError ) {
				i--;
			}
			else {
				userInt[i] = ur.value; 
			}
		}
		
		System.out.println("The average is : "+ getAverage(userInt));
	}

	/**
	 * Collect an int from user 
	 * 
	 * @return UserResponse
	 */
	private UserResponse getInt() {
		
		// Initialise the UserResponse
		UserResponse ur = new UserResponse();		
		
		try {

			// Initialise Scanner.
			Scanner userInput = new Scanner(System.in);

			// Try collecting the integer.
			ur.value = userInput.nextInt();
			
		} catch ( InputMismatchException e ) {

			System.out.println("Please supply a valid integer: ");
			ur.hasError = true;			
		}
		
		return ur;
		
	}
	
	private double getAverage(int[] userInt) {
		if ( userInt.length == 0 ) {
			return 0;
		}
		
		int average = 0;
		for( int i = 0; i < userInt.length; i++) {
			average += userInt[i]; 
		}
		
		return ( average / userInt.length );
	}
}
