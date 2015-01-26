package patient;

import java.util.Calendar;

/**
 * Day 15 - More patients exercise.
 * 
 * Patient class.
 * 
 * @author vdiasf01
 *
 */
public class Patient {

	/**
	 * Patient's name.
	 */
	private String name;
	
	/**
	 * Patient's age.
	 */
	private int age;
	
	/**
	 * Patient's constructor
	 */
	public Patient(String name, int year) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int givenAge = currentYear - year;

		if ( givenAge < 0 || givenAge > 130 ) {
			throw new IllegalArgumentException();
		}
        
        this.name = name;
        this.age  = givenAge;
	}
	
	/**
	 * Retrieve Patient's name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Retrieve Patient's age
	 */
	public int getAge() {
		return this.age;
	}
}
