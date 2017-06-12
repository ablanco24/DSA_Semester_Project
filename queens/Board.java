package queens;
import list.*;

/**
 * A chess BOard can have 0 or more queens in 
 * different positions
 * 
 * Board is a list of positions that queens are at
 * 
 * @author Andrew Blanco
 * @version 12/9/16
 */
public class Board
{
    List<Position> queens;      //Positions on this Board which have a queen
    
    public Board()
    {
        queens = new LinkedList<Position>();
    }
    
    //Copy constructor
    public Board (Board b)
    {
        queens = new LinkedList<Position>(b.queens);
    }
    
    //Add a queen at the given position on this Board
    public void addQueen(Position p)
    {
        queens.add(p);
    }
    
    //@return true only if no queens are attacking any other 
    //queens on this Board
    public boolean ok()
    {
        Position p, other;
        Iterator<Position> itty1 = queens.iterator(),
                           itty2;
        while (itty1.hasNext())
        {
            itty2 = queens.iterator();
            p = itty1.next();
            while (itty2.hasNext())
            {
                other = itty2.next();
                if (! p.equals(other))
                    if(p.isAttacking(other))
                        return false;       //two queens are attacking
            }
            
        }
        return true;        //no queens attacking any other queens
    }
    
    public String toString()
    {
        String result = queens.toString() + "\n";
        //Make it look like a chess board
        for(int row = 0; row<Game.SIZE; row++)
        {
            for(int col=0; col<Game.SIZE; col++)
            {
                if(queens.contains (new Position (row,col)))
                    result = result + "Q ";
                else
                    result = result +". ";      //No queens here
            }
            result = result +"\n";      //End of a row
        }
        
        return result;
    }
}
