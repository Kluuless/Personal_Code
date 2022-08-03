import java.util.ArrayList;

/**
 * A bunch of utility static methods
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Utilities
{
    public static void randomNumber(int max)
    {
        System.out.println((int)(Math.random() * max) + 1);
    }

    public static boolean intListContains(int num, ArrayList<Integer> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i) == num)
            {
                return true;
            }
        }
        return false;
    }

    public static String listToString(ArrayList<String> letters)
    {
        String result = "";
        for (int i = 0; i < letters.size(); i++)
        {
            result += letters.get(i) + ", ";
        }
        result = result.substring(0,result.length()-2);
        return result;
    }

    public static boolean stringListContains(String string, ArrayList<String> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).equalsIgnoreCase(string))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * requires a getName() method
     */
    public static int index(String name, ArrayList<CharacterSimple> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getName().equals(name))
            {
                return i;
            }
        }
        return -1;
    }

    public static boolean isSorted(ArrayList<CharacterSimple> list)
    {
        boolean isSorted = true;
        for (int i = 0; i < list.size() - 1; i++)
        {
            if (list.get(i).getInitiative() < list.get(i+1).getInitiative())
            {
                isSorted = false;
            }
        }
        return isSorted;
    }

    public static ArrayList<CharacterSimple> copy(ArrayList<CharacterSimple> list)
    {
        ArrayList<CharacterSimple> result = new ArrayList<CharacterSimple>();
        for (int i = 0; i < list.size(); i++)
        {
            result.add(list.get(i));
        }
        return result;
    }

    public static ArrayList<CharacterSimple> merge(ArrayList<CharacterSimple> list1, ArrayList<CharacterSimple> list2)
    {
        ArrayList<CharacterSimple> result = new ArrayList<CharacterSimple>();
        ArrayList<CharacterSimple> copy1 = copy(list1);
        ArrayList<CharacterSimple> copy2 = copy(list2);
        while (copy1.size() != 0 && copy2.size() != 0)
        {
            if (copy1.get(0).getInitiative() > copy2.get(0).getInitiative())
            {
                result.add(copy1.remove(0));
            }
            else
            {
                result.add(copy2.remove(0));
            }
        }
        while (copy1.size() != 0)
        {
            result.add(copy1.remove(0));
        }
        while (copy2.size() != 0)
        {
            result.add(copy2.remove(0));
        }
        return result;
    }

    public static ArrayList<CharacterSimple> splitFirst(ArrayList<CharacterSimple> list)
    {
        if (list.size() == 1)
        {
            return list;
        }
        ArrayList<CharacterSimple> result = new ArrayList<CharacterSimple>();
        for (int i = 0; i < (list.size() + 1)/2; i++)
        {
            result.add(list.get(i));
        }
        return result;
    }

    public static ArrayList<CharacterSimple> splitSecond(ArrayList<CharacterSimple> list)
    {
        if (list.size() == 1)
        {
            return null;
        }
        ArrayList<CharacterSimple> result = new ArrayList<CharacterSimple>();
        for (int i = (list.size() + 1)/2; i < list.size(); i++)
        {
            result.add(list.get(i));
        }
        return result;
    }

    public static ArrayList<CharacterSimple> mergeSort(ArrayList<CharacterSimple> list)
    {
        if(isSorted(list))
        {
            return list;
        }
        else
        {
            return mergeSort(splitFirst(list), splitSecond(list));
        }
    }

    public static ArrayList<CharacterSimple> mergeSort(ArrayList<CharacterSimple> list1, ArrayList<CharacterSimple> list2)
    {
        if (!isSorted(list1))
        {
            list1 = mergeSort(splitFirst(list1), splitSecond(list1));
        }
        if (!isSorted(list2))
        {
            list2 = mergeSort(splitFirst(list2), splitSecond(list2));
        }
        return merge(list1,list2);
    }
}
