public class Company {
    private GenericList<String> names;
    private GenericList ni;

    public Company() {
    }

    public void add(String name, int ni) {
		this.names.add(new Node(name));
//		this.ni.add(ni);
	}
}