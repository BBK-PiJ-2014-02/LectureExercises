public class GenericList<T> {
   private Node<T> first;

   public GenericList() {
   }

   public void add(Node<T> node) {
	   if ( first == null ) {
		   this.first = node;
	   }
	   else {
		   first.add(node);
	   }
   }
}