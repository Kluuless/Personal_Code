
/**
 * Simulates a 10,000 Dreidel games to see if the first person has a slight advantage,
 * Each method has a different starting condition
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class ThousandSim
{
    /**
     * 3 players, each with 10 starting pieces
     */
    public static void startWithTenPieces()
    {
        //counters for number of wins
        int p1Wins = 0;
        int p2Wins = 0;
        int p3Wins = 0;

        //runs the game 10,000 times
        for (int i = 1; i <= 10000; i++)
        {
            //sets up the game
            String[] thePlayers = {"p1", "p2", "p3"};
            Dreidel game = new Dreidel(thePlayers, 10);
            
            //runs the game
            while(game.getWinner() == null)
            {
                game.playRound(); //all active players play once
            }
            
            //noting the winner
            if (game.getWinner().equals("p1"))
            {
                p1Wins++;
            }
            else if (game.getWinner().equals("p2"))
            {
                p2Wins++;
            }
            else
            {
                p3Wins++;
            }
        }
        
        //printing out the winner with their number of victories
        if (p1Wins > p2Wins && p1Wins > p3Wins)
        {
            System.out.println("p1 won the most, with " + p1Wins + " wins");
        }
        else if (p2Wins > p3Wins)
        {
            System.out.println("p2 won the most, with " + p2Wins + " wins");
        }
        else
        {
            System.out.println("p3 won the most, with " + p3Wins + " wins");
        }
    }
    
    /**
     * 3 players, each with 15 pieces
     */
    public static void startWithFifteenPieces()
    {
        //counters for number of wins
        int p1Wins = 0;
        int p2Wins = 0;
        int p3Wins = 0;

        //runs the game 10,000 times
        for (int i = 1; i <= 10000; i++)
        {
            //sets up the game
            String[] thePlayers = {"p1", "p2", "p3"};
            Dreidel game = new Dreidel(thePlayers, 15);
            
            //runs the game
            while(game.getWinner() == null)
            {
                game.playRound(); //all active players play once
            }
            
            //noting the winner
            if (game.getWinner().equals("p1"))
            {
                p1Wins++;
            }
            else if (game.getWinner().equals("p2"))
            {
                p2Wins++;
            }
            else
            {
                p3Wins++;
            }
        }
        
        //prints out the winner with amount of times they won
        if (p1Wins > p2Wins && p1Wins > p3Wins)
        {
            System.out.println("p1 won the most, with " + p1Wins + " wins");
        }
        else if (p2Wins > p3Wins)
        {
            System.out.println("p2 won the most, with " + p2Wins + " wins");
        }
        else
        {
            System.out.println("p3 won the most, with " + p3Wins + " wins");
        }
    }
    
    /**
     * 5 players, each with 10 pieces
     */
    public static void startWithFivePlayers()
    {
        //counter for number of victories
        int p1Wins = 0;
        int p2Wins = 0;
        int p3Wins = 0;
        int p4Wins = 0;
        int p5Wins = 0;

        //runs the game 10,000 times with 5 players, noting each time who wins.
        for (int i = 1; i <= 10000; i++)
        {
            //setting up the game
            String[] thePlayers = {"p1", "p2", "p3", "p4", "p5"};
            Dreidel game = new Dreidel(thePlayers, 10);
            
            //running the game
            while(game.getWinner() == null)
            {
                game.playRound(); //all active players play once
            }
            
            //noting the winner
            if (game.getWinner().equals("p1"))
            {
                p1Wins++;
            }
            else if (game.getWinner().equals("p2"))
            {
                p2Wins++;
            }
            else if (game.getWinner().equals("p3"))
            {
                p3Wins++;
            }
            else if (game.getWinner().equals("p4"))
            {
                p4Wins++;
            }
            else
            {
                p5Wins++;
            }
        }
        
        //printing out the winner with how many times they won
        if (p1Wins > p2Wins && p1Wins > p3Wins && p1Wins > p4Wins && p1Wins > p5Wins)
        {
            System.out.println("p1 won the most, with " + p1Wins + " wins");
            System.out.println("p5 won " + p5Wins + " times");
        }
        else if (p2Wins > p3Wins && p2Wins > p4Wins && p2Wins > p5Wins)
        {
            System.out.println("p2 won the most, with " + p2Wins + " wins");
        }
        else if (p3Wins > p4Wins && p3Wins > p5Wins)
        {
            System.out.println("p3 won the most, with " + p3Wins + " wins");
        }
        else if (p4Wins > p5Wins)
        {
            System.out.println("p4 won the most, with " + p4Wins + " wins");
        }
        else
        {
            System.out.println("p5 won the most, with " + p5Wins + " wins");
        }
    }
    
    /**
     * 3 players, the first with 5 pieces, the second with 10, and the third with 20
     */
    public static void startDifferentAmounts()
    {
        //counter for the victories of each player
        int p1Wins = 0;
        int p2Wins = 0;
        int p3Wins = 0;

        //runs the game 10,000 times
        for (int i = 1; i <= 10000; i++)
        {
            //sets up the game
            String[] thePlayers = {"p1", "p2", "p3"};
            Dreidel game = new Dreidel(thePlayers, 10);
            
            //sets p1's gelt to 5
            game.setGelt(0, 5);
            
            //sets p3's gelt to 20
            game.setGelt(2,20);
            
            //runs the game
            while(game.getWinner() == null)
            {
                game.playRound(); //all active players play once
            }
            
            //noting the winner
            if (game.getWinner().equals("p1"))
            {
                p1Wins++;
            }
            else if (game.getWinner().equals("p2"))
            {
                p2Wins++;
            }
            else
            {
                p3Wins++;
            }
        }
        
        //printing out who won the most with their amount of victories
        if (p1Wins > p2Wins && p1Wins > p3Wins)
        {
            System.out.println("p1 won the most, with " + p1Wins + " wins");
        }
        else if (p2Wins > p3Wins)
        {
            System.out.println("p2 won the most, with " + p2Wins + " wins");
        }
        else
        {
            System.out.println("p3 won the most, with " + p3Wins + " wins");
        }
    }
}
