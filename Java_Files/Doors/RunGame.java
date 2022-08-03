import java.util.Scanner;
/**
 * Simulates the Monty Hall Problem
 *
 * @author Kyle Luu
 * @version Xmas 2017
 */
public class RunGame
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        Problem game = new Problem();
        System.out.println("There are 3 doors. Behind 1 is a car, behind the others are sheeps.");
        System.out.println("If you choose the door with the car, you win it!");
        System.out.print("Which door would you like to choose? Type the number of the door (1-3): ");
        int chosen = in.nextInt();

        game.choose(chosen);

        System.out.println();
        System.out.println("WAIT! Before we move on, one of the two other doors that has a sheep will be revealed.");

        System.out.println("A door with the sheep behind is: ");
        int sheep;
        if (chosen == 1)
        {
            if (game.reveal(2).equals("car"))
            {   sheep = 3;   }
            else
            {   sheep = 2;   }
        }
        else if (chosen == 2)
        {
            if (game.reveal(1).equals("car"))
            {   sheep = 3;   }
            else
            {   sheep = 1;   }
        }
        else
        {
            if (game.reveal(1).equals("car"))
            {   sheep = 2;   }
            else
            {   sheep = 1;   }
        }
        System.out.println("Door " + sheep + ".");

        System.out.print("Would you like to switch to the unrevealed door (Y/N)? ");
        String change = in.next();

        if (change.equals("Y"))
        {   if (chosen == 1)
            {   if (sheep == 2)
                {   
                    game.switchChosen(3);
                    chosen = 3;
                }
                else
                {   
                    game.switchChosen(2);
                    chosen = 2;
                }
            }
            else if (chosen == 2)
            {   if (sheep == 1)
                {   
                    game.switchChosen(3);
                    chosen = 3;
                }
                else
                {   
                    game.switchChosen(1);
                    chosen = 1;
                }
            }
            else
            {   if (sheep == 2)
                {   
                    game.switchChosen(1);
                    chosen = 1;
                }
                else
                {   
                    game.switchChosen(2);
                    chosen = 2;
                }
            }
        }
        if (change.equals("Y"))
        {   System.out.println("Doors switched. You now are choosing Door " + chosen + ".");  }
        else
        {   System.out.println("Doors not changed. Reminder, you are choosing Door " + chosen + "."); }
        
        System.out.print("Type something when you are ready to reveal Door " + chosen + ".");
        in.next();
        
        System.out.println("Behind your door is a... " + game.show(chosen) + "!");
        System.out.println();
        
        String unrevealed;
        if (chosen == 1)
        {   if (sheep == 2)
            {   unrevealed = game.show(3);  }
            else
            {   unrevealed = game.show(2);  }
        }
        else if (chosen == 2)
        {   if (sheep == 1)
            {   unrevealed = game.show(3);  }
            else
            {   unrevealed = game.show(1);  }
        }
        else
        {   if (sheep == 1)
            {   unrevealed = game.show(2);  }
            else
            {   unrevealed = game.show(1);  }
        }
        System.out.println("Behind the unrevealed door is a " + unrevealed + ".");
    }
}
