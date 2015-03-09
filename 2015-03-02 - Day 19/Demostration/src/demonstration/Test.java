package demonstration;
/**
 * Lambdas?
 * @author vdiasf01
 *
 */
public class Test {
	public static void main(String[] args) {
		Person ta = new TAIml();
		System.out.println(ta.getName());
	}
	
}

/**
 * 
 * @author vdiasf01
 *
 */
interface Person {
    public default String getName() {
    	return "name";
    };
}

/**
 * 
 * @author vdiasf01
 *
 */
interface Academic extends Person {
	@Override
	public default String getName(){
		return "XXX";
	}
}

/**
 * 
 * @author vdiasf01
 *
 */
interface Student extends Person {
	
}

/**
 * 
 * @author vdiasf01
 *
 */
interface TeachingAssistant extends Academic, Student {
    @Override
	public default String getName() {
		return "XCX";
	}
	
}

/**
 * 
 * @author vdiasf01
 *
 */
class TAIml implements TeachingAssistant {
    public String getName() {
    	return "Method";
    }
}




