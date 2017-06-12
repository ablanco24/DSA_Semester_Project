package sort;
import list.*;

/**
 * Use quickSort algorithm to sort a list
 * Should be an ArrayList
 * 
 * @author Andrew Blanco
 * @version 10/14/16
 */
@SuppressWarnings("unchecked")
public class QuickSort<E extends Comparable> implements Sorter<E>
{
    List<E> list;
    
    public void sort(List<E> list)
    {
        this.list = list;
      
        qSort(0, list.size()-1);
    }
    
    /**
     * sort the portion of the list from positions start through end
     */
    private void qSort(int start, int end)
    {
        if((end-start) < 1)     //base case
            return;
        
        int p = partition(start, end);
        qSort(start, p-1);                  //left half
        qSort(p+1, end);
    }
    
    /**
     * Choose a pivot value, 
     * arrange the values so that the pivot valuues is greater than all values its left, 
     * and pivot value is less or equal to all values to its right 
     * 
     * @return position of pivot value
     */
    private int partition(int start, int end) //O(n)
    {
        int p = start;
       
        E pivotValue = list.get((end+start)/2);
        list.set((end+start)/2, list.get(start));
        
        
        for(int i = start+1; i <= end; i++)
        {
            
            if(list.get(i).compareTo(pivotValue) < 0)
            {
                
                list.set(p, list.get(i));
                p++;
                list.set(i, list.get(p));
            }
            
        }
        list.set(p, pivotValue);
        return p;
    }
    
     /** Sort the given list in descending order */ 
  public void   sortDescending(List <E> list) 
  {
  }
}
