/** Day 7 - Exercise 4 - Queue length **/

public class TestHospitalManagement {
    public static void main( String[] args ) {
		System.out.println("==== Welcome to the Hospital Management Patient list service ===");
		HospitalManagement hm = new HospitalManagement();
		Patient p01 = new Patient("Test 0",34,"outch 1");
		Patient p02 = new Patient("Test 1",32,"outch 2");
		Patient p03 = new Patient("Test 2",32,"outch 3");
		Patient p04 = new Patient("Test 3",32,"outch 4");
		Patient p05 = new Patient("Test 4",32,"outch 5");
		Patient p06 = new Patient("Test 5",32,"outch 6");
		Patient p07 = new Patient("Test 6",32,"outch 7");
		Patient p08 = new Patient("Test 7",32,"outch 8");
		Patient p09 = new Patient("Test 8",32,"outch 9");
		Patient p10 = new Patient("Test 9",32,"outch 10");
		hm.addPatient(p01);
		hm.addPatient(p05);
		hm.addPatient(p03);
		hm.addPatient(p04);
		hm.addPatient(p06);
		hm.addPatient(p07);
		hm.addPatient(p08);
		hm.addPatient(p02);
		hm.addPatient(p09);
		hm.addPatient(p10);
		System.out.println("List length before deletion: "+hm.lengthI());
		hm.deletePatient("Test 5");
		hm.deletePatient("Test 4");
		hm.deletePatient("Test 7");
		hm.deletePatient("Test 0");
		hm.deletePatient("Test 2");
		hm.deletePatient("Test 5");
		hm.deletePatient("Test 50");
		hm.printList();
		System.out.println("List length after deletion: "+hm.lengthI());
    }
}