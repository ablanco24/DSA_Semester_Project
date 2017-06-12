package hashDriver;


/**
 * Write a description of class Hometown here.
 * 
 * @author Anrdew Blanco 
 * @version 11/17/16
 */
@SuppressWarnings("unchecked")
public class HomeTown<E>
{
    String name, state;
    String zip;
    
    public HomeTown()
    {
    }
    
    public HomeTown(String name, String state, String zip)
    {
        this.name = name;
        this.state = state;
        this.zip = zip;
    }
    
    /**
     * @return true if the two zipcodes are equal
     */
    public boolean equals(Object obj)
    {
        if(obj instanceof HomeTown)
        {
            HomeTown<E> home = (HomeTown<E>) obj;
            return zip.equals(home.zip);
        }
        return false;
    }
    
    public int hashCode()
    {
        int code = 17;
        code = code * 31 + zip.hashCode();
        return code;
    }
    
    public String toString()
    {
        return (name + ", " + state + " " + zip);
    }
}
