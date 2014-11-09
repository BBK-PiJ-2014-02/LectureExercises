/** Day 7 - Exercise 2 - do-while **/

public class TestDoWhile {
    public static void main( String[] args ) {
		System.out.println("==== Welcome to the do-while marks calculator ===");
		DoWhile marks = new DoWhile();
		int mark;
		do {
			System.out.print("Input a mark: ");
			String input = System.console().readLine();
			mark = Integer.parseInt(input);
		} while (marks.add(mark));
		marks.print();
    }
}