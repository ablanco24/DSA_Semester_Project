package hash;
import list.*;

/**
 * A table which allows for quick access to data. 
 * Duplicates are permitted.
 * E should define e
 * quals(object)
 * hashCode()
 * 
 * Adjust table size for efficecy
 * 
 * @author Andrew Blanco
 * @version 11/7/16
 */
public class HashTable<E>
{
   List<List<E>> lists = new ArrayList<List<E>>(); 
   int keyCount = 0; //size
   static  final int MAX = 10;
   int maxList = 0;
   
   public HashTable()
   {
       this(10); //default 10
   }
   
   public HashTable(int capacity)
   {
       for(int i = 0; i < capacity; i++)
            lists.add(new LinkedList<E>());
   }
   
   /**
    * @return true if obj is in this HashTable
    */
   public boolean containsKey(Object obj)
   {       
           int code = getCode(obj);
           return lists.get(code).contains(obj);
       
   }
   
   /**
    * put the given key into this HashTable
    * Rebuild the table if longet list > MAX
    */
   public void put(E key)
   {
       int code = getCode(key);
       List<E> list = lists.get(code);
       list.add(key);
       keyCount++;
       if(list.size() > maxList)
           maxList = list.size();
       rehash();
        
    
    }
    
    /**
     * Rebuild the hashTable, if necessary
     */
    private void rehash()
    {
        if(maxList <= MAX)  //rebuild?
            return;
        List<List<E>> table = new ArrayList<List<E>>();
        for(int i=0; i< lists.size()*2; i++)
            table.add(new LinkedList<E>());
            
        Iterator<E> itty = iterator();
        
        while(itty.hasNext())
        {
            E value = itty.next();
            int code = Math.abs(value.hashCode());
            code = code % table.size();
            List<E> list = table.get(code);
            list.add(value);
            if(list.size() > maxList)
                maxList = list.size();
        }
        lists = table;
    }
   
   /**
    * Add the given value to this HashTable
    
   public void put(E value)
   {
       int code = getCode(value);
       lists.get(code).add(value);
       keyCount++;
   }
   */
   
   //@return a valid index to listss
   private int getCode(Object obj)
   {
       int code = obj.hashCode();
       code = Math.abs(code); // might be negative
       code = code % lists.size(); //0..size of ArrayList
       return code;
   }
   
   /**
    * @return given value from this HashTable, or null if not found
    * 
    */
   public E get(E value)
   {
       int code = getCode(value);
       List<E> list = lists.get(code);
       int ndx = list.indexOf(value);
       if(ndx < 0)
            return null;
       return list.get(ndx);     
   }
   
   /**
    * Remove the given Object from this HashTable, if possible
    * @return true if it was removed
    */
   public boolean remove(Object obj)
   {
       int code = getCode(obj);
       if(lists.get(code).remove(obj))
       {
           keyCount--;
           return true;
       }
       return false;
   }
   
   public Iterator<E> iterator()
   {
       return new TableIterator<E>(this);
   }
   
   /** @return the number of keys in this HashTable */
   public int size()
   {
       return keyCount;
   }
   
   /** Make this HashTable empty */
   public void clear()
   {
        lists.clear();
        keyCount = 0;
   }
   
   /** @return true if this HashTable is empty */
   public boolean isEmpty()
   {
       return keyCount == 0;
   }

   
}

