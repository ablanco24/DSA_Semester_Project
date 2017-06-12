package Airline;
import list.*;
import map.*;
import java.io.*;
import java.util.Scanner;
import queue.*;
import stack.*;
/**
 * Manage network of airline flights
 * Find a path, not necessarily shortest,
 * From an Airport to another Airport.
 * Input is text file of direct flights
 * 
 * @author Andrew Blanco 
 * @version 12/2/16
 */
public class Airline  
{
    static List<Flight> flights;   //firect flights
    static Map <String, Airport> map;  //keys are airport names
                                //values are airports.
    public static void main()
    {
        Airline airline = new Airline();
        airline.getFlights();
        
       // System.out.println("Flights are " + airline.flights);
       
        System.out.println("Path from CVG to Paris is " + airline.path("CVG","Paris"));
        map.get("PHL").isHub = true;
        System.out.println("Path from CVG to Paris is (PHL is a hub)" + airline.path("CVG","Paris"));
    }
    
    /**
     * Read the direct flights from a text file,
     * flights.txt into a list of flights, and put them
     * into the map.
     */
    private void getFlights()
    {
        File inFile  = new File ("flights.txt");
        map = new HashMap<String, Airport> ();
        flights = new ArrayList<Flight> ();
        
        try
        {
            // Use scanner to read lines from the input file
            Scanner scanner = new Scanner(inFile);
            String flight, origin, dest;
            Airport o,d;
            while(scanner.hasNextLine())
            {
                flight = scanner.nextLine();        //read entire line
                origin = flight.split(" ")[0];      //space is the delimiter
                dest = flight.split(" ")[1];
                if(map.containsKey(origin))
                o = map.get(origin);            //airport
                else
                {
                    o = new Airport (origin);
                    map.put(origin, o);
                }
                if(map.containsKey(dest))
                    d = map.get(dest);
                else
                {
                    d = new Airport (dest);
                    map.put(dest, d);
                }
            
                flights.add(new Flight(o,d));
            }
        }
        catch (FileNotFoundException fnfe)
        {
            System.err.println("File not found " + fnfe);
        }
    }
    
      /** 
      * Find a path from origin to dest, return it as a list
      * of airports. Empty list if no path is foun
      */
       private Stack <Airport> path(String origin, String dest)
       {
           Airport o = map.get(origin);
           Airport d = map.get(dest);
           Stack<Airport> result = path(o,d);
           clearAirports();     //clear visited flages
           return result;
       }
    /**   
    private List<Airport> path (Airport origin, Airport dest)
    {
        List<Airport> result = new LinkedList<Airport>();
        origin.visited = true;      //dont visit this one again
        if(origin.equals(dest)) //base case
        {
            result.add(origin);
            return result;
        }
        int size = 0;
        Airport port;
        PriorityQueue<Airport> pFlights = getDirect(origin);
        while(!pFlights.isEmpty())
        {
            port = pFlights.remove();
            result = path(port,dest);
            if(result.size() > 0)
            {
                result.add(0,origin);
                return result;
            }
        }
        return result;  //no path found
    }
    */
    private Stack<Airport> path (Airport origin, Airport dest)
    {
        
        origin.visited = true;
        Stack<Airport> airports = new Stack<Airport>();
        airports.push(origin);
        Airport port = origin;
        while(!airports.isEmpty())
        {
            PriorityQueue<Airport> pFlights = getDirect(port);
            if(pFlights.isEmpty())
               airports.pop();
            if(airports.isEmpty())
                return airports;
            
            port = pFlights.remove();
            port.visited = true;
            airports.push(port);
            if(port.equals(dest))
                return airports;
        }
        return airports;  //no path found
    }
    
    private void clearAirports()
    {
        Iterator<Flight> itty = flights.iterator();
        while(itty.hasNext())
        {
            Flight temp = itty.next();
            temp.origin.visited = false;
            temp.dest.visited = false;
        }
    }
    
    private PriorityQueue<Airport> getDirect(Airport origin)
    {
        Iterator<Flight> itty = flights.iterator();
        PriorityQueue<Airport> result = new PriorityQueue<Airport>();
        while(itty.hasNext())
        {
            Flight temp = itty.next();
            if(temp.origin.equals(origin) && temp.dest.visited == false)
            {
                result.add(temp.dest);
            }
        }
        return result;
    }
    

}