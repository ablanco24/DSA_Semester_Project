package queue;
import list.*;

/**
 * An implementation using a LinkedList
 * 
 * @author Andrew Blanco
 * @version 9/30/16
 */
public class Queue<E> implements QueueADT<E>
{
    List<E> values = new LinkedList<E>();
    int size = 0;
    
    public Queue()
    {
    }
    
    public void add(E value)
    {
        size++;
        values.add(value);
    }
    
    public E remove()
    {
        size--;
        return values.remove(0);
    }
    
    public E peek()
    {
        if(values.isEmpty())
            return null;
        return values.get(0);
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    public void clear()
    {
        size = 0;
        values.clear();
    }
    
    public String toString()
    {
      String listString = "[";
      for(int i = 0; i < size; i++)
      {
          if(i == size-1)
                listString = listString + values.get(i) + "]";
          else
                listString = listString + values.get(i) + ",";
      }
      
      if(listString.length() == 1)
            listString = listString + "]";
            
      return listString;
   }
    
}
