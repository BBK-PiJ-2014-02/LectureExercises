/** Day 7 - Exercise 7 - Queues **/

public class TestQueue {
    public static void main( String[] args ) {
		System.out.println("==== Welcome to the Queue System ===");
		QueueManager qm = new QueueManager();
		String str;

		str = "This is a test 0";
		QueueElement e0 = new QueueElement(str);
		qm.insert(e0);
		str = "This is a test 1";
		QueueElement e1 = new QueueElement(str);
		qm.insert(e1);
		str = "This is a test 2";
		QueueElement e2 = new QueueElement(str);
		qm.insert(e2);
		str = "This is a test 3";
		QueueElement e3 = new QueueElement(str);
		qm.insert(e3);
		str = "This is a test 4";
		QueueElement e4 = new QueueElement(str);
		qm.insert(e4);
		str = "This is a test 5";
        QueueElement e5 = new QueueElement(str);
		qm.insert(e5);
		str = "This is a test 6";
		QueueElement e6 = new QueueElement(str);
		qm.insert(e6);
		str = "This is a test 7";
		QueueElement e7 = new QueueElement(str);
		qm.insert(e7);
		str = "This is a test 8";
		QueueElement e8 = new QueueElement(str);
		qm.insert(e8);
		str = "This is a test 9";
		QueueElement e9 = new QueueElement(str);
		qm.insert(e9);

		System.out.println(qm.retrieve());
		System.out.println(qm.retrieve());
		System.out.println(qm.retrieve());
		System.out.println(qm.retrieve());
		System.out.println(qm.retrieve());
		System.out.println(qm.retrieve());
		System.out.println(qm.retrieve());
		System.out.println(qm.retrieve());
		System.out.println(qm.retrieve());
		QueueElement qqq = qm.retrieve();

		System.out.println(qqq.get());
    }
}