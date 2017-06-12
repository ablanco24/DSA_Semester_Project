package treeDriver;

import tree.*;
import list.*;

/**
 * Test the binary search tree implementation.
 * 
 * @author (sdb) 
 * @version (Oct 2015)
 */
public class HomeworkTestBTNoTraversals
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

      kids.remove ("kimmy");
      if (kids.containsKey ("kimmy"))
        System.err.println ("Error in remove");
      if (!kids.containsKey ("joe"))
        System.err.println ("joe should be found in the tree");
      kids.add ("kimmy");
      if (kids.get("kimmy") == null)
        System.err.println ("kimmy not found");
        
      // understand why the following prints "kimmy"
      System.out.println (kids.getLeft().getRight().getRight().getValue());
      
    }
}