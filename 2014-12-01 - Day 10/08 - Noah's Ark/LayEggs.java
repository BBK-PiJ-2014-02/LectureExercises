public class LayEggs extends AnimalImpl {
	/**
	 * Animal's name
	 */
	private final String animal;

    /**
     * Constructor
     */
    public LayEggs(String animal, String sound, boolean canFly, boolean canSwim) {
        super(animal, sound, canFly, canSwim);
        this.animal = animal;
    }

    /**
     * Tailored specific lay-eggs attributes
     */
    @Override
    public void reproduce() {
	    System.out.println(animal + " is laying an egg...");
    }
}