package q5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Command line program to read from a file and print on the screen
 * file contents, substituting the second word in the command line
 * after file name with the third word, where it is found inside the
 * file contents.
 * 
 * @author Vasco
 *
 */
public class Tr {
    /**
     * Main program.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Tr tr = new Tr();
        tr.launch(args);
    }
    
    /**
     * Launching the program.
     * 
     * @param args
     */
    private void launch(String[] args) {
        if ( args.length < 3 ) {
            System.out.println("Invalid arguments.");
            System.out.println("Please use Tr <file> <original word> <substituing word>");
            return;
        }

        String file  = args[0];
        String word1 = args[1];
        String word2 = args[2];
        
        printSubstitute(file, word1, word2);
        
    }

    /**
     * Substitute contents of the file 
     * where word1 is found, print word2.
     * 
     * @param fileName The file name
     * @param word1 word to be substituted
     * @param word2 word to be used instead
     */
    private void printSubstitute(String fileName, String word1, String word2) {
        File file = new File(fileName);

        if ( file.exists() ) {
            BufferedReader fIn = null;
        
            try {
                fIn = new BufferedReader(new FileReader(fileName));
                String line;

                while(( line = fIn.readLine() ) != null ) {
                    line = line.replace(word1, word2);
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
