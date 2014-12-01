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
		SmartPhone sp = new RestrictedSmartPhone("Some brand");
		sp.findPosition();
		sp.browseWeb("some website");
		sp.playGame("playing game");
		sp.ringAlarm("ring alarm");
		sp.call("001");
		sp.call("002");
		sp.call("003");
		sp.call("04");
		sp.call("005");
		sp.call("06");
		sp.call("007");
		sp.call("008");
		sp.call("009");
		sp.call("0010");
		sp.call("0011");
		sp.call("0012");
		sp.printLastNumbers();
		System.out.println(sp.getBrand());

	}
}