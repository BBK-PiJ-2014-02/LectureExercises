/** Day 8 - Exercise 1 - Supermarket queue **/

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
	* Prints first and last names
	*/
	void print();
}