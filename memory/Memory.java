package memory;
import list.*;

/**
 * Simulate allocation of memory
 * 
 * @author Andrew Blanco 
 * @version 12/5/16
 */
public class Memory
{
    List<Block> free = new LinkedList<Block>();
    List<Block> allocated = new LinkedList<Block>();
    
    static final int MAX = 4096;        //size of all memory
    
    public Memory()
    {
        free.add(new Block(0,MAX));
        //initially, all of memory is available
    }
    
    /**
     * Find memory of the given size, if available
     * @return its start address or -1 if not available
     */
    public int allocate(int size)
    {
        //find a Block of the given size, on the free list.
        Block b, newBlock;
        Iterator<Block> itty = free.iterator();
        int smallest = 2170511;
        while(itty.hasNext())
        {
            b = itty.next(); //free block
            
            if(b.size < smallest)
                smallest = b.size;
            if((b.size >= size) && (b.size == smallest))  //big enough
            {
                newBlock = new Block(b.start,size);
                allocated.add(newBlock);
                b.start += size;
                b.size -= size;
                if(b.size == 0) 
                    itty.remove();
                return newBlock.start;
            }
            
        }
        return -1;
    }
    
    /**
     * Free the block at given start address.
     * @return true if ok,false if no such block allocated
     */
    public boolean free(int start)
    {
        Block b;
        Iterator<Block> itty = allocated.iterator();
        Iterator<Block> itty2 = free.iterator();
        while(itty.hasNext())
        {
            b = itty.next();
            if(b.start == start)
            {
                itty.remove();
                Block temp = new Block(b.start,b.size);
                while(itty2.hasNext())
                {
                    Block it = itty2.next();
                    if((it.start + it.size) == b.start)     //adjecent left
                    {
                        temp = new Block(it.start, (it.size + temp.size));
                        itty2.remove();
                    }
                    if((b.size + b.start) == it.start)      //adjacent right
                    {
                        temp = new Block(temp.start, (temp.size + it.size));
                        itty2.remove();
                    }
                   
                }
                free.add(temp);
                return true;
            }
        }
        return false;
    }
    
    public String toString()
    {
        return ("free:   " + free + "\nalloc:    " + allocated);
    }
   
}
