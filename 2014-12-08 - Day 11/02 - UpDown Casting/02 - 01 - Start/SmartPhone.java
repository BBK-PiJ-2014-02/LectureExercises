/**
 * SmartPhone, extends MobilePhone
 */
public class SmartPhone extends MobilePhone {
	/**
	 * browseWeb
	 * @param str to browse the web.
	 */
    public void browseWeb(String str) {
		System.out.println("Browsing web: " + str);
	}

    /**
     * findPosition returning GPS coordinates.
     */
    public String findPosition() {
		System.out.println("Searching position");
		return "1234242";
	}
}