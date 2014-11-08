/** Day 6 - Exercise 7 - Big enough **/

public class TestEmployee {
    public static void main( String[] args ) {
        System.out.println("=== Welcome to the employee database ===");
		Employee e = new Employee();
        while( true ) {
            System.out.println("Please insert employee ID: ");
            String str  = System.console().readLine();
            // If user presses enter without any input, exits
            if ( str.length() == 0 ) {
				break;
            }
            int     id  = Integer.parseInt(str);
            // If user gives id zero, exits
            if ( id == 0 ) {
				break;
            }
            System.out.println("Please insert employee Name: ");
            String name = System.console().readLine();
            // If again user gives no input, exits
            if ( name.length() == 0 ) {
				break;
            }
            System.out.println("Adding: "+id+","+name);
            e.add(id,name);
        }
        System.out.println("Your full employee list:");
        e.printFullList();

        // Prints list with users that are even or name starts with S
        System.out.println("Your employees starting with 'S' or with even id:");
        e.printNameStartWithSOrIdEven();

    }
}