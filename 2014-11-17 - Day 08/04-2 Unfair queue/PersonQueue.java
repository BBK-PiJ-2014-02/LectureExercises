/** Day 8 - Exercise 4.2 - Unfair queue - clustered **/

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
	*  Prints Person details
	**/
	void print();

}