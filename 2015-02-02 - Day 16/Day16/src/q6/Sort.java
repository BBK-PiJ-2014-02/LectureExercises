package q6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Sort the lines of a file alphabetically and print them on the screen.
 * Exceptions apply if the file does not exist.
 * 
 * @author vdiasf01
 *
 */
public class Sort {

	/**
	 * Main.
	 * 
	 * @param args filename
	 */
	public static void main(String[] args) {
		Sort s = new Sort();
		s.launch(args);
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
			printList(getFileSorted(filename));
		}
		else {
		    System.out.println("File '" + filename + "' does not exist.\nPlease supply a valid filename.");
		}
	}
	
	/**
	 * Loads up file contents into a String list to then be returned sorted
	 *  
	 * @param filename
	 * @return List<String> sorted.
	 */
	private List<String> getFileSorted(String filename) {
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
		
		// Sort the list alphabetically
		list.sort(null);
		
		return list;
		
	}
	
	private void printList(List<String> list) {
		if ( list == null || list.size() == 0) {
			System.out.println("The file is empty!");
			return;
		}
		
		for( String element : list ) {
			System.out.println(element);
		}
		
	}
}


