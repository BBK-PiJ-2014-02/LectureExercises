package question2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestingSimpleMap {
	/**
	 * Test Name.
	 */
	private final String TEST_NAME = "Test Name";
	
	/**
	 * Max range number.
	 */
    private final int RANGE = 10000;
    
    /**
     * Amount of runs.
     */
    private final int RUNS = 2000;
    
    /**
     * SimpleMap
     */
    private SimpleMap sm;
    
    /**
     * Initialize SimpleMap.
     */
    @Before
    public void initialization() {
    	sm = new SimpleMapImpl();
    }

    /**
     * Test SimpleMap for 2k random values put and get
     */
	@Test
    public void testSimpleMapFor2kRandomValuesInRange() {
		// Add 2k random values
		for( int i = 0; i < RUNS; i++ ) {
			int randomNumber = (int) (Math.random()*RANGE);
			sm.put(randomNumber, "" + randomNumber);
		}
		
		// Scan throughout the n-RUNS if output is within range
		for( int i = 0; i < RUNS; i++ ) {
			String response = sm.get(i);
			if ( response != null ) {
				int randomNumber = Integer.parseInt(response);
				if (!( randomNumber >= 0 && randomNumber <= RANGE ) ) {
					assertTrue(false);
				}
			}
		}
		assertTrue(true);
    }
	
	/**
	 * Test one complete cycle through all given methods.
	 */
	@Test
	public void testOneCompleteCycle() {
		// Add one entry
		sm.put(25, TEST_NAME);
		
		// Check response
		String response = sm.get(25);
		assertEquals(TEST_NAME, response);
		
		// Check if not empty
		assertFalse(sm.isEmpty());
		
		// Remove added entry and check if empty
		sm.remove(25);
		assertTrue(sm.isEmpty());
	}
}
