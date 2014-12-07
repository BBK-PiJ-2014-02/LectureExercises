public class NoahsArk {
    public static void main(String[] args) {
		Animal[] a = new Animal[16];
		a[0] = new Bear();
		a[1] = new Beetle();
		a[2] = new Cat();
		a[3] = new Crocodile();
		a[4] = new Dog();
		a[5] = new Dolphin();
		a[6] = new Eagle();
		a[7] = new Fly();
		a[8] = new Frog();
		a[9] = new Lizard();
		a[10] = new Monkey();
		a[11] = new Pigeon();
		a[12] = new Salmon();
		a[13] = new Shark();
		a[14] = new Snake();
		a[15] = new Whale();
        for( int i = 0; i < a.length; i++ ) {
			System.out.println();
			a[i].call();
		    a[i].makeSound();
			a[i].reproduce();
		}
    }
}