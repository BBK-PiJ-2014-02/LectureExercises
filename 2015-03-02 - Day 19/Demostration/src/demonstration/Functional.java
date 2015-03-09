package demonstration;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Code to return a list where all the names are returned upper case. 
 * 
 * @author vdiasf01
 *
 */
public class Functional {
	public static void main(String[] args) {
	    final List<String> friends = Arrays.asList("John","Kevin","Albert","Betty","Joan","Vera","Isobel","Mickey");
	    
//	    List<String> uc = new ArrayList<String>();
	    
//	    friends.forEach( (String s)	-> System.out.println(s.toUpperCase()) );
//	    friends.forEach(name -> uc.add(name.toUpperCase()));

//	    uc = friends.stream()
//	        .map(name -> name.toUpperCase())
//	        .collect(Collectors.toList());

//	    Function<String,String> f = x -> (x.toUpperCase()); // String::toUpperCase
	    
//	    uc = friends.stream()
//        .map(f)
//        .parallel() // For parallel computation but not do it on immutable constructors
//        .collect(Collectors.toList());

	    
//	    BiFunction<Integer, Integer, Integer> add = (a,b) -> a + b;
//	    BiFunction<Integer, Integer, Double> addCast = (a,b) -> new Double(a + b);

	    // Filter all the ones that begin with the letter B
	    Optional<String> b = friends.stream()
	    		.filter(x -> x.toUpperCase().startsWith("z"))
	    		.findFirst();//collect(Collectors.toList());
	    
	    System.out.println(friends);
	    System.out.println(b.orElse("not present"));
	}
	 
}
