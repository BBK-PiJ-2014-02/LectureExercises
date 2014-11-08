/** Day 6 - Exercise 7 - Big enough **/

public class Employee {
    private String[] name;
    private int[]    id;

    // Increases the array size by one and adds the latest
    public int add( int id, String name ) {
        if ( this.name != null ) {
            // Add one to the number of length
            int newSize = this.id.length + 1;

            // Create new arrays with the new length
            String[] namePlusOne = new String[newSize];
            int[] idPlusOne      = new int[newSize];

            // Copy data to new arrays
            for ( int i = 0; i < this.id.length ; i++ ) {
    			idPlusOne[i]   = this.id[i];
                namePlusOne[i] = this.name[i];
            }
            // Add the latest records
            namePlusOne[newSize-1] = name;
            idPlusOne[newSize-1]   = id;

            // Recreate our arrays with new length
            this.name = new String[newSize];
            this.id   = new int[newSize];

            // Populate our arrays with copied data
            for ( int i = 0; i < newSize ; i++ ) {
    			this.id[i]   = idPlusOne[i];
    			this.name[i] = namePlusOne[i];
            }
            return newSize;
        }
        else {
            this.id      = new int[1];
            this.name    = new String[1];
            this.id[0]   = id;
            this.name[0] = name;
            return 1;
        }
	}

    // Accessor to name on a given index
    public String getName( int index ) {
		if ( index >= 0 && index < this.name.length ) {
          return this.name[index];
        }
        return null;
    }

    // Accessor to id on a given index
    public int getId( int index ) {
		if ( index >= 0 && index < this.id.length ) {
            return this.id[index];
        }
        return -1;
    }

    // Prints employees with name starting with S or even Ids
    public void printNameStartWithSOrIdEven() {
		for ( int i = 0; i < this.id.length; i++ ) {
			if ( this.id[i] % 2 == 0 || this.name[i].charAt(0) == 'S' ) {
                System.out.println("ID: "+this.id[i]+" Name: "+this.name[i]);
            }
        }
    }

    public void printFullList() {
        for ( int i = 0; i < this.id.length; i++ ) {
           System.out.println("ID: "+this.id[i]+" Name: "+this.name[i]);
       }
	}
}