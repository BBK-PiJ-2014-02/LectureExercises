/** Day 7 - Exercise 7 - Queues **/

public class QueueElement {

    private String element;
    private QueueElement next = null;

    public QueueElement(String element) {
		this.element = element;
	}

	public void set(String element) {
		this.element = element;
	}

	public String get() {
		return this.element;
	}

	public QueueElement getNext() {
		return this.next;
	}

	public void setNext(QueueElement next) {
		this.next = next;
	}
}