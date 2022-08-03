import java.util.Scanner;
/**
 * Demos the car and limo classes
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public class Demo
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Car vehicle = new Car(0);

        boolean isPrompting = true;
        while (isPrompting)
        {
            System.out.print("Do you want a car, limo, or towtruck? ");
            String type = in.next();
            if (!type.equalsIgnoreCase("Limo") && !type.equalsIgnoreCase("Car") && !type.equalsIgnoreCase("Towtruck"))
            {
                System.out.println("Please respond with either \"Car,\" \"Limo,\" or \"Towtruck.\"");
            }
            else
            {
                System.out.print("What is its efficiency? ");
                double efficiency = in.nextDouble();
                if (type.equalsIgnoreCase("Car"))
                {
                    vehicle = new Car(efficiency);
                    isPrompting = false;
                }
                else if (type.equalsIgnoreCase("Limo"))
                {
                    System.out.print("Who is the driver? ");
                    String driver = in.next();
                    vehicle = new Limo("",0);
                    vehicle = (Limo)vehicle;
                    vehicle = new Limo(driver,efficiency);
                    isPrompting = false;
                }
                else if (type.equalsIgnoreCase("Towtruck"))
                {
                    vehicle = new Towtruck(0);
                    vehicle = (Towtruck)vehicle;
                    vehicle = new Towtruck(efficiency);
                    System.out.print("Is it towing another car (Y/N)? ");
                    String response1 = in.next();
                    if (response1.equalsIgnoreCase("Y"))
                    {
                        System.out.print("What is the towed car's efficiency? ");
                        double towedEfficiency = in.nextDouble();
                        Car towedCar = new Car(towedEfficiency);
                        ((Towtruck)vehicle).tow(towedCar);
                    }
                    isPrompting = false;
                }
            }
        }

        System.out.println("Vehicle created.");
        System.out.println("...");
        
        boolean isRunning = true;
        while (isRunning)
        {
            System.out.println("Type \"stop\" at any time to stop driving.");
            System.out.print("Would you like to add gas (Y/N)? ");
            String response2 = in.next();
            boolean continuing = true;
            if (response2.equalsIgnoreCase("Y"))
            {
                System.out.print("How many gallons would you like to add? ");
                double gasAdded = in.nextDouble();
                vehicle.addGas(gasAdded);
                System.out.println(gasAdded + " gallons of gas added.");
            }
            else if (response2.equalsIgnoreCase("stop"))
            {
                isRunning = false;
                continuing = false;
            }

            if (continuing)
            {
                System.out.print("How many miles would you like to drive? ");
                double milesDriven = in.nextDouble();
                vehicle.drive(milesDriven);
                if (vehicle.getGasInTank() <= 0)
                {
                    isRunning = false;
                    System.out.println("Vehicle ran out of gas.");
                }
            }
        }

        System.out.println();
        System.out.println(vehicle);
    }
}
