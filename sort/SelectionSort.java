package sort;
import list.*;

/**
 * Implement selection sort algorithm
 * The list should be an ArrayList
 * 
 * @author Andrew Blanco
 * @version 10/10/16
 */
@SuppressWarnings("unchecked")
public class SelectionSort<E extends Comparable> implements Sorter<E>
{
   List<E> list;
   public void sort(List<E> list)
   {
       this.list = list;
       for(int start = 0; start < list.size() - 1; start++)
       {
           swap(start, posSmallest(start));
       }
   }
   
   private int posSmallest(int start)
   {
       int result = start;
       for(int i = start + 1; i < list.size(); i++)
           if(list.get(i).compareTo(list.get(result)) < 0)
                result = i;
       return result;
       
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
