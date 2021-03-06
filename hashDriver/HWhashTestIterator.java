package hashDriver;
import hash.*;
import list.*;


/**
 * Test the HashTable
 * 
 * @author (sdb) 
 * @version (Mar 2015)
 */
public class HWhashTestIterator
{
    public static void main()
    {   
        HashTable <Integer> nums = new HashTable <Integer> (3);
        
        for (int i=0; i<20; i = i + 2)
                nums.put(i);
                 
        System.out.println ("Size of the hash table is " + nums.size());
        if (nums.isEmpty())
            System.err.println ("Not correct");
            
        System.out.println (nums.get(16));      // should be 16
        System.out.println (nums.get(15));      // should be null
        
        if (!nums.remove(16))
            System.err.println ("Not correct");
        if (nums.remove(16))
            System.err.println ("Not correct");
        System.out.println ("Size of the hash table is " + nums.size());
        
           Iterator <Integer> itty = nums.iterator();
       while (itty.hasNext())
            {   if (itty.next() > 10)
                    itty.remove();
            }
       System.out.println ("Size of the hash table is " + nums.size());
       itty = nums.iterator();
       while (itty.hasNext())
               System.out.println (itty.next());    // 0,6,4,10,2,8  on separate lines
               
        nums.clear();
        if (! nums.isEmpty())
            System.err.println ("Not correct");
            
       nums.put (0);
       if (nums.get(18) != null)
            System.err.println ("Not correct");
   
}
  
}