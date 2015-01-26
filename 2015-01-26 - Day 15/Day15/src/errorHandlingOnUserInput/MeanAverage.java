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
		System.out.println("How many numbers would you like to enter to be averaged? ");
		UserResponse ur = getInt();
		while( ur.hasError ) {
			ur = getInt();
		}
				
		int userInt[] = new int[ur.value];
		
		for ( int i = 0; i < ur.value; i++ ) {
			System.out.println("Please supply the integer "+(i+1)+" of "+ur.value+": ");
			UserResponse ur2 = getInt();
			if ( ur2.hasError ) {
				i--;
			}
			else {
				userInt[i] = ur2.value; 
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
	
	/**
	 * Calculate the Average of an int array.
	 * 
	 * @param userInt int array
	 * 
	 * @return double averaged.
	 */
	private double getAverage(int[] userInt) {
		if ( userInt.length == 0 ) {
			return 0;
		}
		
		double average = 0;
		for( int i = 0; i < userInt.length; i++) {
			average += (double)userInt[i]; 
		}

		return (double)((double)average / (double)userInt.length );
	}
}
