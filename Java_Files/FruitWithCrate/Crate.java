import java.util.List;
import java.util.ArrayList;

/**
 * Crate - a container for Fruit
 * 
 * @author Mr. Funk 
 * @version Feb 20, 2018
 */
public class Crate implements Comparable<Crate>
{
    private ArrayList<Fruit> bin;

    public Crate()
    {
        bin = new ArrayList<Fruit>();
    }

    public void putInCrate(Fruit fruit)
    {
        bin.add(fruit);
    }

    public void printContents()
    {
        System.out.print("The crate has: ");
        for (Fruit x : bin)
        {
            System.out.print(x + ", ");
        }
    }

    private ArrayList<Fruit> toArrayList()
    {
        return bin;
    }

    public int compareTo(Crate other)
    {
        double weight1 = 0;
        for (int i = 0; i < bin.size(); i++)
        {
            weight1 += bin.get(i).getWeight();
        }

        ArrayList<Fruit> otherCrate = other.toArrayList();
        double weight2 = 0;
        for (int i = 0; i < otherCrate.size(); i++)
        {
            weight2 += otherCrate.get(i).getWeight();
        }

        if (weight1 < weight2)
        {
            return -1;
        }
        else if (weight1 > weight2)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Crate)
        {
            ArrayList<Fruit> otherBin = ((Crate)obj).toArrayList();
            if (bin.size() != otherBin.size())
            {
                return false;
            }
            else
            {
                boolean isEqual;
                for (int i = 0; i < bin.size(); i++)
                {
                    if (bin.get(i).equals(otherBin.get(i)))
                    {
                        isEqual = true;
                    }
                    else
                    {
                        isEqual = false;
                    }
                    return isEqual;
                }
            }
        }
        return false;
    }
}
