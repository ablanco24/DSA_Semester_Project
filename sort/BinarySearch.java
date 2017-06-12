package sort;
import list.*;

/**
 * Search a sorted list for a given target. 
 * SHould be an ArrayList
 * 
 * @author Andrew Blanco 
 * @version 10/17
 */
@SuppressWarnings("unchecked")
public class BinarySearch<E extends Comparable>
{
    List<E> list;
    E target;
    
    public BinarySearch(List<E> list)
    {
        this.list = list;
    }
    
    /**
     * @return the position in the list of the target, or -1 if not found
     */
    public int search(E target)
    {
        this.target = target;
        int lo = 0;
        int hi = list.size() - 1;
        
        
        
        while (lo <= hi)
        {
            
           
            int mid = ((hi+lo) /2);
            int cmp = target.compareTo(list.get(mid));
            if(cmp == 0)
                return mid;
            if(cmp < 0)
                hi = mid - 1;
            if(cmp > 0)
                lo = mid + 1;
            
        }
        return -1;
    }
    
    /**
    private int binSrch(int lo, int hi)
    {
        if(lo > hi)         //not found
            return -1;
        int mid = (lo + hi) /2;
        int cmp = target.compareTo(list.get(mid));
        if(cmp == 0)
            return mid;
        if(cmp < 0)
            return binSrch(lo, mid - 1);
        return binSrch(mid+1, hi);
    }
    */
}
