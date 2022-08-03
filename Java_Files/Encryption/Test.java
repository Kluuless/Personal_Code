
/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    public static void main(String[] args)
    {
        System.out.println((int)'A');
        System.out.println((int)'Z');
        System.out.println((int)'a');
        System.out.println((int)'z');
        
        System.out.println('A' + 3);
        System.out.println((char)('A' + 3));
        
        MorseCode a = new MorseCode("abc DEF123,?.[]");
        a.encrypt();
        System.out.println();
        System.out.println(a.getText());
        a.decrypt();
        System.out.println(a.getText());
    }
}
