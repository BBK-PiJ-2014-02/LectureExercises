/** Day 9 - Exercise 1.1 - Integer Binary Tree **/

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

}
