/** Testing Matrix class with MatrickChecker methods **/

public class SymmetryTester {

    public static void main( String[] args ) {
        Matrix m = new Matrix(4,4);

        // Check symmetrical
        int[] a = {1,2,3,2,1};
        System.out.println("Int array is symmetrical? "+m.isSymmetrical(a));

        // Check 2-D symmetrical
        m.setMatrix("1,2,2,1;2,2,2,2;2,2,3,3;1,2,3,2");
        m.prettyPrint();
        System.out.println("Matix is symmetrical? "+m.isSymmetrical());

        // Check triangular
        m.setMatrix("1,2,2,1;0,2,2,2;0,0,3,3;0,0,0,2");
        m.prettyPrint();
        System.out.println("Matrix is triangular? "+m.isTriangular());
    }
}