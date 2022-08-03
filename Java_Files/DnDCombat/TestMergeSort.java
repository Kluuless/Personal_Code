import java.util.ArrayList;
/**
 * Tests the MergeSort class
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class TestMergeSort
{
    public static void main(String[] args)
    {
        ArrayList<CharacterSimple> list = new ArrayList<CharacterSimple>();
        CharacterSimple eight = new CharacterSimple("eight", 8, 8);
        eight.setInitiative(8);
        list.add(eight);
        CharacterSimple five = new CharacterSimple("five", 5, 5);
        five.setInitiative(5);
        list.add(five);
        CharacterSimple three = new CharacterSimple("three", 3, 3);
        three.setInitiative(3);
        list.add(three);
        CharacterSimple seven = new CharacterSimple("seven", 7, 7);
        seven.setInitiative(7);
        list.add(seven);
        CharacterSimple ten = new CharacterSimple("ten", 10, 10);
        ten.setInitiative(10);
        list.add(ten);
        CharacterSimple one = new CharacterSimple("one", 1, 1);
        one.setInitiative(1);
        list.add(one);
        CharacterSimple two = new CharacterSimple("two", 2, 2);
        two.setInitiative(2);
        list.add(two);
        CharacterSimple six = new CharacterSimple("six", 6, 6);
        six.setInitiative(6);
        list.add(six);
        CharacterSimple four = new CharacterSimple("four", 4, 4);
        four.setInitiative(4);
        list.add(four);
        CharacterSimple nine = new CharacterSimple("nine", 9, 9);
        nine.setInitiative(9);
        list.add(nine);
        
        list = Utilities.mergeSort(list);
        System.out.println(list);
    }
}
