
/**
 * Sums the values in an array
 *
 * @author  Kyle Luu
 * @version 1.0
 */
public class ArraySum
{
    public static double getSum(double[] values)
    {
        if (values.length == 1)
        {
            return values[0];
        }
        else if (values.length == 0)
        {
            return 0;
        }
        else
        {
            double[] newValues = new double[values.length - 1];
            for (int i = 0; i < newValues.length; i++)
            {
                newValues[i] = values[i+1];
            }
            return values[0] + getSum(newValues);
        }
    }

    /**  Tester  **/
    public static void main(String[] args)
    {
        double[] data1 = {0.3, 1.4, 0.5};
        System.out.println("should be 2.2: " + getSum(data1));

        double[] data2 = {};
        System.out.println("should be 0: " + getSum(data2));

        double[] data3 = {-1.1, 2.2, 3.3, -4.1};
        System.out.println("should be 0.3: " + getSum(data3));        
    }

}
