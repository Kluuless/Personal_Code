import java.util.Arrays;
/**
 * Asks for numbers and calculates stuff about them.
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Numbers
{
    /**
     * Instance variables:
     */
    private double[] values;

    /**
     * 
     */
    public Numbers()
    {
        for (int i = 1; i <=10; i++)
        {
            values[i-1] = i;
        }
    }

    public Numbers(double[] input)
    {
        if (input.length == 0)
        {
            values = new double[1];
            values[0] = 0;
        }
        values = input;
    }

    public void setValue(int loc, double x)
    {
        values[loc] = x;
    }

    public void addValue(double input)
    {
        double[] expanded = new double[values.length + 1];
        for (int i = 0; i < values.length; i++)
        {
            expanded[i] = values[i];
        }

        expanded[expanded.length - 1] = input;
        values = expanded;
    }

    public double sum()
    {      
        double result = 0;

        for (double x : values)
        {
            result += x;
        }

        return result;
    }

    public double biggest()
    {
        double result = values[0];
        for (double x : values)
        {
            if (x > result)
            {
                result = x;
            }
        }

        return result;
    }

    public double smallest()
    {
        double result = values[0];
        for (double x : values)
        {
            if (x < result)
            {
                result = x;
            }
        }
        return result;
    }

    public double biggestDiff()
    {
        double result = biggest();
        for (double x : values)
        {
            if (x != biggest())
            {
                result -= x;
            }
        }
        return result;
    }

    public double orderDiff()
    {
        double result = 0;
        boolean first = true;
        for (double x : values)
        {
            if (first)
            {
                result = x;
                first = false;
            }
            else
            {
                result -= x;
            }
        }

        return result;
    }

    public double[] inOrder()
    {
        double[] copy = new double[values.length];
        for (int i = 0; i < values.length; i++)
        {
            copy[i] = values[i];
        }
        Arrays.sort(copy);
        return copy;
    }

    public double product()
    {
        double result = 1;
        for (double x : values)
        {
            result *= x;
        }
        return result;
    }

    public double biggestQuotient()
    {
        double result = biggest();
        for (double x : values)
        {
            if (x != biggest())
            {
                result /= x;
            }
        }
        return result;
    }

    public double orderQuotient()
    {
        double result = 0;
        boolean first = true;
        for (double x : values)
        {
            if (first)
            {
                result = x;
                first = false;
            }
            else
            {
                result /= x;
            }
        }

        return result;
    }

    public double average()
    {
        return (sum()/values.length);
    }

    public double median()
    {        
        double[] ordered = inOrder();
        int midIndex = ordered.length/2;

        if ((ordered.length - 1) % 2 == 1)
        {
            return ordered[midIndex + 1];
        }
        else
        {
            return (ordered[midIndex] + ordered[midIndex + 1]) / 2;
        }
    }

    public double mode()
    {
        String sortedString = Arrays.toString(inOrder());
        double[] ordered = inOrder();
        double mostOften = values[0];
        int difference = 0;
        for (double x : values)
        {
            double scannedValue = x;
            String stringScanned = "" + scannedValue;
            int tempDifference = sortedString.lastIndexOf(stringScanned) - sortedString.indexOf(stringScanned);

            if (tempDifference > difference)
            {
                mostOften = x;
                difference = tempDifference;

            }
        }

        return mostOften;
    }

    public double range()
    {
        return biggest() - smallest();
    }

    public String toString()
    {
        return Arrays.toString(values);
    }
}
