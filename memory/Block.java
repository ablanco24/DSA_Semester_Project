package memory;


/**
 * A Block represents a "chunk" 
 * of contiguous memory bytes
 * 
 * @author Andrew Blanco 
 * @version 12/5/16
 */
public class Block
{
    int start;      //initial (byte) address
    int size;       //in bytes
    
    public Block(int start, int size)
    {
        this.start = start;
        this.size = size;
    }
    
    public String toString()
    {
        return ("(" + start + "," + ((start + size)-1) + ")");
    }
}
