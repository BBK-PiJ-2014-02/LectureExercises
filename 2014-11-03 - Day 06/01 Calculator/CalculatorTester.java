/** Testing Calculator class **/

class CalculatorTester {
    public static void main( String[] args ) {
		Calculator c = new Calculator();
        c.add(1,2);
        c.subtract(2,-3);
        c.subtract(-2,-3);
        c.subtract(-2,3);
        c.multiply(3,4);
        c.divide(124852,17523);
        c.divide(4,0);
        c.divide(0,5);
        c.divide(4,-5);
        c.modulus(5,6);
        c.modulus(5,0);
    }
}