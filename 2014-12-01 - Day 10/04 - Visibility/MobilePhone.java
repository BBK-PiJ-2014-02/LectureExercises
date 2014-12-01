/**
 * MobilePhone extends OldPhone
 */
public class MobilePhone extends OldPhone {
	/**
	 * Storing last ten numbers
	 */
	private String[] lastNumbers = new String[10];

    /**
     * Constructor
     */
    public MobilePhone(String brand) {
		super(brand);
	}

    /**
     * PlayGame
     * @param name String
     */
	private void playGame(String name) {
		System.out.println("Playing game " + name);
	}

    /**
     * ringAlarm
     * @param alarm String
     */
	public void ringAlarm(String alarm) {
		System.out.println("Alarm!");
	}

    /**
     * printLastNumbers
     */
	public void printLastNumbers() {
		for( int i = 0; i < lastNumbers.length; i++ ) {
			System.out.println(i+ " : " + lastNumbers[i]);
		}
	}

    /**
     * call
     * @param number String
     */
    @Override
    public void call( String number ) {
		super.call(number);
        add(number);
	}

    /**
     * add
     * @param number adds number to memory
     */
	public void add(String number) {
		if ( number != null ) {
			// Move numbers down
			for ( int i = lastNumbers.length - 1; i > 0; i-- ) {
				lastNumbers[i] = lastNumbers[i-1];
			}
			lastNumbers[0] = number;
		}
	}

}