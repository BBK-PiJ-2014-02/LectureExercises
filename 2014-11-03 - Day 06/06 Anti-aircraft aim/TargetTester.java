/** Testing Target class methods **/

public class TargetTester {

    public static void main( String[] args ) {
        Target t = new Target(10);
        while(true) {
            t.init();
            System.out.println("Here they come! Try to bring the plane down!");
            while(true) {
                System.out.print("Enter a coordinate X: ");
                String str = System.console().readLine();
                int x = Integer.parseInt(str);
                System.out.print("Enter a coordinate Y: ");
                str = System.console().readLine();
                int y = Integer.parseInt(str);
                System.out.print("Enter a coordinate Z: ");
                str = System.console().readLine();
                int z = Integer.parseInt(str);
                Result r = t.fire(x,y,z);
                boolean end = false;
                switch (r) {
                    case HIT: { System.out.println("You hit it! Well done!"); end = true; break; }
                    case OUT_OF_RANGE: { System.out.println("That show is way out of range. Try harder!"); break; }
                    case FAIL_LEFT:    { System.out.println("You missed! The target is to the left!"); break; }
                    case FAIL_RIGHT:   { System.out.println("You missed! The target is to the right!"); break; }
                    case FAIL_HIGH:    { System.out.println("You missed! The target is higher!");  break; }
                    case FAIL_LOW:     { System.out.println("You missed! The target is lower!"); break; }
                    case FAIL_SHORT:   { System.out.println("You missed! The target is farther!"); break; }
                    case FAIL_LONG:    { System.out.println("You missed! The target is closer!"); break; }
					default: { break; }
				}
				if ( end ) {
					break;
                }
            }
		    System.out.print("Would you like to play again? y/n: " );
		    String str = System.console().readLine();
		    if ( str.equals("n") || str.equals("N") ) {
				break;
			}
	    }
	    System.out.println("Good bye!");
    }
}