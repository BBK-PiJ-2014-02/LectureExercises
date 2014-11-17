/** Day 8 - Exercise 1 - Supermarket queue **/

public class Supermarket {

	/**
	*  Person Queue
	*/
    private PersonQueueImpl pq;

    /**
    *  Constructor
    */
    public Supermarket() {
		this.pq = new PersonQueueImpl();
	}

    /**
    *  Add Person to queue
    */
    public void addPerson(Person p) {
        pq.insert(p);
	}

    /**
    *  Serve a person and returns it out of queue.
    */
	public Person servePerson() {
        return pq.retrieve();
	}

	/**
	*  Print the whole stack
	*/
	public void print() {
		if ( pq != null ) {
			pq.print();
		}
		else {
			System.out.println("There is no one next!");
		}
	}
}