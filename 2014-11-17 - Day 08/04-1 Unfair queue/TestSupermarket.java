/** Day 8 - Exercise 4.1 - Unfair queue **/

public class TestSupermarket {
	/**
	*  Main to test Supermarket class.
	*/
    public static void main( String[] args ) {
		Supermarket s = new Supermarket();
		Person r;
        s.addPerson(new Person("Me 1","Meme",45));
        s.addPerson(new Person("Me 2","Meme",23));
        s.addPerson(new Person("Me 3","Meme",67));
        s.addPerson(new Person("Me 4","Meme",32));
        s.addPerson(new Person("Me 5","Meme",78));
        s.addPerson(new Person("Me 6","Meme",21));
        s.addPerson(new Person("Me 7","Meme",98));
        s.addPerson(new Person("Me 8","Meme",32));
        s.print();
        r = s.servePerson();
        System.out.println("Retrieved person: "+r.toString());
        r = s.servePerson();
        System.out.println("Retrieved person: "+r.toString());
        s.print();
	}
}