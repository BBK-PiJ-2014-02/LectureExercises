/** Day 8 - Exercise 1 - Supermarket queue **/

public class TestSupermarket {
	/**
	*  Main to test Supermarket class.
	*/
    public static void main( String[] args ) {
		Supermarket s = new Supermarket();
		Person r;
        s.addPerson(new Person("Me 1","Meme"));
        s.addPerson(new Person("Me 2","Meme"));
        s.addPerson(new Person("Me 3","Meme"));
        s.addPerson(new Person("Me 4","Meme"));
        s.addPerson(new Person("Me 5","Meme"));
        s.addPerson(new Person("Me 6","Meme"));
        s.addPerson(new Person("Me 7","Meme"));
        s.addPerson(new Person("Me 8","Meme"));
        s.print();
        r = s.servePerson();
        System.out.println("Retrieved person: "+r.toString());
        r = s.servePerson();
        System.out.println("Retrieved person: "+r.toString());
        s.print();
	}
}