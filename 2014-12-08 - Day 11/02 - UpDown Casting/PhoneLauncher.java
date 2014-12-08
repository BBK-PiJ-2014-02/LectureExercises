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
		SmartPhone sp = new SmartPhone();
		sp.findPosition();
		sp.browseWeb("some website");
		sp.playGame("playing game");
		sp.ringAlarm("ring alarm");
		sp.call("1");
		sp.call("2");
		sp.call("3");
		sp.call("4");
		sp.call("5");
		sp.call("6");
		sp.call("7");
		sp.call("8");
		sp.call("9");
		sp.call("10");
		sp.call("11");
		sp.call("12");
		sp.printLastNumbers();
	}
}