/**
 * Locker Combination
 * 
 * @author Mr. Funk
 * @version 1.0
 */
public class Combination
{  
    private int[] nums = new int[3];

    /**
     * Constructor for objects of class Combination
     */
    public Combination()
    {
        for(int i = 0; i < nums.length; i++)
        {
            nums[i] = (int)(Math.random()*40);       
        }
    }

    public void setCombination(int a, int b, int c)
    {
        nums[0] = a;
        nums[1] = b;
        nums[2] = c;
    }

    public String toString()
    {
        return nums[0] + " - " + nums[1] + " - " + nums[2];
    }

    public int get(int position)
    {
        return nums[position];
    }
}
