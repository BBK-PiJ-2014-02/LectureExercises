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
        bankAccount.deposit(200);
        for(int i = 0; i < 200; i++ ) {
        	TestingBankAccount tba = new TestingBankAccount(bankAccount);
        	Thread            bank = new Thread(tba);
        	bank.start();
        }
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Final balance: " + bankAccount.getBalance());
		
	}

	/**
	 * Runnable.
	 */
	@Override
	public void run() {
//		System.out.println("Starting a new thread. Current balance: " + bankAccount.getBalance());
		for( int i = 0; i < 100; i++ ) {
			bankAccount.retrieve(1);
//			System.out.println("    running " + i + " balance: " + bankAccount.getBalance());
		}
//		System.out.println("Stopping this thread. Current balance: " + bankAccount.getBalance());
		for( int i = 0; i < 100; i++ ) {
			bankAccount.deposit(1);
//			System.out.println("    running " + i + " balance: " + bankAccount.getBalance());
		}
//		System.out.println("Stopping this thread. Current balance: " + bankAccount.getBalance());
	}
}