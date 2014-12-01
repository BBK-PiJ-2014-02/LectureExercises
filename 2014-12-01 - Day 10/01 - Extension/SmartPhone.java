/**
 * SmartPhone, extends MobilePhone
 */
public class SmartPhone extends MobilePhone {
    public void browseWeb(String str) {
		System.out.println("Browsing web: " + str);
	}

    public String findPosition() {
		System.out.println("Searching position");
		return "1234242";
	}
}