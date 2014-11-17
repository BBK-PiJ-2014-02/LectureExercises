/** Day 8 - Exercise 2 - Supermarket queue revisited **/

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
	*  Prints first and last name for person.
	*/
	void print();

}