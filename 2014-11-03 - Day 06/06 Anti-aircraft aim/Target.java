/** Day 6 - Exercise 6 - Air-craft aim **/

public class Target {
    // 3-D matrix
    private int[][][] matrix;
    private Result result;
    private int[] target = new int[3];

    // Constructor
    public Target(int size) {
        this.matrix = new int[size][size][size];
        reset();
    }

    // Sets all elements to 0
    private void reset() {
        for( int y = 0; y < this.matrix.length; y++ ) {
            for( int x = 0; x < this.matrix[y].length; x++ ) {
                for( int z = 0; z < this.matrix[y][x].length; z++ ) {
                    this.matrix[y][x][z] = 0;
                }
            }
        }
    }

    // Sets all elements to 0 with the exception of the int numberToGuess position
    private void reset(int numberToGuess) {
        int position = 0;
        for( int y = 0; y < this.matrix.length; y++ ) {
            for( int x = 0; x < this.matrix[y].length; x++ ) {
                for( int z = 0; z < this.matrix[y][x].length; z++ ) {
                    if ( position == numberToGuess ) {
                        this.matrix[y][x][z] = 1;
                        this.target[0] = x;
                        this.target[1] = y;
                        this.target[2] = z;
                    } else {
                        this.matrix[y][x][z] = 0;
                    }
                    position++;
                }
            }
        }
    }

    // Init resets matrix to zero except one random element
    public void init() {
		int size = matrix.length;
		int numberToGuess = (int) Math.abs(Math.pow(size,3)*Math.random());
		reset(numberToGuess);
    }

    public Result fire(int x, int y, int z) {
        int matrixSize = matrix.length;

        // OUT_OF_RANGE
        if ( y >= matrixSize || x > matrixSize || z > matrixSize ) {
            return Result.OUT_OF_RANGE;
        }

        // HIT
        if ( matrix[y][x][z] == 1 ) {
            return Result.HIT;
        }

        // FAIL_LEFT
        if ( target[0] < x ) {
            return Result.FAIL_LEFT;
        }

        // FAIL_RIGHT
        if ( x < target[0] ) {
            return Result.FAIL_RIGHT;
        }

		// FAIL_HIGH
        if ( y < target[1] ) {
            return Result.FAIL_HIGH;
        }

        // FAIL_LOW
        if ( target[1] < y ) {
            return Result.FAIL_LOW;
        }

        // FAIL_SHORT
        if ( z < target[2] ) {
            return Result.FAIL_SHORT;
        }
        // FAIL_LONG
        if ( target[2] < z ) {
            return Result.FAIL_LONG;
        }

        return Result.OUT_OF_RANGE;
    }
}