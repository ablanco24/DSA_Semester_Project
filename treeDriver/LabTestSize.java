package treeDriver;

import tree.*;
import list.*;

/**
 * Test the binary search tree implementation.
 * 
 * @author (sdb) 
 * @version (Oct 2016)
 */
public class LabTestSize
{
    
    public static void main( )
    {
    BinaryTree <String> kids = new EmptyBinarySearchTree <String> ();
    
    if (!kids.isEmpty ())
        System.out.println ("Not correct 1");
    
    if (kids.size() != 0)
        System.err.println ("Error, possibly in size()");
    
    kids = kids.add ("kimmy");
    if (kids.size() != 1)
        System.err.println ("Error, possibly in size()");
    kids = kids.add ("jimmy");
    if (kids.size() != 2)
        System.err.println ("Error, possibly in size()");
    kids = kids.add ("susie");
    if (kids.size() != 3)
        System.err.println ("Error, possibly in size()");
    kids = kids.add ("joe");
    if (kids.size() != 4)
        System.err.println ("Error, possibly in size()");
    kids = kids.add ("sue");
    if (kids.size() != 5)
        System.err.println ("Error, possibly in size()");
    kids = kids.add ("joan");
    if (kids.size() != 6)
        System.err.println ("Error, possibly in size()");
    kids = kids.add ("joanie");
    if (kids.size() != 7)
        System.err.println ("Error, possibly in size()");
        
    System.out.println ("Testing completed");
      
    }
}