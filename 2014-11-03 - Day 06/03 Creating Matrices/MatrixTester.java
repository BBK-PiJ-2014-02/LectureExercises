/** Testing Matrix class **/

public class MatrixTester {

  public static void main( String[] args ) {
    Matrix m = new Matrix(5,6);
    m.setElement(3,2,4);
    m.setRow(3,"-2,4,3,43,44");
    m.setColumn(4,"-4,4,3,5,6,7");
    String str = m.toString();
    m.prettyPrint();
    System.out.println(str);
  }
}