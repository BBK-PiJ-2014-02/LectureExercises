/**
 * PhoneLauncher to test the other classes
 */
public class PhoneLauncher {
	/**
	 * Main function
	 * @param args String array
	 */
	public static void main(String[] args) {
		PhoneLauncher launcher = new PhoneLauncher();
		launcher.launch();
	}

    /**
     * launch the SmartPhone class
     */
	public void launch() {
		SmartPhone myPhone = new SmartPhone();
		myPhone.browseWeb("Testing browseWeb()");
		myPhone.findPosition();
	}
}