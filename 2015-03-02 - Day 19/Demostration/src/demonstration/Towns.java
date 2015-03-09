package demonstration;

import java.util.Arrays;
import java.util.List;

/**
 * Example 2.
 * 
 * @author vdiasf01
 *
 */
public class Towns {
	
	static boolean foundTown(List<String> towns, String town) {
		boolean found = false;
		
		for(String t : towns) {
			if (t.equals(town)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
    public static void main(String[] args) {
    	List<String> towns = Arrays.asList("Chelmsford","Canterbury","Oxford", "Cambridge","Norwich","Exeter");
    	
//    	System.out.println(foundTown(towns, "Exeter"));
//    	System.out.println(foundTown(towns, "Bath"));
    	
//    	System.out.println(towns.contains("Exeter"));
//    	System.out.println(towns.contains("Bath"));
    	
//		Iterator i = towns.iterator();
//		while(i.hasNext()) {
//			System.out.println("Next: " + i.next());
//		}

//		for(Iterator i = towns.iterator(); i.hasNext();) {
//			System.out.println("Next: " + i.next());
//		}

    	// Enhanced for-loop
    	for(String s : towns) {
			System.out.println("Next: " + s);
    	}
    }
}
