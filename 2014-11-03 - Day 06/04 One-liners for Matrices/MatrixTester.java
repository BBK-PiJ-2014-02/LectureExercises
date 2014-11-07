/** Testing Matrix class **/

public class MatrixTester {

  public static void main( String[] args ) {
    Matrix m = new Matrix(5,6);
    m.setMatrix("1,2,3,4,50;12,23,34,45,546;4,2,3,4,5;4,33,4,52,3;42,43,45,5,5;23,454,23,45,34;23,12,32,43,12");
    m.prettyPrint();
    String str = m.toString();
    System.out.println(str);
  }
}