package stackDriver;
import stack.*;

/**
 * Lab 3 problem 2
 * Test the Stack implementation
 * 
 * @author (sdb 
 * @version (Sep 2015)
 */
public class DriverLabStack
{
    
    public static void main()
    {   
System.out.println ("\n===============================================\nTesting stacks");
        StackADT <String> names = new Stack<String> ();
        names.push ("mary");
        names.push ("joe");
        names.push ("jim");
        names.push ("joe");
        
        System.out.println (names);
        System.out.println (names.peek());      // joe
        System.out.println (names.pop());       // joe
        System.out.println (names);             // mary joe jim
        
        StackADT <String> students = new Stack <String> ();
        students.push ("mary");
        students.push ("joe");
        if (names.equals (students))
            System.out.println ("Not correct");
        students.push ("jim");
        if (!names.equals (students))
            System.out.println ("Not correct");
        students.pop();
        students.push ("mary");
        if (names.equals (students))
            System.out.println ("Not correct");
        if (students.equals (names))
            System.out.println ("Not correct");
        
        names.clear();
        if (! names.isEmpty())
            System.out.println ("Not correct");
        }
        
}