
/**
 * reverses two texts
 * 
 * @author Kyle Luu 
 * @version 1.0
 */
public class Reverse extends Message
{
    /**
     * Constructor for class Reverse
     * 
     * @param   The text in the message
     */
    public Reverse(String myText)
    {
        super(myText);
    }

    /**
     * Mutator methods for class Reverse
     * 
     * Defines encrypt() as reversing the text from back to front
     */
    public void encrypt()
    {
        if (isEncrypted == false)
        {
            char[] temp = new char[text.length()]; //makes an array of char with the reverse order of text

            for (int i = 0; i < text.length(); i++)
            {
                int j = text.length() - i - 1;
                temp[i] = text.charAt(j);
            }

            text = ""; //sets text to empty string

            for (int i = 0; i < temp.length; i++) //sets the text to the reversed char array
            {
                text += temp[i];
            }

            isEncrypted = true;
        }
    }

    /**
     * Reverts and reverses the text back to the original
     */
    public void decrypt()
    {
        if (isEncrypted == true)
        {
            char[] temp = new char[text.length()]; //makes an array of char with the reverse order of text

            for (int i = 0; i < text.length(); i++)
            {
                int j = text.length() - i - 1;
                temp[i] = text.charAt(j);
            }

            text = ""; //sets text to empty string

            for (int i = 0; i < temp.length; i++) //sets the text to the reversed char array
            {
                text += temp[i];
            }

            isEncrypted = false;
        }
    }
}