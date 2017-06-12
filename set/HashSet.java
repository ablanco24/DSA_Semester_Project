package set;
import hash.*;
import list.Iterator;

/**
 * Implement Set with HashTable
 * 
 * @author Andrew Blanco
 * @version 11/14/16
 */
@SuppressWarnings("unchecked")
public class HashSet<E> implements Set<E>
{
    HashTable<E> table = new HashTable<E>();
    
    public boolean add(E value)
    {
        if(contains(value))
            return false;
        table.put(value);
        return true;
    }
    
    public boolean contains(Object obj)
    {
        return table.containsKey(obj);
    }
    
    public boolean remove(Object obj)
    {
        return table.remove(obj);
    }
    
    public Iterator<E> iterator()
    {
        return table.iterator();
    }
    
    /** @return the number of values in this Set */
    public int size()
    {
        return table.size();
    }

    /** @return true if this Set is empty  */
    public boolean isEmpty()
    {
        return table.isEmpty();
    }

    /** Make this Set an empty Set */
    public void clear()
    {
        table = new HashTable<E>();
    }
    
     /** @return the elements of this Set as a String */ 
     public String toString()
     {
        String set = "[";
        int maxSize = size() - 1;
        int bot = 0;
        
        Iterator<E> itty = iterator();
        while(itty.hasNext())
        {
            if(bot < maxSize)
                set = set + itty.next() + ",";
            else
                set = set + itty.next();
            bot++;
        }
        set = set + "]";
        
        return set;
         
     }
 
     /** @return true if obj is a Set and all the values in this Set are in the other Set, 
       and all the values in the other Set are in this Set */ 
     public boolean equals (Object obj)
     {
         try
           {
               Set<E> temp = (Set<E>) obj;
               
               
               if(!(temp.size() == size()))
                    return false;
                    
               Iterator<E> itty = iterator();
               while(itty.hasNext())
               {
                   if(!(temp.contains(itty.next())))
                        return false;
               }
               return true;
           }
           catch(ClassCastException e)
           {
               return false;
           }
           
     
     }
     
     /** @return a Set which is the intersection of this Set with other */
     public Set <E> intersection  (Set < E> other)
     {
         Set<E> result;
         result = new HashSet<E>();
         Iterator<E> itty = iterator();
         while(itty.hasNext())
         {
             E temp = itty.next();
             if(other.contains(temp))
                result.add(temp);
         }
         
         return result;
         
     }
   
}
