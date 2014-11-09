/** Day 7 - Exercise 3 - Singly-linked lists **/

public class TestHospitalManagement {
    public static void main( String[] args ) {
		System.out.println("==== Welcome to the Hospital Management Patient list service ===");
		HospitalManagement hm = new HospitalManagement();
		Patient p1 = new Patient("Test 0",34,"outch");
		hm.addPatient(p1);
		Patient p2 = new Patient("Test 1",32,"outch 2");
		hm.addPatient(p2);
		hm.printList();
    }
}