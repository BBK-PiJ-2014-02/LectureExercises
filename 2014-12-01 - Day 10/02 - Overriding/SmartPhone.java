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

	/**
	 * Overriding call to return more info for interantional calls
	 * @param number String number to call
	 */
	@Override
	public void call(String number) {
		if( number != null && number.length() > 2 && number.charAt(0) == '0' && number.charAt(1) == '0' ) {
			super.add(number);
			System.out.println("Calling <"+number+"> through the internet to save money");
		}
		else {
			super.call(number);
		}
	}
}