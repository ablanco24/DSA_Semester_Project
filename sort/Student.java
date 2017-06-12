package sort;


/**
 * Write a description of class Student here.
 * 
 * @author Andrew Blanco 
 * @version 10/13/16
 */
@SuppressWarnings("unchecked")
public class Student<E> implements Comparable
{
    String name;
    String ssn;
    float gpa = 0;
    /**
     * Constructor for objects of class Student
     */
    public Student(String name, String ssn)
    {
        this.name = name;
        this.ssn = ssn;
        
    }
    
    public int compareTo(Object student)
    {
         Student<E> temp = (Student) student;
         if(this.name.equals(temp.name))
            return this.ssn.compareTo(temp.ssn);
         return this.name.compareTo(temp.name);
    }
    
    public String toString()
    {
        return ("[" + name + "," + ssn + "," + gpa + "]");
    }

   
}
