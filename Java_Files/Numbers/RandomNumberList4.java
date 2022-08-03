import java.util.ArrayList;
import java.util.List;

/**
 * RandomNumberArray is an array of n random integers valued between 1 and 1,000,000
 * 
 * @author Mr. Funk and Kyle Luu
 * @version 1.0
 */

public class RandomNumberList4
{
    private ArrayList<Integer> data;

    /**
     * Constructor for objects of class RandomNumberList4
     */

    public RandomNumberList4(int listSize)
    {
        data = new ArrayList();
        for(int i = 0; i < listSize; i++)
        {
            data.add((int)(Math.random()*10000) + 1);
        }
    }

    public RandomNumberList4()     //unsorted list {4, 1, 3, -1, 2, 0}
    {
        data = new ArrayList();
        data.add(4);
        data.add(1);
        data.add(3);
        data.add(-1);
        data.add(2);
        data.add(0);        
    }

    public RandomNumberList4(ArrayList<Integer> a)
    {
        this.data = a;
    }

    public void print()
    {
        for(int i = 0; i < data.size(); i++)
        {
            System.out.println(data.get(i));
        }
    }

    /**
     * returns the position of the target in the list
     *    (if there are multiple occurrences of the target, 
     *     any one of those positions may be returned.)
     * returns -1 if the target is not in the list
     */
    public int find(int target)
    {
        for (int i = 0; i < data.size(); i++)
        {
            if (data.get(i) == target)
            {
                return data.get(i);
            }
        }
        return -1;
    }

    /**
     * returns true of the numbers are in ascending order
     * returns false otherwise
     */
    public boolean isSorted()
    {
        boolean result = true;
        for (int i = 0; i < data.size() - 1; i++)
        {
            if (data.get(i) > data.get(i + 1))
            {
                result = false;
            }
        }
        return result;
    }

    /**
     * mutate the list so that the data in ascending order
     */
    public void sort()
    {
        Integer temp;
        for (int i = 0; i < data.size(); i++)
        {
            for (int j = 0; j < data.size(); j++)
            {
                if (data.get(i) < data.get(j))
                {
                    temp = data.get(i);
                    data.set(i,data.get(j));
                    data.set(j,temp);
                }
            }
        }
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b)
    {
        ArrayList<Integer> c = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < a.size() + b.size())
        {
            if (j != b.size() && a.get(i) >= b.get(j))
            {
                c.add(b.get(j));
                k++;
                j++;
            }
            else if (i != a.size() && a.get(i) <= b.get(j))
            {
                c.add(a.get(i));
                k++;
                i++;
            }
            if (i == a.size())
            {
                while (j < b.size())
                {
                    c.add(b.get(j));
                    j++;
                    k++;
                }
            }
            else if (j == b.size())
            {
                while (i < a.size())
                {
                    c.add(a.get(i));
                    i++;
                    k++;
                }
            }
        }
        return c;
    }

    private static ArrayList<Integer> split(ArrayList<Integer> a, int from, int to)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (int i = from; i < to; i++)
        {
            result.add(a.get(i));
        }
        return result;
    }

    private ArrayList<Integer> mergeSort(ArrayList<Integer> a, ArrayList<Integer> b)
    {
        if (a.size() == 1 && b.size() == 1)
        {
            return merge(a,b);
        }
        else if (a.size() == 1 && b.size() != 1)
        {
            ArrayList<Integer> bSplit1 = split(b,0,b.size()/2);
            ArrayList<Integer> bSplit2 = split(b,b.size()/2,b.size());
            return merge(a,mergeSort(bSplit1,bSplit2));
        }
        else if (a.size() != 1 && b.size() == 1)
        {
            ArrayList<Integer> aSplit1 = split(a,0,a.size()/2);
            ArrayList<Integer> aSplit2 = split(a,a.size()/2,a.size());
            return merge(b,mergeSort(aSplit1,aSplit2));
        }
        else
        {
            ArrayList<Integer> aSplit1 = split(a,0,a.size()/2);
            ArrayList<Integer> aSplit2 = split(a,a.size()/2,a.size());
            ArrayList<Integer> bSplit1 = split(b,0,b.size()/2);
            ArrayList<Integer> bSplit2 = split(b,b.size()/2,b.size());
            return merge(mergeSort(aSplit1,aSplit2),mergeSort(bSplit1,bSplit2));
        }
    }

    public void mergeSort()
    {
        ArrayList<Integer> front = split(data,0,data.size()/2);
        ArrayList<Integer> back = split(data,data.size()/2,data.size());
        data = mergeSort(front,back);
    }
    
    public static boolean tester()
    {
        RandomNumberList4 myData = new RandomNumberList4();
        myData.mergeSort();
        return (myData.data.get(0) == -1) && (myData.data.get(1) == 0) && (myData.data.get(2) == 1) 
        && (myData.data.get(3) == 2) && (myData.data.get(4) == 3) && (myData.data.get(5) == 4);
    }
}
