package queue;
import list.*;

/**
 * An implementation using an ArrayList
 * 
 * @author Andrew Blanco
 * @version 9/30/16
 */
public class ArrayQueue<E> implements QueueADT<E>
{
   int front = 0, back = 0, qSize = 0;
   //qSize is the size of the queue
   List<E> values = new ArrayList<E>();
   
   public void add(E value)
   {
       if(qSize != values.size())
       {
           values.set(back, value);   
       }
       else //ArrayList is full
       {
           values.add(back, value);
           front = (front + 1) % values.size();   
       }
       qSize++;
       back = (back + 1) % values.size();
   }
   
   public E remove()
   {
       E result = values.get(front);
       front = (front + 1) % values.size();
       qSize--;
       return result;
   }
   
   public E peek()
   {
       if(isEmpty())
            return null;
       return values.get(front);
   }
   
   public int size()
   {
       return qSize;
   }
   
   public boolean isEmpty()
   {
       return (qSize == 0);
   }
   
   public void clear()
   {
       front = 0;
       back = 0;
       qSize = 0;
       values.clear();
   }
   
   public String toString()
   {
      String listString = "[";
       for(int i = 0; i < qSize; i++)
      {
          
          
          if(i == back )
          {
                listString = listString + values.get(back) + "]";
          }
          else
          {
                listString = listString + values.get(front + i) + ",";
          }
      }
      

      
      if(listString.length() == 1)
            listString = listString + "]";
            
      return listString;
   }
}
