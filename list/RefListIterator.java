package list;


/**
 * A class which implements ListIterators for LinkedList
 * 
 * @author Andrew Blanco 
 * @version 9/25/16
 */
public class RefListIterator<E> extends RefIterator <E> implements ListIterator<E>
{
   
   private boolean forward = true;
   //cursor refers to forward = true
   //returned by next() or previous()
   RefListIterator(LinkedList<E> list)
   {
       super(list);
   }
   
   /**
    * Pre: 0 <= size
    */
   RefListIterator(LinkedList<E> list, int start)
   {
       super(list);
       for(int i = 0; i < start; i++)
            cursor = cursor.next;
   }
   
   public boolean hasNext()
   {
       if(list.isEmpty())
            return false;
       if(forward)
            return cursor.next != list.tail;
       return true;
   }
   
   public E next()
   {
       if(forward)
            cursor = cursor.next;
       forward = true;
       return cursor.value;
   }
   
   public boolean hasPrevious()
   {
       if(list.isEmpty())
            return false;
       if(!forward)
            return cursor.prev != list.head;
       return cursor != list.head; //initial to hasPrevious()
   }
   
   public E previous()
   {
       if(!forward)
           cursor = cursor.prev;
       forward = false;
       return cursor.value;
   }
   
   public void remove()
   {
       super.remove();
       if(!forward)
           cursor = cursor.next;
   }
   
   /** Insert the given value just prior to the implicit cursor position */
   public void add (E value)
   {
           if(forward)
           {
               Node<E> temp = new Node<E>(value, cursor.next, cursor);
               cursor.next.prev = temp;
               cursor.next = temp;
               next();
          
           }
           else
           {
               
               Node<E> temp = new Node<E>(value, cursor, cursor.prev);
               cursor.prev.next = temp;
               cursor.prev = temp;
           }
       
           list.size++;
   }
   
   
}
