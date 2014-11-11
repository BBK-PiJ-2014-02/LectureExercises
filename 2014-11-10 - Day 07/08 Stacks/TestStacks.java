/** Day 7 - Exercise 8 - Stacks **/

public class TestStacks {
    public static void main( String[] args ) {
		System.out.println("==== Welcome to the Stack ===");
        // Initialize the stacks manager
		StacksManager sm = new StacksManager();
        StackElement se;

        // Push some elements of type StackElement into the stack
        System.out.println("Pushing 5...");
		sm.push(new StackElement("5"));
        System.out.println("Pushing 8...");
		sm.push(new StackElement("8"));
        System.out.println("Pushing 12...");
		sm.push(new StackElement("12"));

        // Pop the first element
        se = sm.pop();
        if ( se != null ) {
            System.out.println("Popping... it's a "+se.get());
		}

        System.out.println("Pushing 13...");
		sm.push(new StackElement("13"));

        // A few more checks until reaching the end of the stack
        se = sm.pop();
        while(se != null) {
			System.out.println("Popping... it's a "+se.get());
            se = sm.pop();
		}
		if ( sm.empty() ) {
			System.out.println("Stack is empty");
		}
		else {
            System.out.println("Stack is NOT empty");
		}
	}
}