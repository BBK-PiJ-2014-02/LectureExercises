public class RestrictedSmartPhone extends SmartPhone {
	/**
	 * Constructor
	 */
	public RestrictedSmartPhone(String brand) {
		super(brand);
	}

	/**
	 * Overriding playGame
	 */
	@Override
	public void playGame(String name) {
		// Not allowed to be used
	}
}