package sort;
import list.*;

/**
 * Arrange the items in a list in ascending order
 * 
 * @author Andrew Blanco
 * @version 10/10
 */
public interface Sorter<E extends Comparable>
{
   void sort(List<E> list);
   
    /** Sort the given list in descending order */ 
  public void   sortDescending(List <E> list) ;
}
