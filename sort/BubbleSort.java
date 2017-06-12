package sort;
import list.*;

/**
 * List should be an ArrayList
 * 
 * @author Andrew Blanco 
 * @version 10/10/16
 */
@SuppressWarnings("unchecked")
public class BubbleSort<E extends Comparable> implements Sorter<E>
{
    List<E> list;
    
    public void sort(List<E> list)
    {
        this.list = list;
        
        for(int i = 0; i < list.size()-1; i++)
            for(int j=0; j< list.size() -i-1; j++)
                if(list.get(j).compareTo(list.get(j+1)) > 0)
                    swap(j, j+1);
        
    }
    
   private void swap(int x, int y)
   {
       E temp;
       temp = list.get(x);
       list.set(x, list.get(y));
       list.set(y, temp);
   }
    /** Sort the given list in descending order */ 
  public void   sortDescending(List <E> list) 
  {
  }
    
}
