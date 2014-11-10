/** Day 7 - Exercise 6 - Circular lists **/

public class Patient {
	private String  name;
	private int     age;
	private String  illness;
	private Patient nextPatient;
	private boolean firstPatient = false;

    public Patient(String name, int age, String illness) {
	    this.name        = name;
	    this.age         = age;
	    this.illness     = illness;
	}

    // Set the first node to true or false
	public void setFirstPatient(boolean first) {
		this.firstPatient = first;
	}

    // Returns true if first node is set
	public boolean isFirstPatient() {
		return this.firstPatient;
	}

    // Add a patient to the list
	public void addPatient(Patient patient) {
		// Nothing to add.
		if ( patient == null ) {
			return;
		}

        // If next patient is the first patient, add this patient between this and next
		if ( this.nextPatient != null && this.nextPatient.isFirstPatient() ) {
			patient.setNextPatient(this.nextPatient.nextPatient());
			this.nextPatient = patient;

		}
		// Not yet the end, keep searching
		else {
			this.nextPatient.addPatient(patient);
		}
	}

    // Delete a patient from the list by name
    public void deletePatient(String name) {
        // When next patient is the one we want to delete (don't check first element again)
		if ( ! this.nextPatient.isFirstPatient() && this.nextPatient.getName().equals(name)) {
			this.nextPatient = this.nextPatient.nextPatient;

        // While we have not reached the end of the list
		} else if ( ! this.nextPatient.isFirstPatient() ) {
			this.nextPatient.deletePatient(name);
		}
		// Not found => nothing deleted
	}

    // Method to access the private this next patient
    public Patient nextPatient() {
		return this.nextPatient;
	}

    // Method to access the private this next patient
    public void setNextPatient(Patient p) {
		this.nextPatient = p;
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