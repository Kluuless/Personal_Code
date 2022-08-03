
/**
 * Shape - has a getArea() and getPerimeter() method
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public interface Shape
{
    /**
     * getArea
     * 
     * @return        the area of the shape 
     */
    double getArea();
    
    /**
     * getPerimeter
     * 
     * @return        the perimeter of the shape
     */
    double getPerimeter();
}

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

import java.util.Scanner;

/**
 * Simulation
 * 
 * @author Mr Funk & Kyle Luu
 * @version 2.0
 */
public class Simulation
{
    public static void main(String[] args)
    {
        System.out.print("Select circle \"c\", square \"s\", or parallelogram \"p\". ");
        Scanner in = new Scanner(System.in);
        String response = in.next();

        boolean isRunning = true;
        Shape x = new Square(1);
        while (isRunning)
        {
            if(response.equals("c"))
            {
                System.out.print("\nEnter radius: ");
                response = in.next();
                x = new Circle(Double.parseDouble(response));
                isRunning = false;
            }
            else if (response.equals("s"))
            {
                System.out.print("\nEnter side length: ");
                response = in.next();
                x = new Square(Double.parseDouble(response));
                isRunning = false;
            } 
            else if (response.equals("p"))
            {
                System.out.print("\nEnter side length: ");
                double response1 = in.nextDouble();
                System.out.print("Enter base length: ");
                double response2 = in.nextDouble();
                System.out.print("Enter height value: ");
                double response3 = in.nextDouble();
                x = new Parallelogram(response2, response3, response1);
                isRunning = false;
            }
            else
            {
                System.out.println("please only enter the specified letters");
                System.out.println();
            }
        }
        System.out.println("\nThe area is " + x.getArea());
        System.out.println("The perimeter is " + x.getPerimeter());
    }
}
