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
    	// Synchronised to avoid adding more money while the
    	// retrieve(money) is running.
    	balance += money;
    }
    
    /**
     * Withdrawing money from the customer's account.
     * 
     * @param money to be withdrawn
     * @return int money withdrawn
     */
    public synchronized int retrieve( int money ) {
    	// Synchronised with the deposit(money)
    	// to avoid retrieving money being added at the
    	// middle of retrieving.
    	int result = 0;
    	
    	if ( balance > money ) {
    		result = money;
    	}
    	else {
    		result = balance;
    	}
    	
		// Checking the odd cases:
    	// e.g.: result = 10; from the else{} above
    	//       Then deposit(10) happens, making balance be 20
    	//       balance = 20 - 10 = 10; => OK
    	// 
    	// e.g.: result = 10; from the if() where balance = 11 and money = 10
    	//       Then deposit(10) happens, making balance = 21
    	//       balance = 21 - 10 = 11; => OK
    	// 
    	// Consecutive retrieve(10)
    	// e.g.: result = 10; from the else{} above
    	//       Then retrieve(10) happens, making balance be 0
    	//       balance = 0 - 10 = -10; => NOT OK
    	// 
    	// e.g.: result = 10; from the if() where balance = 11 and money = 10
    	//       Then retrieve(10) happens, making balance = 1
    	//       balance = 1 - 10 = -9; => NOT OK
    	
       	balance = balance - result;
    	    	
    	return result;
    }
}
