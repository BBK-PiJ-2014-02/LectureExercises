public class GiveBirth extends AnimalImpl {
	/**
	 * Animal's name
	 */
	private final String animal;

    /**
     * Constructor
     */
    public GiveBirth(String animal, String sound, boolean canFly, boolean canSwim) {
        super(animal, sound, canFly, canSwim);
        this.animal = animal;
    }

    /**
     * Tailored specific give-birth attributes
     */
    @Override
    public void reproduce() {
	    System.out.println(animal + " is giving birth...");
    }
}