package list;


/**
 * Write a description of interface ListIterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface ListIterator<E> extends Iterator<E>
{
    /** 
     * @return true if there is a previous value
     */
    boolean hasPrevious();
    
    /**
     * @return previous value
     * Pre: hasPrevious() is true
     */
    E previous();
    
    /**
     * Remove the value las obtained by a call to next or previous
     */
    void remove();
    
    /** Insert the given value just prior to the implicit cursor position */
    public void add (E value);
}
