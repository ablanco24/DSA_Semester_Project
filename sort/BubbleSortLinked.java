package sort;
import list.*;

/**
 * Write a description of class BubbleSortLinked here.
 * 
 * @author Andrew Blanco
 * @version 10/14/16
 */
@SuppressWarnings("unchecked")
public class BubbleSortLinked<E extends Comparable> implements Sorter<E>
{
   List<E> list;
   E left, right;
   ListIterator<E> itty;
   
   public void sort(List<E> list)
   {
       for(int i = 0; i < list.size() - 1; i++)
       {
           itty = list.listIterator();
           left = itty.next();
           right = itty.next();
           for(int j=0; j < list.size()-i-1; j++)
           {
               if(left.compareTo(right) <= 0)
               {
                    left = right;            
               }
               else //swap is needed
               {
                   itty.remove();
                   itty.previous();
                   itty.add(right);
                   itty.next();    
               }
               right = itty.next();
           }
           
       }
   }
    /** Sort the given list in descending order */ 
  public void   sortDescending(List <E> list) 
  {
  }
}
