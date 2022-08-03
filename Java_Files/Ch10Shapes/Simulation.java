import java.util.Scanner;

/**
 * Similation
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
