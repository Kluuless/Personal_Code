
/**
 * Demos the ShowDog class
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Demo
{
    public static void main(String[] args)
    {
        String[] credentials1 = {"1st Place in Stamina", "3rd Place in Obedience"};
        ShowDog dog1 = new ShowDog("Doug",7,credentials1);
        System.out.println(dog1);
        dog1.older();
        dog1.addCredential("2nd Place in Beauty");
        System.out.println(dog1);
    }
}
