/** Day 7 - Exercise 7 - Queues **/

public class QueueManager {

    private QueueElement first;
    private int size = 0;

    // Constructor
    public QueueManager() {
		this.first = null;
	}

    // insert element at the start of the queue
    public void insert(QueueElement qe) {
		// Nothing given, return
		if ( qe == null ) {
			return;
		}

        // This is the first insert
		if ( this.first == null ) {
			this.first = qe;
			this.size++;
		}
		// Set qe to be first element and the first to be after qe
		else {
			qe.setNext(this.first);
			this.first = qe;
			this.size++;
	    }
	}

    // retrieve the last element of the queue
	public QueueElement retrieve() {
		if ( this.first == null || this.size == 0 ) {
			return null;
		}

		// When only one element
		if ( this.size == 1 ) {
            QueueElement qe = this.first;
            this.first = null;
            this.size--;
            return qe;
		}
		// When more than one
		else {
			QueueElement tmp = this.first;
			for( int i = 0; i < this.size; i++ ) {
				if ( tmp.getNext() != null && tmp.getNext().getNext() != null ) {
					tmp = tmp.getNext();
					continue;
				}
				else {
					QueueElement r = tmp.getNext();
					tmp.setNext(null);
					this.size--;
					return r;
				}
			}
			return null;
		}
	}

	public int size() {
		return this.size;
	}
}