package set;
import list.*;

/**
 * Collection with no duplicates.
 * No ordering required
 * 
 * @author Andrew Blanco
 * @version 11/14/16
 */

public interface Set<E>
{
    /**
     * add the given value to this set
     * @return true if it was added
     */
    boolean add(E value);
    
    /**
     * @return true if the given object is in this set
     */
    boolean contains(Object obj);
    
    /**
     * remove given obj from this set if possible,
     * @return true if it was removed
     */
    boolean remove(Object obj);
    
    /**
     * @return an Iterator for this set
     */
    Iterator<E> iterator();
    
    /** @return the number of values in this Set */
    int size();

    /** @return true if this Set is empty  */
    boolean isEmpty();

    /** Make this Set an empty Set */
    void clear();
    
     /** @return the elements of this Set as a String */ 
     public String   toString(); 
 
     /** @return true if obj is a Set and all the values in this Set are in the other Set, 
       and all the values in the other Set are in this Set */ 
       public boolean equals(Object obj); 
       
       /** @return a Set which is the intersection of this Set with other */

    Set < E> intersection  (Set < E> other);
}
