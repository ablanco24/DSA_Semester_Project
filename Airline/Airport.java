package Airline;


/**
 * Write a description of class Airport here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Airport implements Comparable<Airport>
{
   String name;
   boolean visited = false;     //true if this Airport has been visited recently
   boolean isHub = false;                
   
   public Airport(String name)
   {
       this.name = name;
   }
   
   public Airport(String name, boolean isHub)
   {
       this.name = name;
       this.isHub = isHub;
   }
   
   public boolean equals(Object obj)
   {
       if(! (obj instanceof Airport))
            return false;
       Airport other = (Airport) obj;
       return name.equals(other.name);
       
   }
   
   public void makeHub()
   {
       isHub = true;
   }
   
   public int compareTo(Airport port)
   {
       
       if(isHub == true && port.isHub == false)
            return 1;
       if(isHub == true && port.isHub == true)
            return 0;
       if(isHub == false && port.isHub == true)
            return -1;
       return 0;
   }
   
   public String toString()
   {
       if(isHub)
            return (name +".h");
       return name;
   }
}
