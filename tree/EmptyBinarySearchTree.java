package tree;
import list.Iterator;

/**
 * An EmptyBinarySearchTree has no value and no children
 * 
 * @author Andrew Blanco
 * @version 10/20/16
 */
@SuppressWarnings("unchecked")
public class EmptyBinarySearchTree<E extends Comparable> implements BinaryTree<E>
{
    /**
     * @return an Iterator
     */
    public Iterator<E> iterator()
    {
        return new EmptyIterator<E>();
    }
    
    public E getValue()
    {
        return null;
    }
    
    public BinaryTree<E> getLeft()
    {
        return null;
    }
    
    public BinaryTree<E> getRight()
    {
        return null;
    }
    
    public BinaryTree<E> add(E value)
    {
        return new BinarySearchTree<E>(value);
    }
    
    public E get(E value)
    {
        return null;
    }
    
    public boolean containsKey(E value)
    {
        return false;
    }
    
    public BinaryTree<E> remove (Object obj)
    {
        return this;
    }
    
    public boolean isEmpty()
    {
        return true;
    }
    
    public void setValue(E value)
    {
    }
    
    public void setLeft(BinaryTree<E> left)
    {
    }
    
    public void setRight(BinaryTree<E> right)
    {
    }
    
    public boolean equals(Object obj)
    {
        try
        {
            EmptyBinarySearchTree<E> comp = (EmptyBinarySearchTree<E>) obj;
            return true;
        }
        catch(ClassCastException e)
        {
            return false;
        }
    }
    
    /** @return the height of this Binary Tree */
    public int getHeight()
    {
        return 0;
    }
    
    public int size()
    {
        return 0;
    }
    
    public String toString()
    {
        return ""; 
    }
}
