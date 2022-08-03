/**
 * Very easy Circle
 * 
 * @author Mr. Funk and Kyle Luu
 * @version 2.0
 */
public class Circle implements Shape, Comparable<Shape>
{
    private double radius;
    private static final double EPSILON = 1E-14;

    /**
     * Constructor for objects of class Circle
     */
    public Circle(double radius)
    {
        this.radius = radius;
    }

    /**
     * @return  The area of the circle
     */
    public double getArea()
    {
        return radius*radius*Math.PI; //area of a circle is equal to pi * radius^2
    }
    
    /**
     * @return  The perimeter of the circle
     */
    public double getPerimeter()
    {
        return Math.PI * radius * 2; //perimeter of a circle is equal to 2 * pi * radius
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
     * @return  True if the other shape is a circle and has the same radius
     */
    public boolean equals(Object obj)
    {
        if (obj instanceof Circle)
        {
            if (((Circle)obj).radius == this.radius)
            {
                return true;
            }
        }
        return false;
    }
}
