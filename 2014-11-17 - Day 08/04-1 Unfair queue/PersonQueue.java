/** Day 8 - Exercise 4.1 - Unfair queue **/

public interface PersonQueue {

	/**
	*  Adds another person to the queue.
	*/
	void insert(Person person);

	/**
	*  Removes a person from the queue.
	*/
	Person retrieve();

	/**
	*  Prints first and last name of Person plus age.
	*/
	void print();

}