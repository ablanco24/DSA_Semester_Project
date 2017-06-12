package queens;


/**
 * A position stores a row number and a column number
 * 
 * @author Andrew Blanco 
 * @version 12/9/16
 */
public class Position
{
    int row,col;
    
    public Position(int r, int c)
    {
        row = r;
        col = c;
    }
    
    public String toString()
    {
        return ("(" + row + "," + col + ")");
    }
    
    /**
     * @return true only if a queen at this position 
     * is attacking a queen at the other position
     */
    public boolean isAttacking(Position other)
    {
        return 
         row == other.row ||    //same row
         col == other.col ||    //same column
         row+col == other.row + other.col ||      //same major diagnal
         row-col == other.row - other.col;       //same mino diagnal
    }
    
    /**
     * @return true if obj is a Position and has the same
     * row and col as this Position
     */
    public boolean equals(Object obj)
    {
        if (! (obj instanceof Position))
            return false;
        Position other = (Position) obj;
        return row == other.row && col == other.col;
        
    }
}
