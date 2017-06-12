 package list;
/**
 * A List which stores the values in an array
 * 
 * @author Andrew Blanco 
 * @version 9/9/16
 */

@SuppressWarnings("unchecked")
public class ArrayList<E> implements List<E>
{
    int size = 0;
    E[] values;
    E[] copy;
    //Allows client to define a length of the array
    public ArrayList(int cap)
    {
        values = (E[]) new Object[cap];
    }
    
    public ArrayList(List<E> copyList)
    {
        this();
        addAll(copyList);
    }
    
    //if the client doesn't pick a value, defaults to 10
    public ArrayList()
    {
        this(10);
    }
    
    public boolean isEmpty()
    {
        if(size == 0)
            return true;
        else
            return false;
    }
    
    public int size()
    {
        return size;
    }
    
    public void clear()
    {
        
        for (int i = 0; i < size; i++)
            values[i] = null;
        size = 0;
    }
    
    //adds to array
    //calls alloc to make a new array if array is filled
    public void add(int ndx, E value)
    {
        if (size == values.length)
        {
           alloc();
        }
        
        //inserts and shifts to the right in array
        for(int i=size; i > ndx; i--)
        {
            values[i] = values[i-1];
        }
        values[ndx] = value;
        size++;
    }
    
    //Create a bigger array
    //copy all values
    private void alloc()
    {
        E[] temp = (E[]) new Object[2 * values.length];
        for (int i=0; i < values.length; i++)
        {
            temp[i] = values[i];
        }
        values = temp;
    }
    
    //adds value to end of list
    public void add(E value)
    {
        add(size, value);
    }
    
    //gets value at certain position
    public E get(int ndx)
    {
        return values[ndx];
    }
    
    //@return old variable that was destroyed
    public E set(int ndx, E value)
    {
        E temp = values[ndx];
        values[ndx] = value;
        return temp;
    }
    
    //removes value from a given postion
    //@return value in position that was removed
    public E remove(int ndx)
    {
        E result = values[ndx];
        for(int i=ndx; i<size-1; i++)
        {
            values[i] = values[i+1];
        }
        size--;
        return result;
    }
    
    public int indexOf(Object obj)
    {
        return indexOf(obj, 0);
        /**
        int index = -1;
        boolean found = false;
        if (obj == null)
        {
            for(int i=0; i < size - 1 && !found; i++)
            {
                if(values[i] == obj)
                {
                    index = i;
                    found = true;
                }
            }
        }
        for(int i=0; i < size && !found; i++)
        {
            if(values[i].equals(obj))
            {
                index = i;
                found = true;
            }
        }
        
        return index;
        */
    }
    
    private int indexOf(Object obj, int start)
    {
        if (start >= size)
            return -1;      //not found
        if(values[start].equals(obj))
            return start;
        
        return indexOf(obj, start + 1);
        
    }
    
    /** 
     * @return true only if the given object is contained in this List 
     */
    public boolean contains (Object obj)
    {
        return indexOf(obj) != -1;
    }
    
    /** Remove the first occurrence of the given object from this List, if possible.
     *  @return true only if it was removed.
     */
    public boolean remove (Object obj)
    {
        int index = indexOf(obj);
        if(index == -1)
            return false;
        remove(index);
        return true;
       
 
    }
        
    /** @return the elements of this List as a String, with elements separated by commas,
     * enclosed in square brackets:[a,b,c]
    */
    public String toString( )
    {
        String listString = "[";
        for(int i = 0; i < size; i++)
        {
            if((i == size-1) && !(values[i] == null))
                listString = listString + values[i].toString() + "]";
            else if(!(values[i] == null))
                listString = listString + values[i].toString() + ",";
            if(values[i] == null)
            {
                if(i == size-1)
                    listString = listString + "null]";
                else 
                    listString = listString + "null,";
            }
        }
        
        if(listString.length() == 1)
            listString = listString + "]";
        
        return listString;
        
    }

    /** @return true only if this List is equal to the parameter, other */
    public boolean  equals (Object other)
    {
        if(!(other instanceof List))
            return false;
        List<E> temp;
        temp = (List) other;
        if(temp.size() != size)
            return false;
        Iterator<E> it = temp.iterator();
        Iterator<E> arrList = this.iterator();
        while(it.hasNext())
         {
            if(!(it.next().equals(arrList.next())))
                return false;
            
                   
        }
       return true;
    }
    
    public Iterator<E> iterator()
    {
        return new ArrayIterator(this);
    }
             
    /**  @return true if this List contains at least one null reference.  */
    public boolean containsNull()
    {
        return (contains(null));
        
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
        return new ArrayListIterator<E>(this);
    }
    
    public ListIterator<E> listIterator(int start)
    {
        return new ArrayListIterator<E>(this,start);
    }
}

