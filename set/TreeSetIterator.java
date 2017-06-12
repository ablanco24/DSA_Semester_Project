package set;
import tree.*;

/**
 * Write a description of class TreeSetIterator here.
 * 
 * @author Andrew Blanco
 * @version 11/14/16
 */ 
@SuppressWarnings("unchecked")
public class TreeSetIterator<E extends Comparable> extends TreeIterator<E>
{
    TreeSet<E> set;
    public TreeSetIterator(TreeSet<E> set)
    {
        super(set.tree);
        this.set = set;
    }
    
    public void remove()
    {
        set.tree = set.tree.remove(getLastGotten());
        set.size--;
    }
}
