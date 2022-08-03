
/**
 * Represents a parallelogram
 * 
 * @author Kyle Luu 
 * @version Kyle Luu
 */
public class Parallelogram implements Shape, Comparable<Shape>
{
    /**
     * INSTANCE VARIABLES
     */
    private double base;
    private double height;
    private double side;
    private static final double EPSILON = 1E-14;

    /**
     * Constructor for objects of class Parallelogram
     */
    public Parallelogram(double base, double height, double side)
    {
        this.base = base;
        this.height = height;
        this.side = side;
    }

    /**
     * @return The area of the parallelogram
     */
    public double getArea()
    {
        return (base * height);
    }

    /**
     * @return  The perimeter of the parallelogram
     */
    public double getPerimeter()
    {
        return 2 * side + 2 * base;
    }

    /**
     * @param   Another shape
     * 
     * @return  -1 if area is less than object's, 1 if area is more, or 0 if areas are equal
     */
    public int compareTo(Shape other)
    {   
        if (this.getArea() - other.getArea() < (-1) * EPSILON)
            return -1;
        else if (this.getArea() - other.getArea() > (-1) * EPSILON)
            return 1;
        else
            return 0;
    }

    /**
     * @param   Another shape
     * 
     * @return  True if the side, base, and height are the same
     */
    public boolean equals(Object obj)
    {
        if (!(obj instanceof Parallelogram))
        {    return false;  }
        else
        {   
            Parallelogram theObj = (Parallelogram)obj;
            
            if (theObj.side == this.side && theObj.base == this.side && theObj.height == this.height)
            {
                return true; //EPSILON not needed: 
            }                //the base, height, and side aren't calculations
            else
            {
                return false;
            }
        }
    }
}
