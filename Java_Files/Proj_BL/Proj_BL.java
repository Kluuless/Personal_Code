import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Calculates info about digits
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public class Proj_BL
{
    public static int sumDigits(int x)
    {
        if (x/10 <= 0)
        {
            return x;
        }
        return x%10 + sumDigits(x/10);
    }

    private static int countDigitsHelper(int num, int target)
    {
        String numString = num + "";
        if (num <= 0)
        {
            return 0;
        }
        if (numString.contains("" + target))
        {
            int newIndex = numString.indexOf("" + target);
            String fromNewIndex = numString.substring(newIndex + 1, numString.length());
            int newNum;
            if (fromNewIndex.length() <= 0)
            {
                newNum = 0;
            }
            else
            {
                newNum = Integer.parseInt(fromNewIndex);
            }
            return 1 + countDigitsHelper(newNum, target);
        }
        else
        {
            return 0;
        }
    }

    public static int[] countDigits(int[] data)
    {
        int[] nums = new int[10];
        for (int i = 0; i < data.length; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                nums[j] += countDigitsHelper(data[i],j);
            }
        }
        return nums;
    }

    public static int[] reduce(int[] nums)
    {
        int smallest = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (nums[i] < smallest && nums[i] != 0)
            {
                smallest = nums[i];
            }
        }

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++)
        {
            result[i] = (nums[i] + 1)/smallest;
        }

        return result;
    }

    public static void showCountDigitsResults(int[] data)
    {
        int[] amount = countDigits(data);
        amount = reduce(amount);
        for (int i = 0; i < 10; i++)
        {
            System.out.print(i);
            for (int j = 0; j < amount[i]; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * DEFAULT: population.txt
     * 
     * Other options:
     *          - stars.txt
     *          - words.txt
     */
    public static void showCountDigitResults(String filename)
    {
        if (filename.equals ("population.txt"))
        {
            System.out.println("Population of various countries around the world:\n");
        }
        else if (filename.equals("stars.txt"))
        {
            System.out.println("Distance of the stars visible with human eye from earth in light years:\n");
        }
        else if (filename.equals("words.txt"))
        {
            System.out.println("The 1000 words most often spoken on television in 2006:\n");
        }
        ArrayList<String> names = new ArrayList<String>();
        ArrayList<Integer> amount = new ArrayList<Integer>();

        //Setup File
        if(filename.equals(""))
        {
            filename = "population.txt";
        }
        File fileLocation = new File(filename);

        try 
        { 
            // 
            // Create a new Scanner object which will read the data from the file 
            // passed in. 
            Scanner scanner = new Scanner(fileLocation);             

            // To check if there are more lines to read, check by calling the  
            // scanner.hasNextLine() method. Then read lines one by one 
            // until all are read. 

            while (scanner.hasNextLine()) 
            { 
                String word = scanner.nextLine();
                String[] parts = word.split("\t");
                names.add(parts[0]);
                amount.add(Integer.parseInt(parts[1]));
                //update data with new Film object  
            } 

            //if file not found, catch the exception thrown by the Scanner class
        } 
        catch (FileNotFoundException e) 
        { 
            e.printStackTrace(); 
        }

        int[] popArray = new int[amount.size()];
        for (int i = 0; i < amount.size(); i++)
        {
            popArray[i] = amount.get(i);
        }
        //         System.out.println(names.size());
        if (popArray[popArray.length/2] < 0.1 * popArray[0])
        {
            for (int i = popArray.length/2; i < popArray.length; i++)
            {
                popArray[i] = 0;
            }
        }

        if (popArray[0] > 1000)
        {
            popArray = reduce(popArray);
        }

        String longest = names.get(0);
        for (int i = 1; i < names.size(); i++)
        {
            if (names.get(i).length() > longest.length())
            {
                longest = names.get(i);
            }
        }
        
        for (int i = 0; i < popArray.length; i++)
        {
            System.out.print(names.get(i) + "\t");
            for (int j = 1; j <= longest.length()/8; j++)
            {
                if (names.get(i).length() <= j * 8 - 1)
                {
                    System.out.print("\t");
                }
            }
            
            for (int j = 0; j < popArray[i]; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    
    public static int[] getData(int n)
    {
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
        {
            result[i] = i + 1;
        }
        return result;
    }
}