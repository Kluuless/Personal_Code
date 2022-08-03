import java.util.ArrayList;
/**
 * Exchanges each letter with letter on the opposite side of the alphabet then inserts
 * random letters in between each character in the string.
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public class MyCrazyCipher extends Message
{
    private final int CAP_A = (int)'A'; //numerical value is 65
    private final int LOW_A = (int)'a'; //numerical value is 97
    private final int CAP_Z = (int)'Z'; //equal to 90
    private final int LOW_Z = (int)'z'; //equal to 122
    int n;

    /**
     * Constructors for class MyCrazyCipher
     * 
     * @param   the text of the message
     */
    public MyCrazyCipher(String myText)
    {
        super(myText);
        n = 2;
    }

    /**
     * @param   the text of the message
     * @param   the rate to which letters are added/removed
     */
    public MyCrazyCipher(String myText, int rate)
    {
        super(myText);
        n = rate;
    }

    private void letterSwap() //swaps the letters
    {
        char[] temp = new char[text.length()]; //makes an array of char that represents the String

        for (int i = 0; i < text.length(); i++)
        {
            temp[i] = text.charAt(i);
        }

        for (int i = 0; i < temp.length; i++) //performs the encryption by shifting the characters up by n
        {
            int scanned = (int)temp[i];
            if (scanned <= CAP_Z && scanned >= CAP_A) //for capital letters
            {
                temp[i] = (char)((CAP_Z - scanned) + CAP_A);
            }
            else if (scanned <= LOW_Z && scanned >= LOW_A) //for lowercase letters
            {
                temp[i] = (char)((LOW_Z - scanned) + LOW_A);
            }
        }
        text = "";

        for (int i = 0; i < temp.length; i++) //turns the array back to a String
        {
            text += temp[i];
        }

        //System.out.println(text);
    }

    private void insertRandomLetters(int n)
    {
        ArrayList<Character> temp = new ArrayList<Character>();
        int pos = n - 1;

        for (int i = 0; i < text.length(); i++) //makes an array of char that represents the text
        {
            temp.add(text.charAt(i));
        }
        
        boolean isAllCapital = true;
        boolean isAllLowercase = true;
        
        for (int i = 0; i < temp.size(); i++)
        {
            int scanned = (int)temp.get(i);
            if (scanned <= CAP_Z && scanned >= CAP_A) //for any capital letters
            {
                isAllLowercase = false;
            }
            else if (scanned <= LOW_Z && scanned >= LOW_A) //for any lowercase letters
            {
                isAllCapital = false;
            }
        }
        
        for (int i = 0; i + pos < temp.size(); i += n) //inserts random letters, preserving capitalization
        {
            int scanned = (int)(temp.get(i));
            if (isAllCapital && !isAllLowercase) //for capital letters
            {
                char randCapChar = (char) ((int)(Math.random() * 26) + CAP_A); //a random capital letter
                temp.add(i + pos, randCapChar); //adds it n away from the index
            }
            else if (isAllLowercase && !isAllCapital) //for lowercase letters
            {
                char randLowChar = (char) ((int)(Math.random() * 26) + LOW_A); //a random lowercase letter
                temp.add(i + pos, randLowChar); //adds it n away from the index
            }
            else
            {
                double capitalOrLowercase = Math.random();
                //decides randomly to insert a capital letter or a lowercase letter
                if (capitalOrLowercase < 0.5)
                {
                    char randCapChar = (char) ((int)(Math.random() * 26) + CAP_A); //a random capital letter
                    temp.add(i + pos, randCapChar); //adds it n away from the index
                }
                else
                {
                    char randLowChar = (char) ((int)(Math.random() * 26) + LOW_A); //a random lowercase letter
                    temp.add(i + pos, randLowChar); //adds it n away from the index
                }
            }
        }

        text = ""; //clears the text

        for (int i = 0; i < temp.size(); i++) //turns the ArrayList back into a String
        {
            text += temp.get(i);
        }

        // System.out.println(text); //for testing purposes
    }

    private void removeLetters(int n)
    {
        ArrayList<Character> temp = new ArrayList<Character>();
        int pos = n - 1;

        for (int i = 0; i < text.length(); i++) //makes an array of char that represents the text
        {
            temp.add(text.charAt(i));
        }

        for (int i = 0; i + pos < temp.size(); i += pos)
        {
            temp.remove(i + pos);
        }

        text = ""; //clears the text

        for (int i = 0; i < temp.size(); i++) //turns the ArrayList back into a String
        {
            text += temp.get(i);
        }

        // System.out.println(text); //for testing purposes
    }

    public void encrypt()
    {
        if (isEncrypted == false && !(text.length() == 0))
        {
            letterSwap();
            insertRandomLetters(n);
            isEncrypted = true;
        }
    }

    public void decrypt()
    {
        if (isEncrypted == true && !(text.length() == 0))
        {
            removeLetters(n);
            letterSwap();
            isEncrypted = false;
        }
    }
}
