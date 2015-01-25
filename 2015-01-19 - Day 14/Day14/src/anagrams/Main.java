package anagrams;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<String> words = AnagramUtil.getAnagram("testing th");
		for (int i = 0; i < words.size(); i++ ) {
			System.out.println("Word: "+words.get(i));
		}
        System.out.println("finished");
	}

}
