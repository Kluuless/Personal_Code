
/**
 * Creates a base for subclasses, each will have its own encryption code
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public abstract class Message
{
        //instance variables
    protected String text;
    protected boolean isEncrypted;
    
    /**
     *  Constructor for abstract class Message
     *  
     *  @param  The text inside the message
     */
    public Message(String myText)
    {
        text = myText;
        isEncrypted = false;
    }
    
    /**
     * Accessor Methods ofr class Message
     * 
     * @return  The text of the method, regardless of encryption
     */
    public String getText()
    {
        return text;
    }
    
    /**
     * @return  True if text is encrypted, false if not
     */
    public boolean isEncrypted()
    {
        return isEncrypted;
    }
    
    /**
     * Mutator methods for class Message
     * 
     * Encrypts the message and sets isEncrypted to true
     * Only works if text isn't already encrypted
     */
    public abstract void encrypt();
    
    /**
     * Unencrypts the message and sets isEncrypted to false
     * Only works if text is already encrypted
     */
    public abstract void decrypt();
}
