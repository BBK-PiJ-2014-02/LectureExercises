public class TestComparator {
    public static void main(String[] args) {
		Comparator c = new Comparator();
		System.out.println("Max(1,2) = "+c.getMax(1,2));
		System.out.println("Max(1.01,2.2) = "+c.getMax(1.01,2.2));
		System.out.println("Max(\"12\",\"21\") = "+c.getMax("12","21"));
    }
}
