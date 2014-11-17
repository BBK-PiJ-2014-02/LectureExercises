/** Day 8 - Exercise 4.2 - Unfair queue - clustered **/

/**
*  Changed method insert to work out iteratively and find the
*  last person and add the give one to the last
*/
public class PersonQueueImpl implements PersonQueue {

    /**
    *  First point to person in queue
    */
	private Person first;

	/**
	*  Adds another person to the queue.
	*/
	public void insert(Person person) {
		if ( person == null ) {
			return;
		}

		if ( this.first == null ) {
			this.first = person;
		}
		else {
			this.first.add(person);
		}
	}

	/**
	*  Removes a person from the queue,
	*  but gives priority to the elderly over 65.
	*  If not elderly over 65 found, a person over 18,
	*  otherwise, resumes to normal.
	*/
	public Person retrieve() {
		if ( this.first == null ) {
			return null;
		}
		else {
			// Find the oldest person in queue
			int oldest = getOldestInQueue();

            // Return eldest first
            if ( oldest >= 18 ) {
    	        Person pPerson = this.first;
    		    do {
			        if ( oldest < pPerson.getAge() ) {
			            oldest = pPerson.getAge();
			        }
			        pPerson = pPerson.getNext();
			    } while ( pPerson != null );

                // First person to match found age, is retrieved.
                // NOTE: we need to point previous person to the new next.
                pPerson = this.first;
                if ( this.first.getAge() == oldest ) {
			        this.first = pPerson.getNext();
			        return pPerson;
                }
                while ( pPerson.getNext() != null && pPerson.getNext().getAge() != oldest ) {
                    pPerson = pPerson.getNext();
                }

                // pPerson.getNext() is the person to retrieve.
                Person oldestPerson = pPerson.getNext();
                pPerson.setNext(oldestPerson.getNext());
                return oldestPerson;
            }
            // Apply the normal retrieve
            else {
				Person pPerson = this.first;
				this.first = this.first.getNext();
				return pPerson;
			}
        }
	}

	private int getOldestInQueue() {
        int oldest = 0;
        // Find the oldest person in queue
        Person pPerson = this.first;
        do {
            if ( oldest < pPerson.getAge() ) {
                oldest = pPerson.getAge();
            }
            pPerson = pPerson.getNext();
        } while ( pPerson != null );

        return oldest;
	}

	/**
	*  Print the whole stack
	*/
	public void print() {
		if ( this.first == null ) {
			System.out.println("No one in queue");
		}
		else {
		    Person p = this.first;
		    do {
				if ( p != null ) {
                    System.out.println("Person in queue: "+p.getLastName()+","+p.getFirstName()+" age: "+p.getAge());
				}
				p = p.getNext();
			} while ( p != null );
		}
	}
}