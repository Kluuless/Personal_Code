
/**
 * Prints a pattern of x's with n rows and n columns
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public class PrintLoops
{
    public static void printBlock(int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print("x");
            }
            System.out.println();
        }
    }

    public static void printDiagonal(int n)
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                System.out.print(" ");
            }
            System.out.print("x");
            System.out.println();
        }
    }

    public static void printBox(int n)
    {        
        for(int i = 0; i < n; i++)
        {
            System.out.print("x");
        }

        System.out.println();

        for(int i = 0; i < n/2; i++)
        {
            System.out.print("x");
            for(int j = 0; j < n-2; j++)
            {
                System.out.print(" ");
            }
            System.out.print("x");
            System.out.println();
        }

        if(n>2)
        {
            for(int i = 0; i < n; i++)
            {
                System.out.print("x");
            }
        }
    }

    public static void printX(int n)
    {
        for (int i = 1; i <= n/2; i++)
        {
            for(int k = 0; k < i; k++)
            {
                System.out.print(" ");
            }
            
            System.out.print("x");

            for (int j = 0; j < n - i*2; j++)
            {
                System.out.print(" ");
            }

            System.out.print("x");
            System.out.println();
        }
        
        if ((n%2) == 1)
        {
            for(int i = 0; i <= (n/2); i++)
            {
                System.out.print(" ");
            }
            
            System.out.print("x");
            System.out.println();
            
        }
        
        for (int i = n/2; i > 0; i--)
        {
            for(int k = 0; k < i; k++)
            {
                System.out.print(" ");
            }
            
            System.out.print("x");

            for (int j = 0; j < n - i*2; j++)
            {
                System.out.print(" ");
            }

            System.out.print("x");
            System.out.println();
        }
    }
    
    public static void printDiamond(int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n - 1 - i; j++)
            {
                System.out.print(" ");
            }
            
            for(int m = 0; m < i + 1; m++)
            {
                System.out.print(" x");
            }
            
            System.out.println();
        }
        
        for (int i = n - 1; i > 0; i--)
        {
            for (int j = 0; j < n - i; j++)
            {
                System.out.print(" ");
            }

            for(int m = 0; m < i; m++)
            {
                System.out.print(" x");
            }
            
            System.out.println();
        }
    }
    
    public static void drawReverseTriangle(int n)
    {
        for(int row = 1; row <= n; row++)
        {
            //prints out the number of spaces
            for(int column = 1; column <= n - row; column++)
            {
                System.out.print(" ");
            }
            
            //prints out the number of *'s
            for(int column = 1; column <= row; column++)
            {
                System.out.print("*");
            }
            
            //starts new line
            System.out.println();
        }
    } 
    
    public static void drawTriangle (int height)
    {
        //top half of triangle
        for(int row = 1; row <= height; row++)
        {
            //prints out the number of *'s
            for(int column = 1; column <= row; column++)
            {
                System.out.print("*");
            }
            
            //starts new line
            System.out.println();
        }
        
        //bottom half of triangle
        for(int row = height - 1; row > 0; row--)
        {
            //prints out the number of *'s
            for(int column = 1; column <= row; column++)
            {
                System.out.print("*");
            }
            
            //starts new line
            System.out.println();
        }
    }
    // 1 1 2 3 5 8 13 21 35
    public static void fibbonacci (int amount)
    {
        int count = 1;
        int prevCount = 0;
        for (int i = 0; i < amount; i++)
        {
            for (int j = 0; j < count; j++)
            {
                System.out.print("x");
            }
            count += prevCount;
            prevCount = count - prevCount;
            System.out.println();
        }
    }
}
