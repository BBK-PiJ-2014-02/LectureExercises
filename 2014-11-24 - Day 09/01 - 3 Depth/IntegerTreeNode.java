/** Day 9 - Exercise 1.3 - Depth **/

public interface IntegerTreeNode {
    /**
     *  Adds integer to the tree.
     */
    public void add(int i);

    /**
     *  Checks if given integers exists in tree.
     */
    public boolean contains(int i);

    /**
     *  Returns the maximum integer value from the tree.
     */
    public int getMax();

    /**
     *  Returns the minimum integer value from the tree.
     */
    public int getMin();

    /**
     *  Returns the String of the complete Tree
     */
    public String toString(String complete);

    /**
     *  Returns the String of the Tree in a more simplistic way
     */
    public String toString();

    /**
     *  Returns the number of the depth levels in the tree
     */
    public int depth();

}