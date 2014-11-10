/** Day 7 - Exercise 5 - Doubly-linked lists **/

public class HospitalManagement {
    private Patient firstPatient = null;

    // Add Patient p to the list
    public void addPatient(Patient p) {
		// If this is the first element
		if ( this.firstPatient == null ) {
			this.firstPatient = p;
			p.setPreviousPatient(null);
		}
		// When not first element
		else {
			this.firstPatient.addPatient(p);
		}
	}

    // Delete a Patient by name
	public void deletePatient(String name) {
		// When first element is the one we need to delete
		if ( this.firstPatient.getName().equals(name) ) {
			this.firstPatient = this.firstPatient.nextPatient();
		}
		// When next is not the one to delete yet
		else {
	    	this.firstPatient.deletePatient(name);
	    }
	}

    // Iteratively
    public int lengthI() {
		int length = 0;
		if ( this.firstPatient == null ) {
			return 0;
		}

		Patient p = this.firstPatient;
		do {
			length++;
			p = p.nextPatient();
		} while( p != null );

		return length;
	}

    // Recursive
    public int lengthR() {
		if ( this.firstPatient == null ) {
			return 0;
		}
		return this.lengthR(this.firstPatient);
	}

    public int lengthR(Patient p) {
		if ( p.nextPatient() == null ) {
			return 1;
		}
		else {
			return this.lengthR(p.nextPatient()) + 1;
		}
	}


    // Print the whole list - forwards and then backwards
	public void printList() {
        Patient p = this.firstPatient;
        Patient lastP = null;
		if ( p == null ) {
			System.out.println("List is empty!");
		}
		else {
            do{
    			p.print();
    			lastP = p;
    			p = p.nextPatient();
    		} while (p != null);
		}

		if ( lastP == null ) {
			System.out.println("Last element is null!");
		}
		else {
			do{
				lastP.print();
				lastP = lastP.previousPatient();
			} while (lastP != null);
		}
	}

}