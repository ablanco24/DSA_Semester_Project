package queue;
import list.*;

/**
 * Implement priority queue with a heap
 * 
 * @author Andrew Blanco
 * @version 11/28/16
 */
public class PriorityQueue<E extends Comparable<E>> implements QueueADT<E>
{
    List<E> list = new ArrayList<E>();
    
    /**
     * Remove the value with highest priority
     * @return the value removed
     */
    public E remove()
    {
        E result = list.get(0);
        int avail = 0; //available position
        int bc = biggerChild(0);
        int last = list.size()-1;
        while(2*avail + 1 < last && greater(bc,last)) 
        {
            list.set(avail, list.get(bc));
            avail = bc;
            bc = biggerChild(avail);
            
            
        }
        list.set(avail, list.get(last));
        list.remove(last);
        return result;
    }
    
    /**
     * Add a value to this Queue, maintaining the heap property
     */
    public void add(E value)
    {
        list.add(value); 
        int added = list.size()-1;
        int parent = (added-1)/2;
        while(added > 0 &&  greater(added,parent))
        {
            swap(added,parent);
            added = parent;
            parent = (added-1)/2;
        }
    }
    
    private int biggerChild(int parent)
    {
        int left = 2*parent+1;
        int right = 2*parent + 2;
        if(right >= list.size())
            return left;
        if(greater(right,left))
            return right;
        return left;
    }
    
    private boolean greater(int x, int y)
    {
        return list.get(x).compareTo(list.get(y)) > 0;
    }
    
    public E peek()
    {
        return list.get(0);
    }
    
    private void swap(int x, int y)
    {
       E temp;
       temp = list.get(x);
       list.set(x, list.get(y));
       list.set(y, temp);
    }
    
    public int size()
    {
        return list.size();
    }
    
    public void clear()
    {
        list.clear();
    }
    
    public boolean isEmpty()
    {
        return size() == 0;
    }
    
    
}
