/** Day 8 - Exercise 5.1 - Hash function **/

public class HashUtilities {
    public static int shortHash(int i) {
		return Math.abs(i%1000);
	}
}