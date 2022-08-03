
/**
 * Converts the text to Morse Code
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public class MorseCode extends Message
{
    /**
     * Instance Variables (the Morse Code Key)
     */
    private static final String[] alphabetKey = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---",
            "-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    //all the letters A-Z

    private static final String[] numberKey = {"-----","..---","...--","....-",".....","-....","--...","---..",
            "----.",".----"};
    //all the numbers 0-9

    /**
     * Default constructor for class MorseCode
     */
    public MorseCode(String myText)
    {
        super(myText);
    }

    /**
     * Helper Method, converts the letters, numbers, and select 3 punctuations into morse code.
     */

    /**
     * @return  the Morse Code representation of the character
     * 
     * @param   the letter to convert (as a String)
     * @return  the morse code representation of the character, if not able to be converted, returns the letter.
     */
    public static String key(String character)
    {
        int theChar = (int)character.charAt(0);

        if (theChar >= (int)('A') && theChar <= (int)('Z'))
        {
            theChar -= (int)('A');
            return alphabetKey[theChar];
        }
        else if (theChar >= (int)('a') && theChar <= (int)('z'))
        {
            theChar -= (int)('a');
            return alphabetKey[theChar];
        }
        else if (theChar >= (int)('0') && theChar <= (int)('9'))
        {
            theChar -= (int)('0');
            return numberKey[theChar];
        }
        else if (theChar == (int)('.'))
        {
            return ".-.-.-";
        }
        else if (theChar == (int)(','))
        {
            return "--..--";
        }
        else if (theChar == (int)('?'))
        {
            return "..--..";
        }

        return character;
    }

    public static String reverseKey(String letter)
    {
        String code = letter;
        for (int i = 0; i < alphabetKey.length; i++)
        {
            if (alphabetKey[i].equals(letter))
            {
                code = (char)((int)'A' + i) + "";
            }
        }
        for (int i = 0; i < numberKey.length; i++)
        {
            if (numberKey[i].equals(letter))
            {
                code = (char)((int)'0' + i) + "";
            }
        }
        if (letter.equals(".-.-.-"))
        {
            code = ".";
        }
        else if (letter.equals("--..--"))
        {
            code = ",";
        }
        else if (letter.equals("..--.."))
        {
            code = "?";
        }
        return code;
    }

    public void encrypt()
    {
        if (isEncrypted == false)
        {
            String temp = "";
            boolean isFirst = true;
            for (int i = 0; i < text.length(); i++)
            {
                if (isFirst)
                {
                    isFirst = false;
                }
                else
                {
                    temp += "/";
                }
                temp += key(text.charAt(i) + "");
            }
            text = temp;
            isEncrypted = true;
        }
    }

    public void decrypt()
    {
        if (isEncrypted == true)
        {
            String textCopy = new String (text + "/");
            String temp = "";
            int prevSlashLocation = 0;
            int nextSlashLocation = text.indexOf("/");
            for (int i = 0; i < textCopy.length() - 1; i += (nextSlashLocation - prevSlashLocation))
            {
                if (nextSlashLocation > 0)
                {
                    String scanned = textCopy.substring(prevSlashLocation,nextSlashLocation);
                    prevSlashLocation = nextSlashLocation + 1;
                    nextSlashLocation = textCopy.indexOf("/", prevSlashLocation);
                    temp += reverseKey(scanned);
                }
            }
            text = temp;
            isEncrypted = false;
        }
    }
}
