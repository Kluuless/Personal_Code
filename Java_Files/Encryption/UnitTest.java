import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class UnitTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class UnitTest
{
    /**
     * Default constructor for test class UnitTest
     */
    public UnitTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void TestReverse()
    {
        Reverse reverse1 = new Reverse("human being");
        assertEquals("human being", reverse1.getText());
        assertEquals(false, reverse1.isEncrypted());
        reverse1.encrypt();
        assertEquals(true, reverse1.isEncrypted());
        assertEquals("gnieb namuh", reverse1.getText());
        reverse1.decrypt();
        assertEquals(false, reverse1.isEncrypted());
        assertEquals("human being", reverse1.getText());
        Reverse reverse2 = new Reverse("");
        assertEquals("", reverse2.getText());
        assertEquals(false, reverse2.isEncrypted());
        reverse2.encrypt();
        assertEquals(true, reverse2.isEncrypted());
        assertEquals("", reverse2.getText());
        reverse2.decrypt();
        assertEquals(false, reverse2.isEncrypted());
        assertEquals("", reverse2.getText());
    }

    @Test
    public void TestCaesarShift()
    {
        CaesarShift caesarSh1 = new CaesarShift("Hello There");
        assertEquals(false, caesarSh1.isEncrypted());
        assertEquals("Hello There", caesarSh1.getText());
        caesarSh1.encrypt();
        assertEquals(true, caesarSh1.isEncrypted());
        assertEquals("Khoor Wkhuh", caesarSh1.getText());
        caesarSh1.decrypt();
        assertEquals(false, caesarSh1.isEncrypted());
        assertEquals("Hello There", caesarSh1.getText());
        CaesarShift caesarSh2 = new CaesarShift("Zany Ivy", 25);
        assertEquals("Zany Ivy", caesarSh2.getText());
        caesarSh2.encrypt();
        assertEquals("Yzmx Hux", caesarSh2.getText());
        caesarSh2.decrypt();
        assertEquals("Zany Ivy", caesarSh2.getText());
        CaesarShift caesarSh3 = new CaesarShift("java language", 11);
        caesarSh3.encrypt();
        assertEquals("ulgl wlyrflrp", caesarSh3.getText());
        CaesarShift caesarSh4 = new CaesarShift("");
        caesarSh4.encrypt();
        assertEquals("", caesarSh4.getText());
        caesarSh4.decrypt();
        assertEquals("", caesarSh4.getText());
    }

    @Test
    public void TestMyCrazyCipher()
    {
        MyCrazyCipher myCrazyCipher1 = new MyCrazyCipher("carport", 2);
        assertEquals(false, myCrazyCipher1.isEncrypted());
        //  assertEquals("carpool", myCrazyCipher1.getText());
        myCrazyCipher1.encrypt();
        assertEquals(true, myCrazyCipher1.isEncrypted());

        String temp = myCrazyCipher1.getText();
        String encrypted_1 = "";
        for(int i = 0; i < temp.length()-1; i += 2)
        {
            encrypted_1 += temp.substring(i, i+1);
        }       
        //System.out.println(encrypted_1 + ", " + myCrazyCipher1.getText());
        assertEquals("xzikli", encrypted_1);
        System.out.println(myCrazyCipher1.getText() + " --> " + temp);
        myCrazyCipher1.decrypt();
        assertEquals(false, myCrazyCipher1.isEncrypted());
        assertEquals("carport", myCrazyCipher1.getText());

        //System.out.println("carport passed");

        MyCrazyCipher myCrazyCipher2 = new MyCrazyCipher("Waterfall", 5);
        //System.out.println("Testing getText()");
        assertEquals("Waterfall", myCrazyCipher2.getText());
        //System.out.println("getText() passed");

        myCrazyCipher2.encrypt();
        String temp2 = myCrazyCipher2.getText().substring(0,4)+myCrazyCipher2.getText().substring(5,9)+ "o";
        //myCrazyCipher2.encrypt();
        //System.out.println("1: " + temp2);
        assertEquals("Dzgviuzoo", temp2);
        System.out.println(myCrazyCipher2.getText() + " --> " + temp);        
        myCrazyCipher2.decrypt();
        assertEquals("Waterfall", myCrazyCipher2.getText());

        //System.out.println("Waterfall passed");

        MyCrazyCipher myCrazyCipher3 = new MyCrazyCipher("COMPSCI-FEVER!", 10);
        assertEquals("COMPSCI-FEVER!", myCrazyCipher3.getText());

        myCrazyCipher3.encrypt();
        //System.out.println(myCrazyCipher3.getText());
        String temp3 = myCrazyCipher3.getText().substring(0,9)+ "VEVI";
        //System.out.println(temp3 + ", " + myCrazyCipher3.getText());
        assertEquals("XLNKHXR-UVEVI", temp3);
        System.out.println(myCrazyCipher3.getText() + " --> " + myCrazyCipher3.getText());        
        myCrazyCipher3.decrypt();
        assertEquals("COMPSCI-FEVER!", myCrazyCipher3.getText());        

        MyCrazyCipher emptyOne = new MyCrazyCipher("",0);
        emptyOne.encrypt();
        assertEquals("", emptyOne.getText());
        emptyOne.decrypt();
        assertEquals("", emptyOne.getText());
    }

    @Test
    public void TestMorseCode()
    {
        MorseCode test1 = new MorseCode("abc DEF123,?.[]");
        assertEquals("abc DEF123,?.[]", test1.getText());
        assertEquals(false, test1.isEncrypted());
        test1.encrypt();
        assertEquals(true, test1.isEncrypted());
        assertEquals(".-/-.../-.-./ /-.././..-./..---/...--/....-/--..--/..--../.-.-.-/[/]", test1.getText());
        test1.decrypt();
        assertEquals("ABC DEF123,?.[]", test1.getText());
        assertEquals(false, test1.isEncrypted());
        
        MorseCode emptyOne = new MorseCode("");
        assertEquals(false, emptyOne.isEncrypted());
        assertEquals("", emptyOne.getText());
        emptyOne.encrypt();
        assertEquals("", emptyOne.getText());
        assertEquals(true, emptyOne.isEncrypted());
        emptyOne.decrypt();
        assertEquals(false, emptyOne.isEncrypted());
        assertEquals("", emptyOne.getText());
    }
}
