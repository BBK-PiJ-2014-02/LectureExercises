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
		MobilePhone myPhone = new SmartPhone();
		myPhone.browseWeb("Testing browseWeb()");
		myPhone.findPosition();
		testPhone((SmartPhone)myPhone);
	}

	/**
	 * testPhone();
	 */
	public void testPhone(SmartPhone p) {
		p.call("123");
		// Cannot call this as it is not set on Phone interface
		p.findPosition();
	}
}