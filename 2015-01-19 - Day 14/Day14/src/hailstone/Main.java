package hailstone;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		Hailstone h = new HailstoneImpl();
		ArrayList<Integer> r = h.getHailstone(121);
		for( int i = 0; i < r.size(); i++ ) {
			System.out.println(r.get(i));
		}
	}

}
