
/**
 * Uses a Caesar shift to encrypt the text
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public class CaesarShift extends Message
{
    private int n; //the amount to shift

    private final int CAP_A = (int)'A'; //numerical value is 65
    private final int LOW_A = (int)'a'; //numerical value is 97
    private final int CAP_Z = (int)'Z'; //equal to 90
    private final int LOW_Z = (int)'z'; //equal to 122

    /**
     * Constructors for class CaesarShift
     * 
     * Default shift value is 3 places
     * 
     * @param   The text in the message
     */
    public CaesarShift(String myText) //default shift value is 3
    {
        super(myText);
        n = 3;
    }

    /**
     * Constructor that allows for custom shifting amounts
     * 
     * @param   The text in the message
     * @param   The amount to shift the text by
     */
    public CaesarShift(String myText, int shiftAmount) //allows a shift of more than 3
    {
        super(myText);
        n = shiftAmount % 26;
    }

    /**
     * Mutator methods for class CaesarShift
     * 
     * Shifts the characters ahead by n amounts
     */
    public void encrypt()
    {
        if (isEncrypted == false)
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
                    if (scanned + n <= CAP_Z) //shift up n values if doing so results in a letter before z
                    {
                        temp[i] = (char)(scanned + n);
                    }
                    else //loops back to 'A' if shifting by n goes past 'Z'
                    {
                        int valueAboveA = n - (CAP_Z - scanned) - 1;
                        temp[i] = (char)(CAP_A + valueAboveA);
                    }
                }
                else if (scanned <= LOW_Z && scanned >= LOW_A) //for lowercase letters
                {
                    if (scanned + n <= LOW_Z) //shifts up n values
                    {
                        temp[i] = (char)(scanned + n);
                    }
                    else //loops back to 'a' if shifting by n goes past 'z'
                    {
                        int valueAboveA = n - (LOW_Z - scanned) - 1;
                        temp[i] = (char)(LOW_A + valueAboveA);
                    }
                }
            }
            
            text = ""; //resets string to empty, to be filled with new encrypted text
            
            for (int i = 0; i < temp.length; i++) //fills the string with the new encrypted array
            {
                text += temp[i];
            }
            
            isEncrypted = true;
        }
    }

    /**
     * Shifts the characters back to original
     */
    public void decrypt()
    {
        if (isEncrypted == true)
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
                    if (scanned - n >= CAP_A) //shift down n values
                    {
                        temp[i] = (char)(scanned - n);
                    }
                    else //loops back to 'Z' if shifting by n goes past 'A'
                    {
                        int valueBelowZ = n + (CAP_A - scanned) - 1;
                        temp[i] = (char)(CAP_Z - valueBelowZ);
                    }
                }
                else if (scanned <= LOW_Z && scanned >= LOW_A) //for lowercase letters
                {
                    if (scanned - n >= LOW_A) //shifts down n values
                    {
                        temp[i] = (char)(scanned - n);
                    }
                    else //loops back to 'z' if shifting by n goes past 'a'
                    {
                        int valueBelowZ = n + (LOW_A - scanned) - 1;
                        temp[i] = (char)(LOW_Z - valueBelowZ);
                    }
                }
            }
            
            text = ""; //resets string to empty, to be filled with new encrypted text
            
            for (int i = 0; i < temp.length; i++) //fills the string with the new encrypted array
            {
                text += temp[i];
            }
            
            isEncrypted = false;
        }
    }
}
