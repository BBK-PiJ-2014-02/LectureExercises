public class ExtendString extends String {
	private String str;

    public ExtendString(String str) {
		this.str = str;
	}

	public String printEven() {
		String tmp = "";
		for( int i = 0; i < str.length(); i++ ) {
			if ( i%2 == 0 ) {
                tmp += ""+str.charAt(i);
			}
		}
		return tmp;
	}
}