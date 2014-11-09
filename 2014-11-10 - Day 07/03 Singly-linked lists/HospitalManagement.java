/** Day 7 - Exercise 3 - Singly-linked lists **/

public class HospitalManagement {
    private Patient firstPatient;
    private Patient pointer;

	public void addPatient( Patient patient ) {
		if ( this.firstPatient != null ) {
			if ( pointer.getNextPatient() != null ) {
			patient.print();
				addPatient(pointer.getNextPatient());
			}
			else {
				patient.setNextPatient(patient);
			}
		}
		else {
			this.firstPatient = patient;
			this.pointer = this.firstPatient;
		}
	}

	public void remove( Patient patient ) {

	}

    public Patient getNext(Patient previousPatient) {
		return previousPatient.getNextPatient();
	}

	public void printList() {
        Patient p = this.firstPatient;
		if ( p == null ) {
			System.out.println("List is empty!");
		}
		else {
            do{
    			p.print();
    			p = p.getNextPatient();
    		} while (p != null);
		}
	}


}