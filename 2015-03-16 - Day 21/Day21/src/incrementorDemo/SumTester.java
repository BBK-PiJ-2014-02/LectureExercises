package incrementorDemo;

import java.util.Random;

public class SumTester {
	static Random rand = new Random();
	
	public static void main(String[] args) {
		int[] array = new int[100000];
		for( int i = 0; i < array.length; i += 1) {
			array[i] = rand.nextInt();
		}
		long sum = Sum.sumArray(array);
		System.out.println(sum);
	}

}
