/** Day 6 - Exercise 3 - reating matrices **/

public class Matrix {

    private int[][] matrix;

    // Constructor
    public Matrix(int xSize, int ySize) {
        this.matrix = new int[ySize][xSize];
        reset();
	}

    // Sets all elements of the matrix to 1
    private void reset() {
        for( int y = 0; y < this.matrix.length; y++ ) {
            for( int x = 0; x < this.matrix[y].length; x++ ) {
                this.matrix[y][x] = 1;
            }
        }
    }

    // Set one element of the matrix
    public void setElement(int x, int y, int value) {
		// Check if x,y values are inside the bounds
		if ( x >= 0 && y >= 0 && y < this.matrix.length && x < matrix[this.matrix.length-1].length ) {
            this.matrix[y][x] = value;
        }
    }

    // Set a row with comma separated string values
    public void setRow(int y, String str) {
		if ( str == null ) {
			return;
        }
		int strNumbers = commaCount(str) + 1;

		// Ensure that the row to update is valid
        if ( y >= 0 && y < this.matrix.length && strNumbers == this.matrix[0].length ) {
			int[] numbers = new int[strNumbers];
			numbers = toInt(str);
			for ( int i = 0; i < strNumbers; i++ ) {
				setElement(i,y,numbers[i]);
			}
        }
    }

    // Set a column with comma separated string values
    public void setColumn(int x, String str) {
		if ( str == null ) {
			return;
        }
		int strNumbers = commaCount(str) + 1;

		// Ensure that the column to update is valid
        if ( x >= 0 && x < this.matrix[0].length && strNumbers == this.matrix.length ) {
			int[] numbers = new int[strNumbers];
			numbers = toInt(str);
			for ( int i = 0; i < strNumbers; i++ ) {
				setElement(x,i,numbers[i]);
			}
        }
    }

    // Count number of commas in string
    // Internal functionality not to be exposed to other classes
    private int commaCount(String str) {
        int commas = 0;
        for( int i = 0; i < str.length(); i++ ) {
            if ( str.charAt(i) == ',' ) {
                commas++;
            }
		}
		return commas;
	}

    // Convert "1,2,3,4" to int array with 1,2,3,4
    // Internal functionality not to be exposed to other classes
    private int[] toInt(String str) {
        int[] integers;
        integers = new int[commaCount(str)+1];

        int index = 0;

        String s = "";
        for( int i = 0; i < str.length(); i++ ) {
            if ( str.charAt(i) != ',' ) {
                s += str.charAt(i);
            }
            else {
				integers[index] = Integer.parseInt(s);
				s = "";
				index++;
			}
		}
        integers[index] = Integer.parseInt(s);

        return integers;
	}

    @Override
    // Converting the matrix to String i.e.: [1,2,-2;2,3,0..]
    public String toString() {
		String str = "[";
		for( int y = 0; y < this.matrix.length; y++ ) {
			String row = "";
			for( int x = 0; x < this.matrix[0].length; x++ ) {
                row += this.matrix[y][x];
                if ( x+1 != this.matrix[0].length ) {
				    row += ",";
				}
			}
			str += row;
			if ( y+1 != this.matrix.length ) {
				str += ";";
            }
		}
		str += "]";
        return str;
    }

    public void prettyPrint() {
        for( int y = 0; y < this.matrix.length; y++ ) {
            for( int x = 0; x < this.matrix[y].length; x++ ) {
                System.out.print("\t"+this.matrix[y][x]);
            }
            System.out.println();
        }
    }
}