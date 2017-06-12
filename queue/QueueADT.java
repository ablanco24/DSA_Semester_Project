package queue;


/**
 * A First-in First-out List
 * 
 * @author Andrew Blanco
 * @version 9/30/16
 */
public interface QueueADT<E>
{
   /**
    * Add the given value to the back of this queueADT
    */
   void add(E value);
   
   /**
    * Remove the value which is at front of this queueADT
    * @return the value removed
    * Pre: QueueADT is not empty
    */
   E remove();
   
   /**
    * @return the value at the front of the queueADT
    * or null if this queueADT is empty
    */
   E peek();
   
   /**
    * @return size of the queue
    */
   int size();
   
   /**
    * @return true only if queue is empty
    */
   boolean isEmpty();
   
   void clear();
   
   
}
