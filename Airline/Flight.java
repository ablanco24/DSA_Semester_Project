package Airline;


/**
 * Write a description of class Flight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flight
{
    Airport origin, dest;
    
    public Flight(Airport origin, Airport dest)
    {
        this.origin = origin;
        this.dest = dest;
    }
    
    public String toString()
    {
        return ("\n" + origin + " --> " + dest);
    }

}
