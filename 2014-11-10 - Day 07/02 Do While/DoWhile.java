/** Day 7 - Exercise 2 - do-while **/

public class DoWhile {
    private int totalMarks;
    private int distinctions;
    private int passes;
    private int failed;
    private int invalid;


    // Constructor
    public void DoWhile() {
		this.totalMarks   = 0;
		this.distinctions = 0;
		this.passes       = 0;
		this.failed       = 0;
		this.invalid      = 0;
	}

	public boolean add(int mark) {
		if( mark == -1 ) {
			return false;
		}

		if ( mark < 50 ) {
			this.failed++;

		} else if ( mark < 70 ) {
			this.passes++;

		} else if ( mark <= 100 ) {
			this.distinctions++;

		} else {
			this.invalid++;
		}

        if ( mark >= 0 && mark <= 100 ) {
			this.totalMarks++;
		}

		return true;
	}

	public void print() {
		System.out.print("There are "+totalMarks+" students: ");
		System.out.print(  this.distinctions+" distinctions");
		System.out.print(", "+this.passes+" pass");
		System.out.print(", "+this.failed+" fails");
		if ( this.invalid > 0 ) {
			System.out.print(" (plus "+this.invalid+" invalid).");
		}
		else {
			System.out.print(".");
		}
	}


}