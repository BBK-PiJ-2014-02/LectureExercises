package question3;

public class Person {
	/**
	 * Return the given full name initials.
	 * 
	 * @param fullName the person's full name
	 * @return result
	 */
	public String getInitials(String fullName) {
        // If fullName is null, return empty string to avoid exceptions.
		if ( fullName == null ) {
			return "";
		}
		
		String result = "";
		String[] words = fullName.split(" ");

		for (int i = 0; i < words.length; i++) {
			// Double spaces would have returned an empty word
			if ( words[i].length() > 0 ) {
				String nextInitial = "" + words[i].charAt(0);
				result = result + nextInitial.toUpperCase();
			}
		}

		return result;
	}
}
