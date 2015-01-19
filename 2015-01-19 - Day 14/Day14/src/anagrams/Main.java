package anagrams;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> words = AnagramUtil.getAnagram("te");
		for (int i = 0; i < words.size(); i++ ) {
			System.out.println("Word: "+words.get(i));
		}
        System.out.println("finished");
	}

}
