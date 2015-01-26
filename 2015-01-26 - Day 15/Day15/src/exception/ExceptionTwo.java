package exception;

import java.util.ArrayList;
import java.util.List;

/**
 * Checking if the Catch is catching in order.
 * 
 * @author vdiasf01
 *
 */
public class ExceptionTwo {

	/**
	 * Main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ExceptionTwo et = new ExceptionTwo();
		et.launch(0);
	}

	/**
	 * Launching method.
	 * 
	 * @param userInput
	 */
	public void launch(Integer userInput) {
		List<Integer> inList = new ArrayList<Integer>();
		inList.add(1);
		inList.add(2);
		inList.add(3);
		inList.add(4);
		inList.add(5);
		inList.add(6);
		try {
			inList.remove(0);
			System.out.println("A"+inList.get(userInput)); // Error
			inList.remove(0);
			System.out.println("B"+inList.get(userInput)); // 
			inList.remove(0);
			System.out.println("C"+inList.get(userInput)); // 
			inList.remove(0);
			System.out.println("D"+inList.get(userInput)); //  
			inList.remove(0);
			System.out.println("E"+inList.get(userInput)); // 
			inList.remove(0);
			System.out.println("F"+inList.get(userInput)); // 
			inList.remove(0);
			System.out.println("G"+inList.get(userInput));

	    // Exception e cannot be before any other specified exception
	    // Exception is to catch any other case not foreseen in the code.
		} catch (NullPointerException ex ) {
			ex.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}
}
