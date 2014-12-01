/**
 * MobilePhone extends OldPhone
 */
public class MobilePhone extends OldPhone {
	private String[] lastNumbers = new String[10];
	private Phone p = new OldPhone();

	public void playGame(String name) {
		System.out.println("Playing game " + name);
	}

	public void ringAlarm(String alarm) {
		System.out.println("Alarm!");
	}

	public void printLastNumbers() {
		for( int i = 0; i < lastNumbers.length; i++ ) {
			System.out.println(i+ " : " + lastNumbers[i]);
		}
	}

    @Override
    public void call( String number ) {
		p.call(number);
        add(number);
	}

	private void add(String number) {
		if ( number != null ) {
			// Move numbers down
			for ( int i = lastNumbers.length - 1; i > 0; i-- ) {
				lastNumbers[i] = lastNumbers[i-1];
			}
			lastNumbers[0] = number;
		}
	}

}