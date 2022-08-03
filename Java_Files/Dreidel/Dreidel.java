import java.util.ArrayList;
/**
 * Dreidel Game
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Dreidel
{
    private ArrayList<Player> players; //what is the instance variable type?
    private int pot;

    /**
     * Constructor for objects of class Dreidel
     */
    public Dreidel(String[] whoIsPlaying, int initialNumberOfPiecesPerPlayer)
    {
        players = new ArrayList<Player>(); //initialize the ArrayList
        for (int i = 0; i < whoIsPlaying.length; i++)
        {
            Player temp = new Player(whoIsPlaying[i], initialNumberOfPiecesPerPlayer);
            players.add(temp);
        }
    }

    //All players "shtel"
    public void shtel()
    {
        for (int i = 0; i < players.size(); i++)
        {
            if (!players.get(i).isOut()) //for every player still active, they lose one piece and the pot gains 1
            {
                players.get(i).shtel();
                pot++;
            }
        }
    }

    //simulates rolling the dreidel
    private static String roll()
    {
        int rand = (int)(Math.random() * 4); //generates a random number 0-3 (four possible numbers)
        if (rand == 1)
        {
            return "nisht";
        }
        else if (rand == 2)
        {
            return "gantz";
        }
        else if (rand == 3)
        {
            return "halb";
        }
        else //when rand = 0
        {
            return "shtel";
        }
    }

    //all active players "shtel" and then play once
    public void playRound()
    {
        shtel(); //everyone "shtel"
        for (int i = 0; i < players.size(); i++) //for every person
        {
            String result = roll(); //roll to get a random result

            /**
             * For testing purposes:
             * String playerString = players.get(i).toString();
             * int colonLocation = playerString.indexOf(": ");
             * String playerName = playerString.substring(0,colonLocation);
             * System.out.println(playerName + "'s turn: " + result);  
             */

            if (result.equals("nisht") || players.get(i).isOut()) 
            {} //nothing happens if they are out or roll a "nisht"
            else if (result.equals("gantz"))
            {   //"gantz" means empty the pot
                players.get(i).add(pot);
                pot = 0;
            }
            else if (result.equals("halb"))
            {   //"halb" means take the larger half of the pot
                int halfOfPot = (pot + 1) / 2;
                players.get(i).add(halfOfPot);
                pot -= halfOfPot;
            }
            else
            {   //shtel means put one piece into the pot
                players.get(i).shtel();
                pot++;
            }

            if (pot == 0 || pot == 1)
            {  //if the pot is ever empty or has 1 piece left, everyone must "shtel"
                shtel();
                //System.out.println ("Pot refilled");
            }
            /**
             * For testing purposes:
             * playerString = players.get(i).toString();
             * String amountLeft = playerString.substring(colonLocation + 2);
             * System.out.println(playerName + " has " + amountLeft + " pieces left"); 
             * System.out.println();
             */
        }
    }

    //include all players and the value in the pot
    public String toString()
    {
        String thePlayers = "";
        boolean isFirst = true;
        for (int i = 0; i < players.size(); i++)
        {
            if (!isFirst && !players.get(i).isOut())
            {
                thePlayers += ", ";
            }
            if (!players.get(i).isOut())
            {
                thePlayers += players.get(i).toString();
                isFirst = false;
            }
        }

        if (pot == 1)
        {
            return "The active players: " + thePlayers + "; " + pot + " piece in pot.";
        }
        else
        {
            return "The active players: " + thePlayers + "; " + pot + " pieces in pot.";
        }
    }

    //If no winner yet return null, otherwise return the winner's name
    public String getWinner()
    {
        int amountIsIn = 0;
        int indexOfWinner = -1;
        for (int i = 0; i < players.size(); i++)
        {
            if (!players.get(i).isOut())
            {
                amountIsIn++;
                indexOfWinner = i;
            }
        }

        if (amountIsIn == 1)
        {
            String playerString = players.get(indexOfWinner).toString();
            int colonLocation = playerString.indexOf(": ");
            playerString = playerString.substring(0,colonLocation);
            return playerString;
        }
        else
        {
            return null;
        }
    }

    //increases or reduces a player's gelt by an amount
    public void setGelt(int location, int finalGelt)
    {
        int colonLocation = players.get(location).toString().indexOf(": ");
        int amountInGelt = Integer.parseInt(players.get(location).toString().substring(colonLocation + 2));
        if (finalGelt > amountInGelt)
        {
            players.get(location).add(finalGelt - amountInGelt);
        }
        else if (finalGelt < amountInGelt)
        {
            for (int i = 1; i <= (finalGelt - amountInGelt); i++)
            {
                players.get(location).shtel();
            }
        }
    }
}
