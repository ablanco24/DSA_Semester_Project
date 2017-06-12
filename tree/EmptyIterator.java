package tree;
import list.Iterator;

/**
 * Write a description of class EmptyIterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EmptyIterator<E> implements Iterator<E>
{
   public boolean hasNext()
   {
       return false;
   }
   
   public boolean hasTwoMore()
   {
       return false;
   }
   
   //should not be called
   public E next()
   {
       return null;
   }
   //should not be called
   public void remove()
   {
   }
   
   
}
