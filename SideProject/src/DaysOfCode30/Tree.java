//Unit Testing + Specifications + Test Your Binary Search Tree!

package DaysOfCode30;

public interface Tree<D extends Comparable> {
    public boolean isEmpty();
    public int cardinality();
    public boolean member(D elt);
    public NonEmptyBST<D> add(D elt);
    
}

