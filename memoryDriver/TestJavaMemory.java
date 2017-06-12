package memoryDriver;
import list.*;

/**
 * Test the meomry limitations of the Java runtime system.
 * 
 * @author Andrew Blanco
 * @version 12/5/16
 */
public class TestJavaMemory
{
    static final int MAX = (int) 1e5;
    static List <char[]> list = new ArrayList <char[]> ();
    
    public static void main()
    {
        char[] buffer;
        int size = 2;
        
        for(int i=0; i<100; i++)
        {
            System.out.println(size);
            buffer = new char[size];
            size *= 2;
        }
    }
    
    public static void testMemory()
    {
        list = new ArrayList<char[]> ();
        for(int i=0; i<1000; i++)
        {
            System.out.println(i);
            list.add (new char[MAX]);
        }
        char[] buffer = new char[MAX*10];
    }
}
