package q8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads from a cvs comma separated file integer values.
 * Output the average for every line pus the average for the whole file. 
 * @author vdiasf01
 *
 */
public class TemperatureAverages {

	/**
	 * Main.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
        TemperatureAverages ta = new TemperatureAverages();
        String arg[] = { "average.csv" };
        ta.launch(arg);
	}
	
    /**
     * Launching the program.
     * 
     * @param args
     */
    private void launch(String[] args) {
        if ( args.length < 1 ) {
            System.out.println("Invalid arguments.");
            System.out.println("Please use TemperatureAverages <file>");
            return;
        }

        String file  = args[0];
        
        List<String> list = loadFile(file);
        List<Double> parsedListLineAveraged = parseList(list);
        calculateAveragesAndPrint(parsedListLineAveraged);
    }
    
    private void calculateAveragesAndPrint(List<Double> list) {
    	Double totalAvg = 0.0;
    	Integer lines = list.size();
    	for( Double lineAvg : list ) {
    		System.out.println("Line avg: " + lineAvg);
    		totalAvg += lineAvg;
    	}
    	
    	totalAvg = (Double) totalAvg/lines;
    	
    	System.out.println("Total average = " + totalAvg);
    	
    }
    
    private List<Double> parseList(List<String> list) {
    	List<Double> parsedList = new ArrayList<Double>();
    	for( String line : list ) {
    		String[] lineSplit = line.split(",");
    		Integer lineAvg = 0;
    		Integer lineAmount = lineSplit.length;
    		for( String strNum : lineSplit ) {
    			strNum = cleanString(strNum);
    			try {
                    lineAvg += Integer.parseInt(strNum);
    			} catch ( Exception e ) {
    				e.printStackTrace();
    			}
    		}
    		if ( lineAmount > 0 ) {
    		    parsedList.add((double)lineAvg/lineAmount);
    		}
    		else {
    			System.out.println("Skipping this line due to no numbers found: '"+line);
    		}
    	}
    	return parsedList;
    }
    
    private String cleanString(String str) {
		String cleanStr = "";
  		for( int i = 0; i < str.length(); i++ ) {
   			if ( "0123456789".contains(str.charAt(i)+"") ) {
       			cleanStr += str.charAt(i);
   			}
   		}
   		return cleanStr;
    }
    
    /**
     * Load each line into a List.
     * 
     * @param file
     */
   	private List<String> loadFile(String file) {
   		List<String> list = new ArrayList<String>();
   		
   		if ( file == null ) {
   			return list;
   		}
   		
   		File f = new File(file);
   		if ( f.exists() ) {
   			BufferedReader in = null;
   			try{
   				in = new BufferedReader(new FileReader(f));
   				String line;
				while( (line = in.readLine()) != null ) {
					list.add(line);						
				}
				in.close();
   				
   			} catch (FileNotFoundException e) {
   				e.printStackTrace();
   				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   			} catch ( IOException e ) {
   				e.printStackTrace();
   				try {
					in.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
   			}
   		}
   		else {
   			System.out.println("File '" + file + "' does not exist.");
   		}
   		
   		return list;
   	}
   		
}
