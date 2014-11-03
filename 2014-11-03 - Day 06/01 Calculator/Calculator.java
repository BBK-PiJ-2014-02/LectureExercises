/** Day 6 - Exercise 1 - Calculator **/

public class Calculator {

  public void print(int a, int b, String op, String result) {
    System.out.println(a+" "+op+" "+b+" = "+result);
  }

  public void add(int a, int b) {
    print(a,b,"+",""+(a+b));
  }

  public void subtract(int a, int b) {
    print(a,b,"-",""+(a-b));
  }

  public void multiply(int a, int b) {
    print(a,b,"*",""+(a*b));
  }

  public void divide(int a, int b) {
    if ( b == 0 ) {
      print(a,b,"/","NOT VALID OPERATION");
    }
    else {
      print(a,b,"/", ""+((double)a/(double)b) );
    }
  }
  public void modulus(int a, int b) {
    if ( b == 0 ) {
      print(a,b,"%","NOT VALID OPERATION");
    }
    else {
      print(a,b,"%",""+(a%b));
    }
  }
}