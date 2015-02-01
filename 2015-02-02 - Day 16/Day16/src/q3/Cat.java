package q3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Reads file from username a name and check if the file exists.
 * If the file exists, prints the contents on the screen.
 * 
 * @author Vasco
 *
 */
public class Cat {

	public static void main(String[] args) {
		Cat c = new Cat();
		c.launch();
	}
	
	private void launch() {
		
		System.out.println("Please enter a list of files to be checked. Enter: 'print files' when ready: ");
		Scanner in = new Scanner(System.in);
		List<String> fileNames = new ArrayList<String>();

		String name;
		boolean exit = false;

		while ( !exit ) {
            name = in.nextLine();
            if ( name.equals("print files") ) {
            	exit = true;
            }
            else {
                System.out.println(name);
	    		fileNames.add(name);
            }
		}
		
		in.close();
		
		for(int i = 0; i < fileNames.size(); i++) {
			System.out.println("Checking for file name .. " + fileNames.get(i));
    		printFile(fileNames.get(i));
		}

	}
	
	private void printFile(String fileName) {
    	File file = new File(fileName);

	    if ( file.exists() ) {
        	BufferedReader fIn = null;
		
    		try {
	    		fIn = new BufferedReader(new FileReader(fileName));
		    	String line;

	    		while(( line = fIn.readLine() ) != null ) {
    				System.out.println(line);
		    	}

    		} catch (FileNotFoundException e) {
	    		e.printStackTrace();

    		} catch (IOException e) {
	    		e.printStackTrace();
		    }
    	
    	} else {
        	System.out.println("File '" + fileName + "' not found.");
    	}
	}
}
