package question2;

/** Day 8 - Exercise 5.2 - Simple map **/

/**
 * Map from integer to Strings
 */
public class SimpleMapImpl implements SimpleMap {
	/**
	 *  Internal list array
	 */
	private String[] hash;

	/**
	 *  Constructor.
	 */
	public SimpleMapImpl() {
		this.hash = new String[1000];
		for(int i = 0; i < hash.length; i++) {
			this.hash[i] = "";
		}
	}
	
	/**
	 * Puts a new String in the map.
	 *
	 * If the key is already in the map, nothing is done.
	 */
	public void put(int key, String name) {
		int index = HashUtilities.shortHash(key);
		if ( this.hash[index] != null ) {
			this.hash[index] = name;
		}
	}

	/**
	 * Returns the name associated with that key,
	 * or null if there is none.
	 */
	public String get(int key) {
		int index = HashUtilities.shortHash(key);
		if ( this.hash[index].length() > 0 ) {
			return this.hash[index];
		}
		return null;
	}

	/**
	 * Remove a name from the map. Future calls to get(key)
	 * will return null for this key unless another
	 * name is added with the same key.
	 */
	public void remove(int key) {
        int index = HashUtilities.shortHash(key);
        if ( this.hash[index].length() > 0 ) {
        	this.hash[key] = "";
        }
	}

	/**
	 * Returns true if there are no workers in the map,
	 * false otherwise.
	 */
	public boolean isEmpty() {
		for( int i = 0; i < this.hash.length; i++ ) {
			if ( this.hash[i].length() > 0 ) return false;
		}
		return true;
	}
}