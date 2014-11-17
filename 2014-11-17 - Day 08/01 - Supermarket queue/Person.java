/** Day 8 - Exercise 1 - Supermarket queue **/

public class Person {

    /**
    *  Person's first name
    */
    private String firstName;

    /**
	*  Person's last name
	*/
	private String lastName;

    /**
	*  Pointer to the next Person.
	*/
	private Person next;


    /**
    *  Constructor
    */
    public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName  = lastName;
	}


    /**
    *  Get the Person's first name.
    */
	public String getFirstName() {
		return this.firstName;
	}

    /**
    *  Get the Person's last name.
    */
	public String getLastName() {
		return this.lastName;
	}

    /**
    *  Set the Person's first name.
    */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

    /**
    *  Set the Person's last name.
    */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	*  Set Person to easier add all elements of Person
	*/
	public void setPerson(Person p) {
		this.firstName = p.getFirstName();
		this.lastName  = p.getLastName();
	}


    /**
    *  Get next Person
    */
    public Person getNext() {
		return this.next;
	}

    /**
    *  Set next Person with Person p
    */
    public void setNext(Person p) {
		this.next = p;
	}

	/**
	*  Adds person to the end of the list
	*/
	public void add(Person p) {
		if ( this.next == null ) {
			this.next = p;
		}
		else {
			this.next.add(p);
		}
	}

	/**
	*  Basic print of name
	*/
	public String toString() {
		return ""+this.lastName+", "+this.firstName;
	}
}