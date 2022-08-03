import java.util.Scanner;
import java.util.ArrayList;
/**
 * A simpler version of combat
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class CombatSimple
{
    private static boolean yesNo(String answer)
    {
        if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    private static int indexOf(String name, ArrayList<CharacterSimple> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).toString().equalsIgnoreCase(name))
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<CharacterSimple> characters = new ArrayList<CharacterSimple>();
        System.out.print("How many players? ");
        int numOfChars = in.nextInt();
        System.out.println();

        for (int i = 0; i < numOfChars; i++)
        {
            System.out.print("Enter the character's name: ");
            String name = in.next();
            System.out.print("Enter the character's max health: ");
            int maxHealth = in.nextInt();
            System.out.print("Enter the character's current health: ");
            int health = in.nextInt();
            System.out.print("Enter the character's initiative: ");
            int initiative = in.nextInt();
            System.out.print("Is this character an enemy? ");
            boolean isEnemy = yesNo(in.next());

            characters.add(new CharacterSimple(name, maxHealth, health, isEnemy));
            characters.get(i).setInitiative(initiative);
            System.out.println("Character added.");
        }

        characters = Utilities.mergeSort(characters);
        System.out.println("\nAll characters added.");

        int turn = 0;
        boolean battleOver = false;
        while (!battleOver)
        {
            if (turn % numOfChars == 0)
            {
                System.out.println();
                System.out.println("It is round " + (turn % numOfChars) + ".");
                System.out.print("Enter any key to continue: ");
                String useless = in.next();
                System.out.println();
                System.out.println("\nIt is round " + turn % numOfChars + ".\n");
            }

            int currentTurn = turn % numOfChars;
            System.out.println("It is " + characters.get(currentTurn) + "'s turn.");

            if (characters.get(currentTurn).isUnconscious())
            {
                System.out.println(characters.get(currentTurn) + " is unsconscious.");
                System.out.println("Make a death (constitution) saving throw.");
                Do you 
            }
            else
            {
                System.out.print("Do you want to attack someone? ");
                boolean attacking = yesNo(in.next());

                if (attacking)
                {
                    while (attacking)
                    {
                        System.out.print("Who are you attacking? ");
                        CharacterSimple target = characters.get(indexOf(in.next(),characters));
                        System.out.print("\nRoll to hit. \nDo you hit? " );
                        boolean hit = yesNo(in.next());
                        if (hit)
                        {
                            System.out.print("\nHow much damage did you deal? ");
                            int amount = in.nextInt();
                            int dead = target.damage(amount);
                            if (dead == 2)
                            {
                                System.out.println("\n" + target + " is dead.");
                            }
                            else if (dead == 1)
                            {
                                System.out.println("\n" + target + " is unconscious.");
                            }
                            else
                            {
                                System.out.println("\n" + target + " now has " + target.getHealth() + " health.");
                            }
                        }
                        else
                        {
                            System.out.println("Whoops! You missed!");
                        }
                        System.out.print("\nDo you wish to attack someone else? ");
                        boolean attackOther = yesNo(in.next());
                        attacking = attackOther;
                    }
                }
                else
                {
                    System.out.println("\nAre you going to heal someone? ");
                    boolean healing = yesNo(in.next());
                    if (healing)
                    {
                        System.out.print("\nWho do you want to heal? ");
                        String forHealing = in.next();
                        if (forHealing.equalsIgnoreCase("Myself") || forHealing.equalsIgnoreCase("Me"))
                        {
                            forHealing = characters.get(currentTurn).toString();
                        }
                        CharacterSimple target = characters.get(indexOf(forHealing,characters));
                        if (!forHealing.equalsIgnoreCase(characters.get(currentTurn).toString()))
                        {
                            System.out.print("\nMake a medicine check. Do you succeed? ");
                            boolean medicine = yesNo(in.next());
                            if (medicine)
                            {
                                System.out.print("\nHow much do you heal them for? ");
                                int amount = in.nextInt();
                                target.heal(amount);
                                System.out.println(target + " now has " + target.getHealth() + " health.");
                            }
                            else
                            {
                                System.out.print("\nWhoops! You fail to heal " + target + "!");
                            }
                        }
                        else
                        {
                            System.out.print("\nHow much do you heal for? ");
                            int amount = in.nextInt();
                            target.heal(amount);
                            System.out.println("\nYou now have " + target.getHealth() + " health.");
                        }
                    }
                }

                boolean enemiesDead = true;
                for (int i = 0; i < characters.size(); i++)
                {
                    if (characters.get(i).isEnemy() && !characters.get(i).isDead())
                    {
                        enemiesDead = false;
                    }
                }
                if (enemiesDead)
                {
                    battleOver = true;
                }
                else
                {
                    System.out.print("\nIs the battle over? ");
                    battleOver = yesNo(in.next());
                    turn++;
                    System.out.println();
                    System.out.println("*************************************************************");
                    System.out.println();
                }
            }
        }

        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();

        System.out.println("The battle is over. \nBattle synopsis:\n");
        for (int i = 0; i < characters.size(); i++)
        {
            if (characters.get(i).isDead())
            {
                System.out.println(characters.get(i) + " is dead.");
            }
            else
            {
                if (characters.get(i).isUnconscious())
                {
                    System.out.println(characters.get(i) + " has 0 health and is unconscious.");
                }
                else
                {
                    System.out.println(characters.get(i) + " has " + characters.get(i).getHealth() + " health.");
                }
            }
        }
    }
}
