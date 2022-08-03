import java.util.Scanner;
/**
 * Takes an int, and generates a string of that length, made of random letters and " "
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class RandomLetters
{
    /**
     *  generates a random letter.
     */
    public static String randomLetter()
    {
        double randomNum = Math.random() * 27;
        String randomLetter;
        if (randomNum < 1){randomLetter = "A";}
        else if (randomNum > 1 && randomNum < 2){randomLetter = "B";}
        else if (randomNum > 2 && randomNum < 3){randomLetter = "C";}
        else if (randomNum > 3 && randomNum < 4){randomLetter = "D";}
        else if (randomNum > 4 && randomNum < 5){randomLetter = "E";}
        else if (randomNum > 5 && randomNum < 6){randomLetter = "F";}
        else if (randomNum > 6 && randomNum < 7){randomLetter = "G";}
        else if (randomNum > 7 && randomNum < 8){randomLetter = "H";}
        else if (randomNum > 8 && randomNum < 9){randomLetter = "I";}
        else if (randomNum > 9 && randomNum < 10){randomLetter = "J";}
        else if (randomNum > 10 && randomNum < 11){randomLetter = "K";}
        else if (randomNum > 11 && randomNum < 12){randomLetter = "L";}
        else if (randomNum > 12 && randomNum < 13){randomLetter = "M";}
        else if (randomNum > 13 && randomNum < 14){randomLetter = "N";}
        else if (randomNum > 14 && randomNum < 15){randomLetter = "O";}
        else if (randomNum > 15 && randomNum < 16){randomLetter = "P";}
        else if (randomNum > 16 && randomNum < 17){randomLetter = "Q";}
        else if (randomNum > 17 && randomNum < 18){randomLetter = "R";}
        else if (randomNum > 18 && randomNum < 19){randomLetter = "S";}
        else if (randomNum > 19 && randomNum < 20){randomLetter = "T";}
        else if (randomNum > 20 && randomNum < 21){randomLetter = "U";}
        else if (randomNum > 21 && randomNum < 22){randomLetter = "V";}
        else if (randomNum > 22 && randomNum < 23){randomLetter = "W";}
        else if (randomNum > 23 && randomNum < 24){randomLetter = "X";}
        else if (randomNum > 24 && randomNum < 25){randomLetter = "Y";}
        else if (randomNum > 25 && randomNum < 26){randomLetter = "Z";}
        else {randomLetter = " ";}
        return randomLetter;
    }
    
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a length: ");
        int num = in.nextInt();
        for (int i = 1; i <= num; i++)
        {
            System.out.print(randomLetter());
        }
    }
}
