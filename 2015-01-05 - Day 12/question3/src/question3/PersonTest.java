package question3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {
	@Test
	public void testsNoermalName() {
		Person p = new Person();
		String input = "Dereck Robert Yasirt";
		String output = p.getInitials(input);
		String expected = "DRY";
		assertEquals(output, expected);
	}

}
