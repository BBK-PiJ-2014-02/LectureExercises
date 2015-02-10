package q3;
/**
 * Testing the BankAccount with multiple threads
 * 
 * @author vdiasf01
 *
 */
public class TestingBankAccount implements Runnable {
	/**
	 * Customer's bank account.
	 */
	private BankAccount bankAccount;
	
	/**
	 * Constructor.
	 * 
	 * @param bankAccount
	 */
	public TestingBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	/**
	 * Main.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		BankAccount bankAccount = new BankAccount();

		// Deposit needs to be high enough to cover the worst case scenario
		// when all 200 threads retrieve 100 times 1 pound each, levelling
		// the balance to zero.
		bankAccount.deposit(20000);
        
        for( int i = 0; i < 200; i++ ) {
        	TestingBankAccount tba = new TestingBankAccount(bankAccount);
        	Thread            bank = new Thread(tba);
        	bank.start();
        }
        
        try {
			Thread.sleep(2000);
        } catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        System.out.println("Final balance: " + bankAccount.getBalance());
		
	}

	/**
	 * Runnable.
	 */
	@Override
	public void run() {
		for( int i = 0; i < 100; i++ ) {
			bankAccount.retrieve(1);
		}
		for( int i = 0; i < 100; i++ ) {
			bankAccount.deposit(1);
		}
	}
}