package set;
import tree.*;
import list.*;
/**
 * Implementation of set using BST
 * 
 * @author Andrew Blanco 
 * @version 11/14/16
 */
@SuppressWarnings("unchecked")
public class TreeSet<E extends Comparable> implements Set<E>
{
    BinaryTree<E> tree = new EmptyBinarySearchTree();
    int size = 0;
    
    public boolean add(E value)
    {
        if(tree.containsKey(value))
            return false;
        tree = tree.add(value);
        size++;
        return true;
    }
    
    public boolean contains(Object obj)
    {
        E value;
        try 
        {
            value = (E) obj;
            return tree.containsKey(value);
        }
        catch(ClassCastException cce)
        {
            return false;
        }
    }
    
    public boolean remove(Object obj)
    {
        if(!contains(obj))
            return false;
            
        tree = tree.remove(obj);
        size--;
        return true;
    }
    
    public Iterator<E> iterator()
    {
        if(size == 0)
            return new EmptyIterator();
        return new TreeSetIterator(this);
    }
    
    /** @return the number of values in this Set */
    public int size()
    {
        return size;
    }

    /** @return true if this Set is empty  */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /** Make this Set an empty Set */
    public void clear()
    {
        tree = new EmptyBinarySearchTree();
        size = 0;
    }
    
    /** @return the elements of this Set as a String */ 
    public String toString()
    {
        String set = "[";
        int maxSize = size - 1;
        int bot = 0;
        
        Iterator<E> itty = iterator();
        while(itty.hasNext())
        {
            if(bot < maxSize)
                set = set + itty.next() + ",";
            else
                set = set + itty.next();
            bot++;
        }
        set = set + "]";
        
        return set;
    }
 
    /** @return true if obj is a Set and all the values in this Set are in the other Set, 
       and all the values in the other Set are in this Set */ 
       public boolean equals (Object obj) 
       {
           try
           {
               Set<E> temp = (Set<E>) obj;
               
               if(!(temp.size() == size))
                    return false;
               Iterator<E> itty = iterator();
               
               while(itty.hasNext())
               {
                   if(!(temp.contains(itty.next())))
                        return false;
               }
               return true;
           }
           catch(ClassCastException e)
           {
               return false;
           }
           
       }
       
    public Set<E> intersection(Set<E> other)
    {
         Set<E> result;
         result = new TreeSet<E>();
         Iterator<E> itty = iterator();
         while(itty.hasNext())
         {
             E temp = itty.next();
             if(other.contains(temp))
                result.add(temp);
         }
         
         return result;
    }
}
