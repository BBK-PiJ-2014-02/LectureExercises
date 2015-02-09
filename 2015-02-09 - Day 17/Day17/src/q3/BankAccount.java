package q3;
/**
 * Question 3 - Bank Account
 * 
 * @author vdiasf01
 *
 */
public class BankAccount {
	/**
	 * The customer's balance.
	 */
    private int balance = 0;
    
    /**
     * Getting the customer's current balance.
     * 
     * @return
     */
    public int getBalance() {
    	return balance;
    }
    
    /**
     * Deposit money into customer's account.
     * 
     * @param money
     */
    public synchronized void deposit( int money ) {
    	// Synchronised to avoid multiple deposits 
    	// of the same value from different threads.
    	balance += money;
    }
    
    /**
     * Withdrawing money from the customer's account.
     * 
     * @param money to be withdrawn
     * @return int money withdrawn
     */
    public synchronized int retrieve( int money ) {
    	// Synchronised to avoid multiple retrieves 
    	// of the same value from different threads.
    	int result = 0;
    	
    	if ( balance > money ) {
    		result = money;
    	}
    	else {
    		result = balance;
    	}
    	
    	balance = balance - result;
    	
    	return result;
    }
}
