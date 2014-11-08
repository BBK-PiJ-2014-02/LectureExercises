/** Day 6 - Exercise 5 - Symmetry looks pretty **/

public class MatrixChecker {

    // Constructor
    public void MatricChecker() {
    }

    // Check if integer array is symmetrial with a[i] == a[length-i] for all elements of a[]
    public boolean isSymmetrical(int[] a) {
        if ( a == null ) {
            return true;
        }

        int size = a.length;
        for ( int i = 0; i < size; i++ ) {
            if ( a[i] != a[size-1-i] ) {
                return false;
            }
        }
        return true;
    }

    // Symmetrical if a[i][j] == a[j][i] for all i and j
    public boolean isSymmetrical(int[][] a) {
        if ( a == null ) {
            return true;
        }

        for(int y = 0; y < a.length; y++) {
            for( int x = 0; x < a[0].length; x++ ) {
                if ( x >= a.length || y >= a[x].length ) {
                    return false;
                }
                if ( a[y][x] != a[x][y] ) {
                    return false;
                }
            }
        }
        return true;
    }

    // a[x][y] == 0 for any x > y or x < y
    public boolean isTriangular(int[][] a) {
        if ( a == null ) {
            return false;
        }
        if ( isLowTriangular(a) || isUpTriangular(a) ) {
            return true;
        }
        return false;
    }

    // a[x][y] == 0 for any x > y
    public boolean isLowTriangular(int[][] a) {
        if ( a == null ) {
            return true;
        }
        for(int y = 0; y < a.length; y++) {
            for( int x = 0; x < a[0].length; x++ ) {
                if ( x >= a.length || y >= a[x].length ) {
                    return false;
                }
                if ( y > x && a[y][x] > 0 ) {
                    return false;
                }
            }
        }
        return true;
    }

    // a[x][y] == 0 for any x < y
    public boolean isUpTriangular(int[][] a) {
        if ( a == null ) {
            return true;
        }
        for(int y = 0; y < a.length; y++) {
            for( int x = 0; x < a[0].length; x++ ) {
                if ( x >= a.length || y >= a[x].length ) {
                    return false;
                }
                if ( y < x && a[y][x] > 0 ) {
                    return false;
                }
            }
        }
        return true;
    }
}