package tree;


/**
 * Abstract class Expr - Arithmetic Expression 
 * 
 * @author Andrew Blanco
 * @version (version number or date here)
 */
public abstract class Expr
{
    Expr left, right;
    
    Expr()
    {
    }
    
    public Expr(Expr left, Expr right)
    {
        this.left = left;
        this.right = right;
    }
    
    /**
     * @return a simplified Expr, equivalent to this Expr
     */
    public abstract Expr simplify();
    
    /**
     * @return the value of this Expr, as an int
     * @throws InvalidArgumentException if this Expr cannot be evaluated
     */
    public abstract int eval();
    
    /**
     * @return true if this Expr equal obj
     */
    public abstract boolean equals(Object obj);
}
