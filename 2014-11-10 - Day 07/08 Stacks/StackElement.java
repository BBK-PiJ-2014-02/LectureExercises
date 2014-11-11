/** Day 7 - Exercise 8 - Stacks **/

public class StackElement {

    private String element;
    private StackElement next = null;

    public StackElement(String element) {
		this.element = element;
	}

	public void set(String element) {
		this.element = element;
	}

	public String get() {
		return this.element;
	}

	public StackElement getNext() {
		return this.next;
	}

	public void setNext(StackElement next) {
		this.next = next;
	}
}