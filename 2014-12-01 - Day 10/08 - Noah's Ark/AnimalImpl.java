public class AnimalImpl implements Animal {
	/**
	 * Animal name
	 */
	private String animal;

	/**
	 * Animal sound
	 */
	private String sound;

	/**
	 * Flying flag
	 */
	private final boolean canFly;

	/**
	 * Water flag
	 */
	private final boolean canSwim;

    /**
     * Constructor
     */
    public AnimalImpl(String animal, String sound, boolean canFly, boolean canSwim) {
	   this.animal = animal;
	   this.sound  = sound;
	   this.canFly = canFly;
	   this.canSwim = canSwim;
	}

    /**
     * Calling the animal to the Ark
     */
    public void call() {
		String text = animal;

		if ( canFly ) {
		    text = animal + " now flying, will come later.";

		} else if ( canSwim ) {
			text = animal + " will not come.";

		} else {
			text += " comming...";
		}

		System.out.println(text);
	}

    /**
     * The animal making a sound
     */
    public void makeSound() {
		System.out.println(animal + " " + sound + "...");
	}

    /**
     * Requesting the animal to reproduce
     */
    public void reproduce() {
		System.out.println(animal + " is reproducing...");
	}


}
