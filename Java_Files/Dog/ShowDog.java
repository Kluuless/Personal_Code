import java.util.ArrayList;
/**
 * A type of dog, which has credentials.
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public class ShowDog extends Dog
{
    private ArrayList<String> credentials;
    
    public ShowDog(String name, int age, String[] credentials)
    {
        super(name, age);
        this.credentials = new ArrayList<String>();
        for (int i = 0; i < credentials.length; i++)
        {
            this.credentials.add(credentials[i]);
        }
    }
    
    public void addCredential(String note)
    {
        credentials.add(note);
    }
    
    public String toString()
    {
        String listCredentials = credentials.toString().substring(1);
        listCredentials = listCredentials.substring(0,listCredentials.length() - 1);
        return super.toString() + ", credentials = " + listCredentials;
    }
}


