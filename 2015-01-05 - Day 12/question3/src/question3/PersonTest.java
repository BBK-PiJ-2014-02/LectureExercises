package question3;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * Testing Person class
 * @author Vasco
 *
 */
public class PersonTest {
	/**
	 * Test Normal Name for correct initials.
	 */
	@Test
	public void testsNormalName() {
		Person p = new Person();
		String input = "Dereck Robert Yasirt";
		String output = p.getInitials(input);
		String expected = "DRY";
		assertEquals(output, expected);
	}

	/**
	 * Test on multiple spaces.
	 */
	@Test
	public void testMultipleSpaces() {
		Person p = new Person();
		String input = "Dereck  Robert    Yasirt";
		String output = p.getInitials(input);
		String expected = "DRY";
		assertEquals(output, expected);
	}

	/**
	 * Test on upper cased initials.
	 */
	@Test
	public void testUpperCases() {
		Person p = new Person();
		String input = "dereck    RObert   yasirt";
		String output = p.getInitials(input);
		String expected = "DRY";
		assertEquals(output, expected);
	}

	/**
	 * Test on an empty string name.
	 */
	@Test
	public void testEmptyName() {
		Person p = new Person();
		String input = "";
		String output = p.getInitials(input);
		String expected = "";
		assertEquals(output, expected);
	}

	/**
	 * Test on a NULL name given.
	 */
	@Test
	public void testNULLName() {
		Person p = new Person();
		String input = null;
		String output = p.getInitials(input);
		String expected = "";
		assertEquals(output, expected);
	}

	/**
	 * Test on one name only.
	 */
	@Test
	public void testOneName() {
		Person p = new Person();
		String input = "oneName";
		String output = p.getInitials(input);
		String expected = "O";
		assertEquals(output, expected);
	}
}
