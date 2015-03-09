package demonstration;

import java.util.Arrays;
import java.util.List;

/**
 * Consumer accept().
 * 
 * @author vdiasf01
 *
 */
public class Friends {
	public static void main(String[] args) {
		final List<String> friends = Arrays.asList("John","Kevin","Albert","Betty","Joan","Vera","Isobel","Mickey");
		
//		for ( String s: friends ){
//			System.out.println(s);
//		}
		
//		friends.forEach(new Consumer<Object>() {
//			@Override
//			public void accept(Object o) {
//				System.out.println(o);
//			}
//		});
		
		//               HEAD     NECK   BODY  ( Lambda -> function )
		friends.forEach((String s) -> System.out.println(s));

		// Simplified version with using method references
		friends.forEach(System.out::println);

	}

}
