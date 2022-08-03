import java.util.ArrayList;
import java.util.Arrays;
/**
 * Tests the merge algorithms
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Tester
{
    public static void main(String[] args)
    {
        int[] a1 = {-1,3,5,9,10,15,17};
        int[] a2 = {0,4,5,6,7,8,11,13,18,20,22,23};
        int[] aResult = RandomNumberList2.merge(a1, a2);
        System.out.println("Array Merging:");
        System.out.println("1st: " + Arrays.toString(a1));
        System.out.println("2nd: " + Arrays.toString(a2));
        System.out.println("Result: " + Arrays.toString(aResult));
        System.out.println();
        ArrayList<Integer> b1 = new ArrayList<Integer>();
        for (int i = 0; i < a1.length; i++)
        {
            b1.add(a1[i]);
        }
        ArrayList<Integer> b2 = new ArrayList<Integer>();
        for (int i = 0; i < a2.length; i++)
        {
            b2.add(a2[i]);
        }
        //ArrayList<Integer> bResult = RandomNumberList4.merge(b1, b2);
        System.out.println("ArrayList Merging:");
        System.out.println("1st: " + b1);
        System.out.println("2nd: " + b2);
        //System.out.println("Result: " + bResult);
    }
    
    public static void tester()
    {
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(490863);
        a.add(8);
        a.add(0);
        a.add(-1543);
        a.add(3);
        RandomNumberList4 b = new RandomNumberList4(a);
        b.print();
        System.out.println();
        b.mergeSort();
        b.print();
    }
}
