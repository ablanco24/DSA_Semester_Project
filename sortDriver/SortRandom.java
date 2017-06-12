package sortDriver;
import list.*;
import sort.*;
import java.util.Random;

/**
 * Test the sort algorithm for a list of students
 * 
 * @author (sdb) 
 * @version (Oct 2016)
 */
public class SortRandom
{
   
    public static void main()
    {   List <Integer> numbers = new LinkedList <Integer> ();
        Random rand = new Random();     // Random number generator
        
        for (int i=0; i<2000; i++)
            numbers.add (rand.nextInt());
        
        Sorter <Integer> sorter = new BubbleSortLinked <Integer> ();
        sorter.sort(numbers);
        
        // Show the first 20 values in the List
        Iterator<Integer> itty = numbers.iterator();
        for (int i=0; i<20; i++)
            System.out.println (itty.next() + " ");
            
        
    }
        
}