/** Day 7 - Exercise 3 - Singly-linked lists **/

public class HospitalManagement {
    private Patient firstPatient = null;

    // Add Patient p to the list
    public void addPatient(Patient p) {
		// If this is the first element
		if ( this.firstPatient == null ) {
			this.firstPatient = p;
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

    // Print the whole list
	public void printList() {
        Patient p = this.firstPatient;
		if ( p == null ) {
			System.out.println("List is empty!");
		}
		else {
            do{
    			p.print();
    			p = p.nextPatient();
    		} while (p != null);
		}
	}
}