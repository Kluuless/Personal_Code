/**
 * RandomNumberArray is an array of n integers 
 *                                  
 * @author Mr. Funk and Kyle Luu
 * @version 1.0
 */
public class RandomNumberList2
{
    private int[] data;

    /**
     * Constructors for objects of class RandomNumberList
     */
    public RandomNumberList2(int listSize)
    {
        data = new int[listSize];
        //load with random ints valued between 1 and 1,000,000
        for(int i = 0; i < listSize; i++)
        {
            data[i] = ((int)(Math.random()*1000000) + 1);
        }
    }

    public RandomNumberList2(int[] list)
    {
        data = list;
    }

    public RandomNumberList2()
    {
        int[] temp = {4, -1, 1, 2, 3, 0};
        data = temp;
    }

    public void print()
    {
        for(int i = 0; i < data.length; i++)
        {
            System.out.println(data[i]);
        }
    }

    private void swap(int i, int j)
    {
        Integer temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    /**
     * Sort data using the insertion sort algorithm
     * @postcondition: data is sorted
     */
    public void insertionSort()
    {
        for (int i = 1; i < data.length; i++)
        {
            int j = i;
            while (j >= 1 && data[j] < data[j-1])
            {
                swap(j,j-1);
                j--;
            }
        }
    }

    /**
     * Merge two sorted arrays into a new sorted array
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
        while (k < a.length + b.length)
        {
            if (j != b.length && a[i] >= b[j])
            {
                c[k] = b[j];
                k++;
                j++;
            }
            else if (i != a.length && a[i] <= b[j])
            {
                c[k] = a[i];
                k++;
                i++;
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

    public void mergeSort()
    {
        data = mergeSort(data);
    }
}