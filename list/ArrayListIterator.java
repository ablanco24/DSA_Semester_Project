package list;


/**
 * A class which implements ListIterator for ArrayList
 * 
 * @author Andrew Blanco
 * @version 9/25/16
 */
public class ArrayListIterator<E> extends ArrayIterator<E> implements ListIterator<E>
{
   private boolean forward = true;
   ArrayListIterator(List<E> list)
   {
       super(list);
       cursor = 0;
   }
   
   ArrayListIterator(List<E> list, int start)
   {
       super(list);
       cursor = start;
   }
   
   public boolean hasNext()
   {
       if(list.isEmpty())
            return false;
       return cursor < list.size();
   }
   
   public E next()
   {
       forward = true;
       cursor++;
       return list.get(cursor-1);
   }
   
   public boolean hasPrevious()
   {
       if(list.isEmpty())
            return false;
       return cursor > 0;
   }
   
   public E previous()
   {
       forward = false;
       cursor--;
       return list.get(cursor);
   }
   
   public void remove()
   {
       if(forward)
            cursor--;
       list.remove(cursor);
   }
   
   /** Insert the given value just prior to the implicit cursor position */
   public void add (E value)
   {
       
       list.add(cursor, value);
       cursor++;
   }
}
