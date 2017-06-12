package list;


/**
 * A reference based implentation of the list interface, doubly Linked List
 * 
 * @author Andrew Blanco
 * @version 9/12/16
 */
@SuppressWarnings("unchecked")
public class LinkedList <E> implements List<E>
{
    int size = 0;
    Node <E> head = new Node<E>(null, null, null); //Start of a list
    Node <E> tail = new Node<E>(null, null, head); // end
    private Node<E>ref;
    
    public LinkedList()
    {
        head.next = tail; //fixes the head.next field to refer to new dummy tail
    }
    
    //copy constructor
    public LinkedList (List<E> list)
    {
        this();
        Iterator <E> itty = list.iterator();
        while (itty.hasNext())
            add(itty.next());
    }
    
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return (size == 0);
    }
    
    public void clear()
    {
        
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public void add(E value)
    {
        Node<E> temp = new Node<E>(value, tail, tail.prev);
        tail.prev = temp;
        temp.prev.next = temp;
        size++;
    }
    
    public void add(int ndx, E value)
    {
        if (ndx == size)
        {
            add(value);
        }
        else
        {
            setRef(ndx);
            
            Node<E> temp = new Node<E>(value, ref, ref.prev);
            
            ref.prev = temp;
            temp.prev.next = temp;
   
            size++;
        }
    }
    
    //post: ref refers to the node at position ndx
    private void setRef(int ndx)
    {
        ref = head.next;
        for(int i=0; i< ndx; i++)
        {
            ref = ref.next;
        }
    }
    
    public E get(int ndx)
    {
        setRef(ndx);
        return ref.value;
            
    }
    
    public E set(int ndx, E value)
    {
        setRef(ndx);
        
        E result = ref.value;
        ref.value = value;
        
        return result; 
    }
    
    public E remove(int ndx)
    {
        setRef(ndx);
        
        E result = ref.value;
        ref.next.prev = ref.prev;
        ref.prev.next = ref.next;
        
        size--;
        return result;
    }
    
    //indexOf start at the head with a counter and keep searching til you get to tail 
    public int indexOf(Object obj)
    {
        int cntr = 0;
        boolean found = false;
        setRef(0);
        for(int i=0; i< size && !found; i++)
        {
            if(ref.value.equals(obj))
            {
                found = true;
            }
            else
            {
                ref = ref.next;
                cntr++;
            }
        }
        
        if(!found)
            return -1;
        else
            return cntr;
    }
    
    /** 
     * @return true only if the given object is contained in this List 
     * HOMEWORK
     */
    public boolean contains (Object obj)
    {
        if(indexOf(obj) == -1)
            return false;
        else
            return true;
    }
    
    /** 
    * Remove the first occurrence of the given object from this List, if possible.
    *  @return true only if it was removed.
    *  HOMEWORK
    */
    public boolean remove (Object obj)
    {
        int index = indexOf(obj);
        if(index == -1)
            return false;
        else
        {
            int temp = size;
            remove(index);
            return temp != size;
        }
    }
    
    /** 
     * @return the elements of this List as a String, 
     * with elements separated by commas, 
     * enclosed in square brackets:[a,b,c]
     * HOMEWORK
    */
    public String toString( )
    {
        
        
        String listString = "[";
        for(int i = 0; i < size; i++)
        {
            setRef(i);
            if (i == size - 1)
                listString = listString + ref.value + "]";
            else
                listString = listString + ref.value + ",";
        }
        
        if(listString.length() == 1)
            listString = listString + "]";
        
        return listString;
    }
    
     /** 
      * @return true only if this List is equal to the parameter, other 
      * HOMEWORK
     */
    public boolean equals (Object other)
    {
       if(!(other instanceof List))
            return false;
        List<E> temp;
        temp = (List) other;
       if(temp.size() != size)
           return false;
       Iterator<E> it = temp.iterator();
       Iterator<E> linkList = this.iterator();
       while(it.hasNext())
       {
          if(!(it.next().equals(linkList.next())))
              return false;
            
                   
       }
       return true;
    }
    
    public Iterator<E> iterator()
    {
        return new RefIterator<E>(this);
    }
    
    /**@return true if this List contains at least one null reference.  HOMEWORK*/
    public boolean containsNull()
    {
        return false;
    }
    
    /** Add all elements of other to the end of this List */
    public void addAll(List other)
    {
        Iterator<E> it = other.iterator();
        while(it.hasNext())
        {
            add(it.next());
        }
    }
    
    public ListIterator<E> listIterator()
    {
        return new RefListIterator<E>(this);
    }
    
    public ListIterator<E> listIterator(int start)
    {
        return new RefListIterator<E>(this,start);
    }
    
}
