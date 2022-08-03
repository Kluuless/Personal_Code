
/**
 * Play a Game of Dreidel
 *
 * @author Mr. Funk
 * @version 1.0
 */
public class RunGame
{

    public static void main(String[] args)
    {
        String[] thePlayers = {"Amy", "Burt", "Cal"};
        Dreidel game = new Dreidel(thePlayers, 10);
        while(game.getWinner() == null)
        {
            game.playRound(); //all active players play once
            System.out.println(game);
        }
        System.out.println("The winner is : " + game.getWinner());
    }
}
