package q4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Takes two names from command line.
 * If first file name exists, copy contents of first into the second name give.
 * If first name does not exist, it must say so, and if second does not exist,
 * asks user if it is to be created, or if it is to be overridden otherwise.
 * 
 * @author Vasco
 *
 */
public class Cp {

	/**
	 * Main program.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Cp cp = new Cp();
		cp.launch(args);
	}
	
	/**
	 * Launching the program.
	 * 
	 * @param args
	 */
	private void launch(String[] args) {
		if ( args.length != 2 ) {
			System.out.println("Invalid arguments.");
			System.out.println("Please use Cp <filename from> <filename to>");
			return;
		}

		String fileFrom = args[0];
		String fileTo   = args[1];

		if ( existFile(fileFrom) ) {
			if ( !existFile(fileTo) ) {
				// If no file to copy to, ask user if this is to be created.
				System.out.println("File: '" + fileTo + "' does not exist. Create it? Y/N ");
				Scanner in = new Scanner(System.in);
				String response = in.next();
				in.close();
				if ( response.toLowerCase().equals("y")) {
					if ( ! createFile(fileTo) ) {
						System.out.println("File '" + fileFrom + "' was not created for some reason.");
						return;
					}
				}
				else {
					System.out.println("No copy was made. Exiting..");
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
