/** Day 8 - Exercise 4.2 - Unfair queue - clustered **/

public class TestSupermarket {
	/**
	*  Main to test Supermarket class.
	*/
    public static void main( String[] args ) {
		Supermarket s = new Supermarket();
		Person r;
        s.addPerson(new Person("Me 1","Meme",5));
        s.addPerson(new Person("Me 2","Meme",23));
        s.addPerson(new Person("Me 3","Meme",7));
        s.addPerson(new Person("Me 4","Meme",32));
        s.addPerson(new Person("Me 5","Meme",18));
        s.addPerson(new Person("Me 6","Meme",1));
        s.addPerson(new Person("Me 7","Meme",98));
        s.addPerson(new Person("Me 8","Meme",32));
        s.print();
        r = s.servePerson();
        System.out.println("Retrieved person: "+r.toString());
        r = s.servePerson();
        System.out.println("Retrieved person: "+r.toString());
        r = s.servePerson();
        System.out.println("Retrieved person: "+r.toString());
        r = s.servePerson();
        System.out.println("Retrieved person: "+r.toString());
        r = s.servePerson();
        System.out.println("Retrieved person: "+r.toString());
        s.print();
        r = s.servePerson();
        System.out.println("Retrieved person: "+r.toString());
        s.print();
	}
}