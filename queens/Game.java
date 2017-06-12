package queens;


/**
 * Solve the n Queens problem.
 * 
 * @author Andrew Blanco
 * @version 12/9/16
 */
public class Game
{
    static final int SIZE = 18;      //Board size, number of queens
    public static void main()
    {
        Game game = new Game();
        System.out.println("Solution is: \n" + 
            game.placeQueens(0, new Board()));
            
    }
    
    /**
     * @return the Board created when queens have been safely placed 
     * in cols col -- SIZE-1, or null if not possible
     * Pre: Queens have been safely placed on Board b in cols 0..col-1.
     */
    private Board placeQueens(int col, Board b)
    {
        Position p;
        Board result;
        for(int row=0; row<SIZE; row++)
        {
            p = new Position(row,col);  //try placing a queen at p, on Board b
            result = new Board(b);      //copy of given Board
            result.addQueen(p);         //Put queen on result Board
            if(result.ok())
                if(col < SIZE -1)       //At last col?
                {
                    result = placeQueens(col+1, result);
                    if(result != null)
                        return result;
                }    
                else
                    return result;
        }
        return null;       //no safe place for a queen
    }
    

}
