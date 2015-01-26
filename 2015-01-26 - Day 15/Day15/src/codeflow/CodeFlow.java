package codeflow;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 1
 * Testing code flow
 * @author vdiasf01
 *
 */
public class CodeFlow {

	/**
	 * Main method.
	 * 
	 * @param arg 
	 */
	public static void main(String[] arg) {
	   CodeFlow cf = new CodeFlow();
//	   cf.launch(0);
//	   cf.launch(2);
//	   cf.launch(4);
	   cf.launch(6);
	}
	
	/**
	 * Launching method.
	 * 
	 * @param userInput int input
	 */
	public void launch(int userInput) {
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
		} catch (IndexOutOfBoundsException ex) {
			ex.printStackTrace();
		}
		
	}
}
