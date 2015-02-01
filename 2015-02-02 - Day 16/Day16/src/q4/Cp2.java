package q4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Accepts many file names where the last name is a directory.
 * Copies all files into that directory.
 * If the directory does not exist, asks if it is to be created.
 * 
 * @author Vasco
 *
 */
public class Cp2 {
	/**
	 * Main program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Cp2 cp2 = new Cp2();
		cp2.launch(args);
	}
	
	/**
	 * Launching the program.
	 * 
	 * @param args
	 */
	private void launch(String[] args) {
		if ( args.length < 2 ) {
			System.out.println("Invalid arguments.");
			System.out.println("Please use Cp <file 1> .. <file n> <destination directory>");
			return;
		}

		List<String> filesFrom = new ArrayList<String>();
		
		for( int i = 0; i < args.length-1; i++ ) {
			System.out.println("Will copy file: "+args[i]);
			filesFrom.add(args[i]);
		}
		
		String directoryTo = args[args.length-1];
		
		for(String fileFrom : filesFrom ) {
			copyTo(fileFrom,directoryTo);
		}
		
		System.out.println("Finished.");
	}

	/**
	 * Copy from fileFrom to folder.
     *
	 * If fileFrom does not exist inside the folder, it is created.
	 * If it exists, it is replaced.
	 * 
	 * @param fileFrom
	 * @param folder
	 */
	private void copyTo(String fileFrom, String folder) {
		if ( ! createDir(folder) ) {
			System.out.println("Could not create the new dir for some reason.");
			return;
		}

		String fileTo = folder + File.separatorChar + fileFrom;
		if ( existFile(fileFrom) ) {
    		if ( !existFile(fileTo) ) {
     			if ( ! createFile(fileTo) ) {
   					System.out.println("File '" + fileFrom + "' was not created for some reason.");
   					return;
   				}
    		}
    		else {
				// If file already exists at destination, ask user if it is to be replaced.
				System.out.println("File: '" + fileTo + "' already exists. Replace it? Y/N ");
				String response = System.console().readLine();
				if ( response.toLowerCase().equals("n")) {
					System.out.println("Skipping file '" + fileFrom + "'.");
					return;
				}
    		}
    		copy(fileFrom, fileTo);
    	}
    	else {
    		// If fileFrom does not exist, no further actions will be made.
    		System.out.println("Filename : '" + fileFrom + "' does not exist." );
    	}
	}
	
	private boolean createDir(String folder) {
		File dir = new File(folder);
		if ( !dir.exists() ) {
			dir.mkdir();
			return false;
		}

	    return true;
	}

	/**
	 * Copy from fileFrom to fileTo.
     *
	 * If fileTo does not exist, this is created.
	 * It it exists, it is replaced.
	 * 
	 * @param fileFrom
	 * @param fileTo
	 */
	private void copy(String fileFrom, String fileTo) {
		BufferedReader from = null;
		BufferedWriter to   = null;
		try {
			from = new BufferedReader(new FileReader(fileFrom));
			to   = new BufferedWriter(new FileWriter(fileTo));
			String line;
			while ( ( line = from.readLine() ) != null ) {
			    to.append(line+"\n");
			}
		
		} catch (FileNotFoundException e ) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();

		} finally {
			try {
				if ( from != null ) {
					from.close();
				}
				if ( to != null ) {
					to.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("Copied '" + fileFrom + "' to '" + fileTo + "'");
	}
	
	/**
	 * Check if filename given exists or not.
	 * 
	 * @param fileName
	 * @return true if file exists.
	 */
	private boolean existFile(String fileName) {
		File f = new File(fileName);
		return f.exists();
	}

	/**
	 * Creates a new file.
	 * 
	 * @param fileName
	 * @return true if created.
	 */
	private boolean createFile(String fileName) {
		File f = new File(fileName);
		try {
			return f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
