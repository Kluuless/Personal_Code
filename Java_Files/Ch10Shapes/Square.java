/**
 * Very easy Square
 * 
 * @author Mr. Funk and Kyle Luu
 * @version 2.0
 */
public class Square implements Shape, Comparable<Shape>
{
    // instance variables - replace the example below with your own
    private double side;
    private static final double EPSILON = 1E-14;

    /**
     * Constructor for objects of class Circle
     */
    public Square(double side)
    {
        this.side = side;
    }

    /**
     * @return  The area of the square
     */
    public double getArea()
    {
        return side*side;
    }

    /**
     * @return  The diagonal of the square
     */
    public double getDiagonal()
    {
        return side*Math.sqrt(2.0);
    }
    
    /**
     * @return  The perimeter of the square
     */
    public double getPerimeter()
    {
        return 4 * side;
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
        else if (this.getArea() - other.getArea() > EPSILON)
            return 1;
        else
            return 0;
    }

    /**
     * @param   Another shape
     * 
     * @return  True if the other shape is a square and has the same side length
     */
    public boolean equals(Object obj)
    {
        if (obj instanceof Square)
        {
            if (((Square)obj).side == this.side)
            {
                return true;
            }
        }
        return false;
    }
}
