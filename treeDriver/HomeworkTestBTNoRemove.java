package treeDriver;

import tree.*;
import list.*;

/**
 * Test the binary search tree implementation.
 * 
 * @author (sdb) 
 * @version (Oct 2015)
 */
public class HomeworkTestBTNoRemove
{
    
    public static void main( )
    {
    BinaryTree <String> kids = new EmptyBinarySearchTree <String> ();
    
    if (!kids.isEmpty ())
        System.out.println ("Not correct 1");
    
    kids = kids.add ("kimmy");
    kids = kids.add ("jimmy");
    kids = kids.add ("susie");
    kids = kids.add ("joe");
    kids = kids.add ("sue");

     if (!(kids.containsKey ("sue")))
        System.err.println ("Not correct");
     if (kids.containsKey ("jim"))
        System.err.println ("Not correct");
     if (!(kids.get ("susie").equals ("susie")))
        System.err.println ("Not correct");
     if ((kids.get ("joseph") != null))
        System.err.println ("Not correct");
      
    }
}