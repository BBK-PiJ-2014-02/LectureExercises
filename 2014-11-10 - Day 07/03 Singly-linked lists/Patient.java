/** Day 7 - Exercise 3 - Singly-linked lists **/

public class Patient {
	private String name;
	private int age;
	private String illness;
	private Patient nextPatient;

    public Patient(String name, int age, String illness) {
	    this.name = name;
	    this.age = age;
	    this.illness = illness;
	}

	public Patient getNextPatient() {
		return this.nextPatient;
	}

	public void setNextPatient(Patient nextPatient) {
		this.nextPatient = nextPatient;
	}

	public void print() {
		System.out.println("Patient: " + name + ", age " + age + ", illness: " + illness);
	}
}