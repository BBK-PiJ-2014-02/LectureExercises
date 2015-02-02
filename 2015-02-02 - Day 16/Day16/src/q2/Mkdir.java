package q2;

import java.io.File;
import java.util.Scanner;

public class Mkdir {

	/**
     * Mail method
     * Asks user for a name for the new folder to be created in current path.
     * Creates the folder or outputs any errors thrown.
     * 
	 * @param arg
	 */
	public static void main(String[] arg) {

		System.out.println("Please enter the folder name to be created: ");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		in.close();
		
		System.out.println("Creating folder name: "+name);
		File folder = new File(name);

		if ( folder.mkdir() ) {
	    	System.out.println("New folder " + name + " created.");
	    	
		} else {
	    	System.out.println("New folder " + name + " not created.");
		}
	}

}
