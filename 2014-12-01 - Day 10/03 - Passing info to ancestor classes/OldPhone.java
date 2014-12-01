/**
 * Implements Phone
 */
public class OldPhone implements Phone {
	/**
	 * Brand
	 */
	private String brand = null;

    /**
     * Constructor
     */
    public OldPhone(String brand) {
		this.brand = brand;
	}

    /**
     * getBrand
     * @return String brand
     */
    public String getBrand() {
		return brand;
	}

    /**
     * @param numbers to call
     */
    public void call(String number) {
	   System.out.println("Calling <"+number+">...");
   }
}