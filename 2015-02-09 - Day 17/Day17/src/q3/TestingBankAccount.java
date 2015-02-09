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
        bankAccount.deposit(20);
        for(int i = 0; i < 20; i++ ) {
        	TestingBankAccount tba = new TestingBankAccount(bankAccount);
        	Thread            bank = new Thread(tba);
        	bank.start();
        }
	}

	/**
	 * Runnable.
	 */
	@Override
	public void run() {
		System.out.println("Starting a new thread. Current balance: " + bankAccount.getBalance());
		for( int i = 0; i < 10; i++ ) {
			bankAccount.retrieve(1);
			System.out.println("    running " + i + " deposited: " + bankAccount.getBalance());
		}
		System.out.println("Stopping this thread. Current balance: " + bankAccount.getBalance());
	}
}