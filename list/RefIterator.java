package list;


/**
 * Iterate through a LinkedList
 * 
 * @author Andrew Blanco
 * @version 9/19/16
 */
public class RefIterator<E> implements Iterator<E>
{
   LinkedList<E> list;
   Node<E> cursor; //last node obtained
   
   RefIterator (LinkedList<E> list)
   {
       this.list = list;
       cursor = list.head;
   }
   
   public boolean hasNext()
   {
       return cursor != list.tail.prev;
   }
   
   public E next()
   {
       cursor = cursor.next;
       return cursor.value;
   }
   
   public void remove()
   {
       cursor.next.prev = cursor.prev;
       cursor.prev.next = cursor.next;
       cursor = cursor.prev;
       list.size--;
   }
   
   /** @return true if there are two more values */
   public boolean hasTwoMore()
   {
       if(!hasNext())
            return false;
            
       if(cursor.next.next == list.tail)
            return false;
            
       return true;
   }
   
}
