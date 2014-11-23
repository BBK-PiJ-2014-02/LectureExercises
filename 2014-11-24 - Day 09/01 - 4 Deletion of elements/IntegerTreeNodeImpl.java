/** Day 9 - Exercise 1.4 - Deletion of elements **/

public class IntegerTreeNodeImpl implements IntegerTreeNode {
	/**
	 *  Integer value
	 */
	private int value;

    /**
     *  Pointer to lower integer value Node
     */
    IntegerTreeNode left;

    /**
     *  Pointer to higher integer value Node
     */
    IntegerTreeNode right;

    /**
     *  Constructor to add integer value to a newly created node
     */
    public IntegerTreeNodeImpl(int i) {
		this.value = i;
	}

    /**
     *  Adds integer to the tree.
     */
    public void add(int i) {
		if ( i > this.value ) {
			if ( right == null ) {
				right = new IntegerTreeNodeImpl(i);
			}
			else {
				right.add(i);
			}
		}
		else {
			if ( left == null ) {
				left = new IntegerTreeNodeImpl(i);
			}
			else {
				left.add(i);
			}
		}
	}

    /**
     *  Checks if given integers exists in tree.
     */
    public boolean contains(int i) {
		if ( i == this.value ) {
			return true;
		}
		else if ( i > this.value ) {
			if ( right == null ) {
				return false;
			}
			else {
				return right.contains(i);
			}
		}
		else {
			if ( left == null ) {
				return false;
			}
			else {
				return left.contains(i);
			}
		}
	}

    /**
     *  Returns the maximum integer value from the tree.
     */
    public int getMax() {
		if ( right == null ) {
			return this.value;
		}
		else {
			return right.getMax();
		}
	}

    /**
     *  Returns the minimum integer value from the tree.
     */
    public int getMin() {
		if ( left == null ) {
			return this.value;
		}
		else {
			return left.getMin();
		}
	}

    /**
     *  Returns the String of the complete Tree
     */
    @Override
    public String toString(String complete) {
		if ( left == null && right == null ) {
			return "["+this.value+" L[] R[]]";
		}
		else if ( left == null && right != null ) {
			return "["+this.value+" L[] R"+right.toString("complete")+"]";
		}
		else if ( left != null && right == null ) {
			return "["+this.value+" L"+left.toString("complete")+" R[]]";
		}
		else {
			return "["+this.value+" L"+left.toString("complete")+" R"+right.toString("Complete")+"]";
		}
	}

    /**
     *  Returns the string of the Tree in a more simplistic way
     */
    @Override
    public String toString() {
		if ( left == null && right == null ) {
			return "["+this.value+"]";
		}
		else if ( left == null && right != null ) {
			return "["+this.value+" "+right.toString()+"]";
		}
		else if ( left != null && right == null ) {
			return "["+this.value+" "+left.toString()+"]";
		}
		else {
			return "["+this.value+" "+left.toString()+" "+right.toString()+"]";
		}
	}

    /**
     *  Return the depth of the tree
     */
    public int depth() {
		if ( this.left == null && this.right == null ) {
			return 0;
		}
		else if ( this.left == null && this.right != null ) {
			return this.right.depth() + 1;
		}
		else if ( this.left != null && this.right == null ) {
			return this.left.depth() + 1;
		}
		else {
			int r = this.right.depth();
			int l = this.left.depth();
			if ( r > l ) {
				return r + 1;
			}
			else {
				return l + 1;
			}
		}
	}

    /**
     *  Removes a node from the tree matching given value
     */
    public void remove(int i) {
	}


}
