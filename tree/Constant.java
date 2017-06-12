package tree;


/**
 * An Expr which has a fixed value
 * 
 * @author Andrew Blanco 
 * @version 10/31/16
 */
public class Constant extends Expr
{
    int value;
    public Constant(int value)
    {
        this.value = value;
    }
    
    public Expr simplify()
    {
        return this;
    }
    
    public int eval()
    {
        return value;
    }
    
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Constant))
            return false;
        
        Constant c = (Constant) obj;
        return value == c.value;
        
    }
    
    public String toString()
    {
        Integer val = value; 
        
        return val.toString(value);
    }
}
