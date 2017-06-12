package sortDriver;
import sort.*;
import list.*;
/**
 * Write a description of class Lab6Driver here.
 * 
 * @author Andrew Blanco
 * @version (a version number or a date)
 */
public class Lab6Driver
{
   public static void main()
   {
   List<Integer> numbers = new ArrayList<Integer> ();
   Sorter<Integer> sorter = new QuickSort <Integer> ();
    
   
   System.out.println("testing QuickSort");
   numbers.add(4);
   numbers.add(5);
   numbers.add(6);
   numbers.add(1);
   numbers.add(2);
   numbers.add(3);
   
   System.out.println ("Before sorting:");
        System.out.println (numbers);
        sorter.sort ( numbers);
        System.out.println ("After sorting:");
        System.out.println (numbers);
    }
}
