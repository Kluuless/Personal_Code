/**
 * RandomNumberArray is an array of n integers 
 *                                  
 * @author Mr. Funk and **YOUR NAME HERE**
 * @version 1.0
 */
public class RandomNumberList
{
    private int[] data;

    /**
     * Constructors for objects of class RandomNumberList
     */
    public RandomNumberList(int listSize)
    {
        data = new int[listSize];
        //load with random ints valued between 1 and 1,000,000
        for(int i = 0; i < listSize; i++)
        {
            data[i] = ((int)(Math.random()*1000000) + 1);
        }
    }

    public RandomNumberList(int[] list)
    {
        data = list;
    }

    public RandomNumberList()
    {
        int[] temp = {4, -1, 1, 2, 3, 0};
        data = temp;
    }

    /**
     * Sort data using the binary search algorithm
     * @return: the index of the target, -1 if target not found
     */
    public int binarySearch(int target)
    {
        return binarySearch(target,data);
    }

    private static int binarySearch(int target, int[] reduced)
    {
        if (reduced.length == 1)
        {
            if (reduced[0] == target)
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
        else if (reduced[reduced.length/2] == target)
        {
            return reduced.length/2;
        }
        int[] newReduced;
        int result;
        if (reduced[reduced.length/2] > target)
        {
            newReduced = new int[reduced.length/2];
            for (int i = 0; i < newReduced.length; i++)
            {
                newReduced[i] = reduced[i];
            }
            result = 0;
        }
        else
        {
            newReduced = new int[(reduced.length+1)/2];
            for (int i = 0; i < newReduced.length; i++)
            {
                newReduced[i] = reduced[(reduced.length)/2 + i];
            }
            result = reduced.length/2;
        }

        if (binarySearch(target, newReduced) == -1)
        {
            return -1;
        }
        else
        {
            return result + binarySearch(target, newReduced);
        }
    }

    /**
     * Sort data using the merge sort algorithm
     * @postcondition: data is sorted
     */
    public void mergeSort()
    {
        data = mergeSort(data);
    }

    private static int[] mergeSort(int[] a)
    {
        if (a.length <= 1)
        {
            return a;
        }
        int[] front = new int[a.length/2];
        int[] back = new int[a.length - front.length];
        int i = 0;
        for (i = 0; i < front.length; i++)
        {
            front[i] = a[i];
        }
        for (int j = 0; i < a.length; j++)
        {
            back[j] = a[i];
            i++;
        }
        return merge(mergeSort(front), mergeSort(back));
    }

    /**
     * Helper method:  Merge two sorted arrays into a new sorted array
     * 
     * @precondition: int[] a and int[] b are both sorted
     * @return:  a sorted array consisting of the data from a and b
     */
    public static int[] merge(int[] a, int[] b)
    {
        int[] c = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (k < c.length)
        {
            if (j != b.length && a[i] >= b[j])
            {
                c[k] = b[j];
                j++;
                k++;
            }
            else if (i != a.length && a[i] <= b[j])
            {
                c[k] = a[i];
                i++;
                k++;
            }
            if (i == a.length)
            {
                while (j < b.length)
                {
                    c[k] = b[j];
                    j++;
                    k++;
                }
            }
            else if (j == b.length)
            {
                while (i < a.length)
                {
                    c[k] = a[i];
                    i++;
                    k++;
                }
            }
        }
        return c;
    }
}

