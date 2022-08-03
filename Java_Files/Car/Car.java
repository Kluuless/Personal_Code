
/**
 * The Car clas represents car fuel efficiency and mileage
 * 
 * @author Mr. Funk
 * @version 1.0
 */
public class Car
{
    //  instance variable
    private double fuel;        //in gallons
    private double efficiency;  //in miles/gallon
    private double mileage;
    //You can add an instance variable for mileage

    /**
     * Constructor for objects of class Car
     */

    public Car (double myEfficiency)
    {
        efficiency = myEfficiency;
        fuel = 0.0;
        mileage = 0;
    }
    //Accessor Methods
    
    /**
     * getGasInTank - gets the amount of gas in the tank
     * 
     * @return      the amount of gas in the tank
     */
    public double getGasInTank()
    {
        return fuel;
    }
    
    public double getMileage()
    {
        return mileage;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Car)
        {
            return this.efficiency == ((Car) obj).efficiency && this.mileage == ((Car)obj).mileage;
        }
        return false;
    }

    public String toString()
    {
        return "car w/ " + efficiency + " mpg, " + fuel + " gallons of fuel, " + mileage + " miles";
    }
    
    //Mutator Methods 
    /**
     * addGas - adds gas to the tank
     * 
     * @param  gallons   the quantity of gas to be added (in gallons)
     */
    public void addGas(double gallons)
    {
        fuel = fuel + gallons;
    }
    
    /**
     * drive - update quantity of gas and mileage to reflect fuel usage
     * 
     * @param  distance   the number of miles the car was driven
     */
    public void drive(double distance)
    {
        double fuelUsed = distance/efficiency;
        fuel = fuel - fuelUsed;
        mileage += distance;
        if (fuel < 0)
        {
            fuel= 0;
        }
    }  
}