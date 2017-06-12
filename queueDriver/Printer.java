package queueDriver;

import queue.*;

/**
 * A Printer has a speed, in blocks of printing per step, and a queue of Docs to be printed
 * 
 * @author (sdb) 
 */
public class Printer
{
    private int speed;      // speed of this printer, blocks per step
    private QueueADT <Doc> docs;    // Queue of documents waiting to be printed
    private String id;      // name of this Printer
    private int num = 0;
    
    /**
     * Constructor for objects of class Printer
     */
    public Printer(int speed, String id)
    {
        this.speed = speed;
        //docs = new Queue <Doc> ();            
        docs = new PriorityQueue<Doc>(); 
        this.id = id;
        
    }
    
    /** Add a document to this printer's queue 
      * Display a pertinent message.
    */
    public void add (Doc doc)
    {    
        docs.add(doc);
        System.out.println("\t" + doc.toString() + toString());
        
    }
    
    /** Print several blocks, if necessary, determined by this printer's speed
      * Report when a document is finished printing.
     *  
     */
    public void print()
    {  if(!docs.isEmpty())
       {
        Doc doc = docs.peek();
        
         
        num += speed;
        
        
        if(num >= doc.size())
        {
           
           docs.remove();
           System.out.println("\tPrint task completed on " + id + " for: " + doc);
           num = 0;
        }
        
        
       }
    }
    
    /** @return the number of documents in this Printer's queue */
    public int size()
    {   return docs.size();  }
    
    public String toString()
    {   return id + ", speed: " + speed + ", docs in queue: " + size();  }
                         
    
}