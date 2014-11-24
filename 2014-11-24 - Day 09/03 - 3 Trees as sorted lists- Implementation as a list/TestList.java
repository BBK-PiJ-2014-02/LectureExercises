public class TestList {
    public static void main( String[] args ) {
        IntSortedList isd = new ListIntSortedList(10);
        isd.add(6);
        isd.add(1);
        isd.add(3);
        isd.add(5);
        isd.add(4);
        isd.add(2);
        System.out.println(isd.toString());
    }
}