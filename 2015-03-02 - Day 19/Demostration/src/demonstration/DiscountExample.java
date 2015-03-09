package demonstration;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Discount Example.
 * 
 * @author vdiasf01
 *
 */
public class DiscountExample {

	public static void main(String[] args) {
		final List<BigDecimal> prices = new LinkedList<BigDecimal>();
		prices.add(new BigDecimal("10"));
		prices.add(new BigDecimal("30"));
		prices.add(new BigDecimal("17"));
		prices.add(new BigDecimal("20"));
		prices.add(new BigDecimal("15"));
		prices.add(new BigDecimal("35"));
		
		// total of prices greater than Euro 20 discount by 10%
		
//		BigDecimal totalOfDiscountPrices = BigDecimal.ZERO;
//		
//		// a < b     a.compareTo()    -ve <, 0 =, +ve > 
//		
//		for(BigDecimal price : prices ) {
//			if ( price.compareTo(BigDecimal.valueOf(20)) > 0 ) 
//				totalOfDiscountPrices =
//				totalOfDiscountPrices.add(price.multiply(BigDecimal.valueOf(0.9)));
//			
//		}
//		
//		System.out.println("Total od discounted prices is: " + totalOfDiscountPrices);
		
		
		// Using Java H syntax
		final BigDecimal totalOfDiscountPrices = prices.stream()
				.filter(price -> price.compareTo(BigDecimal.valueOf(20)) > 0 )
				.map(price -> price.multiply(BigDecimal.valueOf(0.9)))
				.reduce(BigDecimal.ZERO, BigDecimal::add);

//		.reduce(BigDecimal.ZERO, BigDecimal::add);
//		totalOfDiscountPrices.add(price.multiply(BigDecimal.valueOf(0.9)));

		System.out.println("Total od discounted prices is: " + totalOfDiscountPrices);
		
	}
}
