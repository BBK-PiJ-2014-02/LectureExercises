/**
 * Implements Phone
 */
public class OldPhone implements Phone {
    /**
     * @param numbers to call
     */
    public void call(String number) {
	   System.out.println("Calling <"+number+">...");
   }
}