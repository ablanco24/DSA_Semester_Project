package sortDriver;
import sort.*;
import list.*;
import java.util.Random;

/**
 * Test the binary search algorithm.
 * 
 * @author (sdb) 
 * @version (Mar 2015)
 */
@SuppressWarnings("unchecked")
public class HomeworkTestSearch
{
    static ArrayList <Integer> grades = new ArrayList <Integer> ();
    static Random rand = new Random();
    static int MAX = 10;
    
    public static void main ()
    {
        
    SelectionSort <Integer> selection = new SelectionSort ( );
    BubbleSort <Integer> bubble = new BubbleSort ( );
    QuickSort <Integer> quick = new QuickSort ();
  

// Choose one of the following sorting algorithms, and uncomment that line:
//    testSort (selection);
//     testSort (bubble);
     testSort (quick);

    BinarySearch<Integer> searcher = new BinarySearch<Integer> (grades);
    for (int i=0; i<MAX; i++)
        {   int target = rand.nextInt(MAX*3);
            System.out.println ("target " + target + " found at position " +
                searcher.search (target));
        }
        
    
    }
    
    private static void testSort (Sorter<Integer> sorter)
    {   init();
        
        System.out.println (sorter.getClass().toString());
        System.out.println (grades);
        sorter.sort(grades);
        System.out.println (grades + "\n");
    
    }
    
    private static void init()
    {   grades.clear(); 
        for (int i=0; i<MAX; i++)
            grades.add (rand.nextInt(MAX*3));
    }
}