package q7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/**
 * Read from given filename and print lines on the screen.
 * If file has duplicated lines, these should not be printed.
 *
 * @author vdiasf01
 *
 */
public class Uniq {

	/**
	 * Main.
	 * 
	 * @param args filename
	 */
	public static void main(String[] args) {
		Uniq u = new Uniq();
		String[] arg = {"t"};
		u.launch(arg);
	}
	
	/**
	 * Launching the application.
	 * 
	 * @param args from command line
	 */
	private void launch(String[] args) {
		// Interpret the args and expected file name.
		if ( args == null || args.length == 0 ) {
			System.out.println("Please supply a filename.");
			return;
		}
		String filename = args[0];
		File file = new File(filename);
		if ( file.exists() ) {
			if ( printUniqList(getFile(filename)) ) { 
			    System.out.println("\n\nThere were duplicated lines");
			}
		}
		else {
		    System.out.println("File '" + filename + "' does not exist.\nPlease supply a valid filename.");
		}
	}
	
	/**
	 * Loads up file contents into a String list and return it
	 *   
	 * @param filename
	 * @return List<String>.
	 */
	private List<String> getFile(String filename) {
		List<String> list = new ArrayList<String>();
		
		File file = new File(filename);
		BufferedReader in = null;
		
		try {
			in = new BufferedReader(new FileReader(file));
			String line;
			while( ( line = in.readLine() ) != null ) {
				list.add(line);
			}
			
		} catch ( FileNotFoundException e ) {
			if ( in != null ) {
				try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
			
		} catch (IOException e) {
			if ( in != null ) {
				try {
					in.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	/**
	 * Goes through the given list and checks for unique elements
	 * Prints on screen all unique elements and once the duplicates
	 * on the list time they are found in the file
	 * 
	 * @param list
	 * @return true if there were duplicate lines
	 */
	private boolean printUniqList(List<String> list) {
		Boolean duplicatedLines = false;
		
		if ( list == null || list.size() == 0) {
			System.out.println("The file is empty!");
			return false;
		}

		// HashMap to store all lines on how many times they exist.
		HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

		// Load the HashMap
		for( String element : list ) {
			if ( hm.get(element.hashCode()) == null ) {
				hm.put(element.hashCode(),1);
			}
			else {
				Integer i = hm.get(element.hashCode());
				hm.put(element.hashCode(),++i);
			}
		}
		
		// Check the list for duplicates
		for( String element : list ) {
			// If there are more than one record, 
			// decrease the value such that it will get printed
			// at least once, on the last occurence in file.
			if ( hm.get(element.hashCode()) > 1 ) {
				Integer value = hm.get(element.hashCode());
				hm.put(element.hashCode(), --value);

				duplicatedLines = true;
				continue;
			}
			else {
    			System.out.println(element);
			}
		}

		return duplicatedLines;
	}
}
