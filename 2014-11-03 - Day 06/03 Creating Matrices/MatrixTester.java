/** Testing Matrix class **/

public class MatrixTester {

  public static void main( String[] args ) {
    Matrix m = new Matrix(8,8);
    m.setElement(2,3,4);
    m.prettyPrint();

  }
}