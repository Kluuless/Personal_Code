
/**
 * Each of the three doors can have a sheep or a car behind it (Monty Hall Problem)
 *
 * @author Kyle Luu
 * @version Xmas 2017
 */
public class Problem
{
    // instance variables - replace the example below with your own
    private Door[] doors;

    /**
     * Constructor for objects of class Doors
     */
    public Problem()
    {
        // initialise instance variables
        doors = new Door[3];
        int rand = (int)(Math.random() * 3);
        if (rand == 0)
        {
            doors[0] = new Door("car");
            doors[1] = new Door("sheep");
            doors[2] = new Door("sheep");
        }
        else if (rand == 1)
        {
            doors[0] = new Door("sheep");
            doors[1] = new Door("car");
            doors[2] = new Door("sheep");
        }
        else 
        {
            doors[0] = new Door("sheep");
            doors[1] = new Door("sheep");
            doors[2] = new Door("car");
        }
    }
    
    /**
     * @param  one  what's door door one
     * @param  two  what's door door two
     * @param  three  what's door door three
     */
    public Problem (String one, String two, String three)
    {
        doors[0] = new Door(one);
        doors[1] = new Door(two);
        doors[2] = new Door(three);
    }

    public String reveal(int num)
    {
        if (num == 1)
        {
            return doors[0].reveal();
        }
        else if (num == 2)
        {
            return doors[1].reveal();
        }
        else
        {
            return doors[2].reveal();
        }
    }
    
    public String show(int num)
    {
        if (num == 1)
        {
            return doors[0].getBehind();
        }
        else if (num == 2)
        {
            return doors[1].getBehind();
        }
        else
        {
            return doors[2].getBehind();
        }
    }
    
    public void choose(int num)
    {
        if (num == 1)
        {
            doors[0].choose();
        }
        else if (num == 2)
        {
            doors[1].choose();
        }
        else
        {
            doors[2].choose();
        }
    }
    
    public void switchChosen(int num)
    {
        doors[0].unchoose();
        doors[1].unchoose();
        doors[2].unchoose();
        if (num == 1)
        {
            doors[0].choose();
        }
        else if (num == 2)
        {
            doors[1].choose();
        }
        else
        {
            doors[2].choose();
        }
    }
}
