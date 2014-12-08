public class Node<T> {
    private Node<T> next;
    private T data;

    public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return this.data;
	}

	public void add(Node<T> node) {
		if ( this.next == null ) {
			this.next = node;
		}
		else {
			next.add(node);
		}
	}
}