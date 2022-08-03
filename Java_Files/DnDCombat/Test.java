
/**
 * Tests the toString method from DnDCharacter class
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Test
{
    public static void main(String args[])
    {
        DnDCharacter sample1 = new DnDCharacter();
        System.out.println(sample1);
        System.out.println();
        System.out.println("Damaging Sample:");
        System.out.println();
        sample1.damage(13);
        System.out.println(sample1);
        System.out.println();
        System.out.println("Killing Sample:");
        System.out.println();
        sample1.damage(13);
        System.out.println(sample1);
        System.out.println();
        System.out.println("Permanently killing sample:");
        System.out.println();
        sample1.deathSave(false);
        sample1.deathSave(false);
        sample1.deathSave(false);
        System.out.println(sample1);
    }
}