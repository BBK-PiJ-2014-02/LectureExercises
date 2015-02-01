package q1;

import java.io.File;

public class Ls {

    /**
     * Mail method
	 * @param arg
	 */
	public static void main(String[] arg) {
		
		// Printing a list of files in current directory
		File folder = new File(".");
		for(String name : folder.list() ) {
			System.out.println(name);
		}
	}
}
