/** Day 6 - Exercise 3 - reating matrices **/

public class Matrix {

    private int[][] matrix;

    public Matrix(int aSize, int bSize) {
        this.matrix = new int[aSize][bSize];
        reset();
    }

    // Sets all elements of the matrix to 1
    private void reset() {
        for( int i = 0; i < this.matrix.length; i++ ) {
            for( int j = 0; j < this.matrix[i].length; j++ ) {
                this.matrix[i][j] = 1;
            }
        }
    }

    public void setElement(int x, int y, int value) {
        this.matrix[x][y] = value;
    }

    public void setRow(int x, String str) {
    }

    public void setColumn(int x, String str) {
    }

    @Override
    public String toString() {
        return "";
    }

    public void prettyPrint() {
        for( int i = 0; i < this.matrix.length; i++ ) {
            for( int j = 0; j < this.matrix[i].length; j++ ) {
                System.out.print("\t"+this.matrix[i][j]);
            }
            System.out.println();
        }
    }
}