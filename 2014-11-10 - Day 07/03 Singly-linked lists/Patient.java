/** Day 7 - Exercise 3 - Singly-linked lists **/

public class Patient {
	private String  name;
	private int     age;
	private String  illness;
	private Patient nextPatient;

    public Patient(String name, int age, String illness) {
	    this.name        = name;
	    this.age         = age;
	    this.illness     = illness;
	    this.nextPatient = null;
	}

    // Add a patient to the list
	public void addPatient(Patient patient) {
		// Nothing to add.
		if ( patient == null ) {
			return;
		}

        // End of the list, add this patient
		if ( this.nextPatient == null ) {
			this.nextPatient = patient;
		}
		// Not yet the end, keep searching
		else {
			this.nextPatient.addPatient(patient);
		}
	}

    // Delete a patient from the list by name
    public void deletePatient(String name) {
        // When next patient is the one we want to delete
		if ( this.nextPatient != null && this.nextPatient.getName().equals(name)) {
			this.nextPatient = this.nextPatient.nextPatient;

        // While we have not reached the end of the list
		} else if ( this.nextPatient != null ) {
			this.nextPatient.deletePatient(name);
		}
		// Not found => nothing deleted
	}

    // Method to access the private this next patient
    public Patient nextPatient() {
		return this.nextPatient;
	}

    // Mathod to get the patient's name for comparison when deleting
    public String getName() {
		return this.name;
	}

    // Print this Patient's info
	public void print() {
		System.out.println("Patient: " + name + ", age " + age + ", illness: " + illness);
	}
}