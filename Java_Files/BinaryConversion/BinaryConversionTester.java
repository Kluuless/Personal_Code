/**
 * Tester for class BinaryConversionTester
 * 
 * @author Mr. Funk
 * @version 1.0
 */
public class BinaryConversionTester
{
    public static void main(String[] args)
    {
        int n = 57;
        int base = 10;
        BinaryConversion myNum = new BinaryConversion(n);
        System.out.println("toString: expect: 57 in base 10\t\t" + myNum.toString());
        System.out.println("toBase2: expect: true\t\t\t" + myNum.toBase2());
        System.out.println("toBase2: expect: false\t\t\t" + myNum.toBase2());
        System.out.println("toString: expect: 111001 in base 2\t" + myNum.toString());
        System.out.println("toBase10: expect: true\t\t\t" + myNum.toBase10());
        System.out.println("toBase2: expect: false\t\t\t" + myNum.toBase10());
        System.out.println("toString: expect: 57 in base 10\t\t" + myNum.toString());
    }
}
