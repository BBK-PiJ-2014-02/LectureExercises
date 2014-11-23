/** Day 9 - Exercise 1.1 - Integer Binary Tree **/

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

}