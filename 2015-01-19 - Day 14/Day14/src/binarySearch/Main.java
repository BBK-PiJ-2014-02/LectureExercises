package binarySearch;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		Integer numberToTestWith = 0;
		ArrayList<Integer> ali = new ArrayList<Integer>();
		for( int i = 0; i < 1000; i++ ) {
			ali.add(i);
		}
		
		System.out.println(numberToTestWith+" is in this arrayList? " + BinarySearch.isIn(ali, numberToTestWith));

	}

}
