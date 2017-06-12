package list;


/**
 * An Iterator permits acess to the elements of a collection, 
 * one at a time
 * 
 * @author Andrew Blanco 
 * @version 9/19/16
 */
public interface Iterator <E>
{
    /**
     * @return true if there are more items
     */
    boolean hasNext();
    
    /**
     * Pre: hasNext() is true
     * @return the value of next item
     */
    E next();
    
    /**
     * Remove the last item returned by a call to next()
     */
    void remove();
    
    /** @return true if there are two more values */
    boolean hasTwoMore();
}
