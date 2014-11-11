/** Day 7 - Exercise 7 - Queues **/

public class TestQueue {
    public static void main( String[] args ) {
		System.out.println("==== Welcome to the Queue System ===");
        // Initialize the queue manager
		QueueManager qm = new QueueManager();
        QueueElement qe;

        // Check the queue size
        System.out.println("There are "+qm.size()+" requests in the queue.");

        // Insert some elements of type QueueElement into the queue
        System.out.println("Inserting request 5...");
		qm.insert(new QueueElement("5"));
        System.out.println("Inserting request 8...");
		qm.insert(new QueueElement("8"));
        System.out.println("Inserting request 12...");
		qm.insert(new QueueElement("12"));

        // Check the queue size
        System.out.println("There are "+qm.size()+" requests in the queue.");

        // Retrieving the first element, and inserting a new one
        qe = qm.retrieve();
        if ( qe != null ) {
            System.out.println("Retrieving request "+qe.get()+"... done");
		}
        System.out.println("Inserting request 13...");
		qm.insert(new QueueElement("13"));

        // A few more checks until reaching the end of the queue
        System.out.println("There are "+qm.size()+" requests in the queue.");
        qe = qm.retrieve();
        while(qe != null) {
			System.out.println("Retrieving request "+qe.get()+"... done");
            System.out.println("There are "+qm.size()+" requests in the queue.");
            qe = qm.retrieve();
		}
        System.out.println("There are "+qm.size()+" requests in the queue.");
    }
}