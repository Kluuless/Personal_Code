/**
 * BowlingScore - the scorecard for one bowler
 * 
 * @author Mr. Funk 
 * @version 1.0
 */
public class BowlingScore implements Comparable<BowlingScore>
{
    private String bowler;
    private String[] rolls; // each pair of characters in rolls is a frame 
    // except there may be 3 digits for frame 10
    private String[] oldRolls; //for print()

    /**
     * Constructor for objects of class BowlingScore
     */
    public BowlingScore(String bowler, String[] rolls)
    {   
        this.bowler = bowler;
        this.rolls = rolls;
        for (int i = 0; i < rolls.length; i++)
        {
            if (rolls[i] == null)
            {
                rolls[i] = "";
            }
            if (rolls[i].indexOf("0") != -1)
            {
                char[] theRoll = new char[rolls.length];
                String result = "";
                for (int j = 0; j < rolls[i].length(); j++)
                {
                    theRoll[j] = rolls[i].charAt(j);
                    if (theRoll[j] == '0')
                    {
                        theRoll[j] = '-';
                    }
                    result += theRoll[j];
                }
                rolls[i] = result;
            }
        }
        oldRolls = rolls;
    }    

    public BowlingScore(String bowler)
    {
        this.bowler = bowler;
        this.rolls = new String[10];
        for (int i = 0; i < 10; i++)
        {
            rolls[i] = "";
        }
        oldRolls = new String[10];
    }

    /**
     * getScore - calculates score of game
     * 
     * @precondition - the data in rolls represents a valid, completed game
     * @return - the scored result of the game, -1 if game is unfinished
     */
    public int getScore()
    {
        if (getOpenFrame() != -1)
        {
            return -1;
        }

        String[] rollsCopy = new String[rolls.length];
        for (int i = 0; i < rolls.length; i++)
        {
            rollsCopy[i] = rolls[i];
            char[] roll = new char[rollsCopy[i].length()];
            for (int j = 0; j < roll.length; j++)
            {
                roll[j] = rollsCopy[i].charAt(j);
                if (roll[j] == '0')
                {
                    roll[j] = '-';
                }
            }
            rollsCopy[i] = "";
            for (int j = 0; j < roll.length; j++)
            {
                rollsCopy[i] += roll[j];
            }
        }
        BowlingScore copy = new BowlingScore("Copy",rollsCopy);
        if (copy.isValidGame())
        {
            int total = 0;
            for (int i = 0; i < 10; i++)
            {
                total += copy.getFrameScore(i);
                //System.out.println(getFrameScore(i) + "\t" + total);
            }
            return total;
        }
        else
        {
            return -1;
        }
    }

    /**
     * @precondition frameNumber >= 0 and <= 9 (the original frame - 1)
     */
    public int getFrameScore(int frameNumber)
    {
        String firstRoll = rolls[frameNumber].substring(0,1);
        String secondRoll = "";
        if (!firstRoll.equals("X"))
        {
            secondRoll = rolls[frameNumber].substring(1,2);
        }
        if (frameNumber < 9)
        {
            int first = -1;
            int second = -1;
            if (!firstRoll.equals("-") && !firstRoll.equals("X"))
            {
                first = Integer.parseInt(firstRoll);
            }
            if (firstRoll.equals("-"))
            {
                first = 0;
            }
            if (!secondRoll.equals("-") && !secondRoll.equals("/") && !secondRoll.equals(""))
            {
                second = Integer.parseInt(secondRoll);
            }
            if (secondRoll.equals("-"))
            {
                second = 0;
            }

            if (firstRoll.equals("X"))
            {
                if (frameNumber + 1 == 9)
                {
                    String nextRoll = rolls[frameNumber + 1].substring(0,1);
                    String afterRoll = rolls[frameNumber + 1].substring(1,2);
                    int nextFirst = 0;
                    int nextSecond = 0;
                    if (nextRoll.equals("X"))
                    {
                        nextFirst = 10;
                    }
                    else if (!nextRoll.equals("-"))
                    {
                        nextFirst = Integer.parseInt(nextRoll);
                    }
                    if (afterRoll.equals("X"))
                    {
                        nextSecond = 10;
                    }
                    else if (afterRoll.equals("/"))
                    {
                        nextSecond = 10 - nextFirst;
                    }
                    else if (!nextRoll.equals("-"))
                    {
                        nextSecond = Integer.parseInt(afterRoll);
                    }
                    return 10 + nextFirst + nextSecond;
                }
                String nextRoll = rolls[frameNumber + 1].substring(0,1);
                if (nextRoll.equals("X"))
                {
                    String afterNext = rolls[frameNumber + 2].substring(0,1);
                    if (afterNext.equals("X"))
                    {
                        return 30;
                    }
                    else if (afterNext.equals("-"))
                    {
                        return 20;
                    }
                    else
                    {
                        return 20 + Integer.parseInt(afterNext);
                    }
                }
                String afterNext = rolls[frameNumber + 1].substring(1,2);
                if (nextRoll.equals("-"))
                {
                    if (afterNext.equals("-"))
                    {
                        return 10;
                    }
                    else if (afterNext.equals("/"))
                    {
                        return 20;
                    }
                    else
                    {
                        return 10 + Integer.parseInt(afterNext);
                    }
                }
                else if (afterNext.equals("/"))
                {
                    return 20;
                }
                else
                {
                    return 10 + Integer.parseInt(rolls[frameNumber + 1].substring(0,1)) + Integer.parseInt(rolls[frameNumber + 1].substring(1,2));
                }
            }

            else if (secondRoll.equals("/"))
            {
                String nextRoll = rolls[frameNumber + 1].substring(0,1);
                if (nextRoll.equals("X"))
                {
                    return 20;
                }
                else if (nextRoll.equals("-"))
                {
                    return 10;
                }
                else
                {
                    return 10 + Integer.parseInt(rolls[frameNumber + 1].substring(0,1));
                }
            }
            else
            {
                return first + second;
            }
        }
        else
        {
            firstRoll = rolls[9].substring(0,1);
            secondRoll = rolls[9].substring(1,2);
            String thirdRoll;
            if (rolls[9].length() == 2)
            {
                thirdRoll = "";
            }
            else
            {
                thirdRoll = rolls[9].substring(2,3);
            }
            int first = -1;
            int second = -1;
            int third = -1;

            if (firstRoll.equals("X"))
            {
                first = 10;
            }
            else if (firstRoll.equals("-"))
            {
                first = 0;
            }
            else
            {
                first = Integer.parseInt(firstRoll);
            }

            if (secondRoll.equals("-"))
            {
                second = 0;
            }
            else if (secondRoll.equals("X"))
            {
                second = 10;
            }
            else if (secondRoll.equals("/"))
            {
                second = 10 - first;
            }
            else
            {
                second = Integer.parseInt(secondRoll);
            }

            if (thirdRoll.equals("") || thirdRoll.equals("-"))
            {
                third = 0;
            }
            else if (thirdRoll.equals("X"))
            {
                third = 10;
            }
            else if (thirdRoll.equals("/"))
            {
                third = 10 - second;
            }
            else
            {
                third = Integer.parseInt(thirdRoll);
            }

            return first + second + third;
        }
    }

    /**
     * compareTo - For a completed game, compare by score
     *        - A complete game is considered larger any incomplete game
     *        - For an incomplete game, compare by number of completed frames 
     * @precondition – the game is a valid game, complete or incomplete
     */    
    public int compareTo(BowlingScore other)
    {
        if (this.getOpenFrame() != -1 && other.getOpenFrame() != -1)
        {
            int thisFrame = this.getOpenFrame();
            int otherFrame = other.getOpenFrame();
            if (thisFrame == -1)
            {
                thisFrame = 11;
            }
            if (otherFrame == -1)
            {
                otherFrame = 11;
            }

            return thisFrame - otherFrame;
        }
        else
        {
            return this.getScore() - other.getScore();
        }
    }

    /**
     * addFrame  - add the result of two rolls to the first (next) open frame
     * @precondition - the two rolls represents a valid frame
     *               - the game is not yet finished and not in the 10th frame
     *               - a strike is recorded as firstRoll == “X” and secondRoll == “”
     * @return - true if add was successful, false otherwise (preconditions not met)
     *         - if false, no game update occurs    
     */    
    public boolean addFrame(String firstRoll, String secondRoll)
    {
        if (this.getOpenFrame() == -1 || this.getOpenFrame() == 10)
        {
            return false;
        }
        if (firstRoll.equals("0"))
        {
            firstRoll = "-";
        }
        if (secondRoll.equals("0"))
        {
            secondRoll = "-";
        }
        if (isValidFrame(firstRoll, secondRoll))
        {
            rolls[this.getOpenFrame()-1] = firstRoll + secondRoll;
        }
        return isValidFrame(firstRoll, secondRoll);
    }

    public static boolean isValidFrame(String firstRoll, String secondRoll)
    {
        if (firstRoll.equals("") || firstRoll.equals("/"))
            return false;
        if (firstRoll.equals("X") && !secondRoll.equals(""))
            return false;
        int first = -1;
        if (!firstRoll.equals("X") && !firstRoll.equals("-"))
            first = Integer.parseInt(firstRoll);
        int second = -1;
        if (!secondRoll.equals("/") && !secondRoll.equals("-") && !secondRoll.equals(""))
            second = Integer.parseInt(secondRoll);

        if (first + second > 9)
        {
            return false;
        }
        if (firstRoll.equals("X"))
        {   if (secondRoll.equals(""))
                return true;
            else 
                return false;
        }
        if (secondRoll.equals("/"))
        {   if (firstRoll.equals("-"))
                return true;
            else if (first > 0 && first < 10)
                return true;
            else
                return false;
        }
        if (firstRoll.equals("-"))
        {   if (secondRoll.equals("-"))
                return true;
            else if (second > 0 && second < 10)
                return true;
            else
                return false;
        }
        if (secondRoll.equals("-"))
        {   if (first > 0 && second < 10)
                return true;
            else
                return false;
        }
        if (first <= 0 || first >= 10 || second <= 0 || first >= 10)
            return false;
        else
            return true;
    }

    /**
     * addFrame  - add the result of two or three rolls to the 10th frame
     * @precondition - the two rolls represents a valid frame
     *              - the game is in the 10th frame
     *              - if there is not "mark" (strike or spare) before, thirdRoll == ""
     * @return - true if add was successful, false otherwise (preconditions not met)    
     *         - if false, no game update occurs     
     */    
    public boolean addFrame(String firstRoll, String secondRoll, String thirdRoll)
    {
        if (this.getOpenFrame() != 10)
        {
            return false;
        }
        if (isValidFrame(firstRoll, secondRoll, thirdRoll))
        {
            rolls[9] = firstRoll + secondRoll + thirdRoll;
        }
        return isValidFrame(firstRoll, secondRoll, thirdRoll);
    }

    public static boolean isValidFrame(String firstRoll, String secondRoll, String thirdRoll)
    {
        if (firstRoll.equals("") || secondRoll.equals("") || firstRoll.equals("/"))
        {   return false;}
        int first = -1;
        if (!firstRoll.equals("X") && !firstRoll.equals("-"))
            first = Integer.parseInt(firstRoll);
        int second = -1;
        if (!secondRoll.equals("X") && !secondRoll.equals("/") && !secondRoll.equals("-") && !secondRoll.equals(""))
            second = Integer.parseInt(secondRoll);
        int third = -1;
        //System.out.println(thirdRoll + " " + thirdRoll.equals("X"));
        if (!thirdRoll.equals("X") && !thirdRoll.equals("/") && !thirdRoll.equals("-") && !thirdRoll.equals(""))
            third = Integer.parseInt(thirdRoll);
        if (thirdRoll.equals(""))
        {   return isValidFrame(firstRoll,secondRoll);}
        else if (firstRoll.equals("X"))
        {   if (!secondRoll.equals("X"))
            {   return isValidFrame(secondRoll,thirdRoll);}
            else if (thirdRoll.equals("X") || thirdRoll.equals("/") || thirdRoll.equals("-"))
            {   return true;}
            else if (third <= 0 || third >= 10)
            {   return false;}
            else
            {   return true;}
        }
        else if (secondRoll.equals("/"))
        {   if (!isValidFrame(firstRoll,secondRoll))
            {   return false;}
            else if (thirdRoll.equals("/") || firstRoll.equals("-"))
            {   return false;}
            else 
            {   return isValidFrame(firstRoll,secondRoll) && (thirdRoll.equals("X") || (third > 0 && third < 10));}
        }    
        else
        {   return isValidFrame(firstRoll,secondRoll);}
    }

    /**
     * isValidGame - determines whether or not the rolls represent a valid game.    
     *               A valid game may be either complete or incomplete.
     */    
    public boolean isValidGame()
    {
        boolean isValid = true;
        for (int i = 0; i < rolls.length - 1 && isValid; i++)
        {
            if (!rolls[i].equals(""))
            {
                String firstRoll = rolls[i].substring(0,1);
                String secondRoll = "";
                if (rolls[i].length() == 2)
                {
                    secondRoll = rolls[i].substring(1,2);
                }
                if (!isValidFrame(firstRoll, secondRoll))
                {
                    isValid = false;
                }
            }
        }
        if (isValid && rolls[9].length() > 1)
        {
            if (rolls[9].length() == 3)
            { 
                if (!rolls[9].equals("") && !isValidFrame(rolls[9].substring(0,1),rolls[9].substring(1,2),rolls[9].substring(2,3)))
                {
                    isValid = false;
                }
            }
            else
            {
                if (!rolls[9].equals("") && rolls[9].substring(0,1).equals("X") || !isValidFrame(rolls[9].substring(0,1),rolls[9].substring(1,2)))
                {
                    if (!rolls[9].substring(0,1).equals("X") || !rolls[9].substring(1,2).equals("X"))
                    {
                        if (!rolls[9].substring(1,2).equals("/"))
                        {
                            isValid = false;
                        }
                    }
                }
            }
        }
        return isValid;
    }

    /**
     * @return - the first open frame (1 - 10).  
     *         - if it is a completed game, return -1      
     */    
    public int getOpenFrame()
    {
        for (int i = 0; i < rolls.length; i++)
        {
            if (rolls[i].equals(""))
            {
                return i + 1;
            }
        }
        return -1;
    }    

    public String getBowler()
    {
        return this.bowler;
    }

    public String[] getRolls()
    {
        return this.rolls;
    }

    //OTHER REQUIRED METHODS:  INCLUDE AN EQUALS METHOD AND A PRINT METHOD
    public boolean equals(Object other)
    {
        if (other instanceof BowlingScore)
        {
            other = (BowlingScore)other;
            if (this.getBowler().equals(((BowlingScore)other).getBowler()))
            {
                if (this.getRolls().equals(((BowlingScore)other).getRolls()))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void print()
    {
        for (int i = 0; i < oldRolls.length - 1; i++)
        {
            System.out.print("|  " + oldRolls[i]);
            if (oldRolls[i].length() == 0)
            {
                System.out.print("  ");
            }
            else if (oldRolls[i].length() == 1)
            {
                System.out.print(" ");
            }
        }
        System.out.print("| " + oldRolls[9]);
        for (int i = rolls[9].length(); i < 3; i++)
        {
            System.out.print(" ");
        }
        System.out.print("|");
        System.out.println();
        System.out.print("|    |    |    |    |    |    |    |    |    |    |");
        System.out.println();
        int total = 0;
        for (int i = 0; i < rolls.length; i++)
        {
            if (rolls[i].length() == 0 || rolls[i].indexOf("X") != -1 || rolls[i].indexOf("/") != -1)
            {
                System.out.print("|    ");
            }
            else
            {
                total += this.getFrameScore(i);
                String frameScore = "" + total;
                System.out.print("| ");
                if (frameScore.length() == 1)
                {
                    System.out.print("  " + frameScore);
                }
                else if (frameScore.length() == 2)
                {
                    System.out.print(" " + frameScore);
                }
                else
                {
                    System.out.print(frameScore);
                }
            }
        }
        System.out.print("|");
        System.out.println();
    }

    /**
     * TESTS THE BOWLINGSCORE CLASS 
     */
    public static void main(String[] args)
    {
        //VALID SCORES
        String[] perfectScore = {"X","X","X","X","X","X","X","X","X","XXX"};
        BowlingScore perfect = new BowlingScore("Jack",perfectScore);
        String[] worstScore = {"--","--","--","--","--","--","--","--","--","--"};
        BowlingScore worst = new BowlingScore("Unnamed",worstScore);
        String[] actualScore = {"72","6-","8/","7-","X","34","X","X","71","4/6"};
        BowlingScore average = new BowlingScore("Average Joe",actualScore);

        //INVALID SCORES
        String[] invalidScore1 = {"66","47","84","56","94","86","38","86","57","83X"};
        BowlingScore moreThanTen = new BowlingScore("Over Achiever",invalidScore1);
        String[] invalidScore2 = {"71","54","61","81","82","91","37","10","64","552"};
        BowlingScore badAtSpares = new BowlingScore("Bad Adder",invalidScore2);
        String[] invalidScore3 = {"","24","35","45","72","","53","21","22","72"};
        BowlingScore skipper = new BowlingScore("Skipper",invalidScore3);

        //UNIFINISHED SCORE
        String[] unfinishedScore1 = {"63","X","44","5/","","","","","",""};
        BowlingScore unfinished1 = new BowlingScore("Unfinished",unfinishedScore1);
        String[] unfinishedScore2 = {"42","5/","","","","","","","",""};
        BowlingScore unfinished2 = new BowlingScore("Unfinished Also",unfinishedScore2);
        String[] unfinishedScore3 = {"54","54","54","54","54","54","54","54","54","5/"};
        BowlingScore unfinished3 = new BowlingScore("Last Box Empty",unfinishedScore3);

        System.out.println("Expected values in parentheses (like this)\n");

        //GETSCORE() METHOD
        System.out.println("getScore() method:");
        System.out.println("perfect score (300): " + perfect.getScore());
        System.out.println("worst score (0): " + worst.getScore());
        System.out.println("sample score (119): " + average.getScore());
        System.out.println("unfinished score #1 (-1): " + unfinished1.getScore());
        System.out.println("unfinished score #2 (-1): " + unfinished2.getScore());
        System.out.println("unfinished score #3 (-1): " + unfinished3.getScore());
        System.out.println();

        //COMPARETO() METHOD
        System.out.println("compareTo() method:");
        System.out.println("perfect score > sample score (181): " + perfect.compareTo(average));
        System.out.println("sample score > worst score (119): " + average.compareTo(worst));
        System.out.println("worst score > incomplete score (1): " + worst.compareTo(unfinished2));
        System.out.println("incomplete score #1 > incomplete score #2 (2): " + unfinished1.compareTo(unfinished2));
        System.out.println();

        //ADDFRAME() METHOD
        System.out.println("addFrame() method:");
        System.out.println("add a 7 and a 2 (true): " + unfinished1.addFrame("7","2"));
        System.out.println("add a strike (true): " + unfinished2.addFrame("X",""));
        System.out.println("add a score to a complete game (false): " + average.addFrame("X",""));
        System.out.println();

        //ISVALIDGAME() METHOD
        System.out.println("isValidGame() method:");
        System.out.println("perfect game (true): " + perfect.isValidGame());
        System.out.println("worst game (true): " + worst.isValidGame());
        System.out.println("sample game (true): " + average.isValidGame());
        System.out.println("incomplete game #1 (true): " + unfinished1.isValidGame());
        System.out.println("incomplete game #2 (true): " + unfinished2.isValidGame());
        System.out.println("incomplete game #3 (true): " + unfinished3.isValidGame());
        System.out.println("each frame's sum > 10 (false): " + moreThanTen.isValidGame());
        System.out.println("incorrect spare notation (false): " + badAtSpares.isValidGame());
        System.out.println("scores' sum > 10 (false): " + moreThanTen.isValidGame());
        System.out.println("skips frames (false): " + skipper.isValidGame());
        System.out.println();

        //GETOPENFRAME() METHOD
        System.out.println("getOpenFrame() method");
        System.out.println("finished game (-1): " + average.getOpenFrame());
        System.out.println("unfinished game #1 (6): " + unfinished1.getOpenFrame());
        System.out.println("unfinished game #2 (4): " + unfinished2.getOpenFrame());
        System.out.println("unfinished game #3 (10): " + unfinished3.getOpenFrame());
        System.out.println();

        //COPIES OF SCORES ABOVE
        String[] perfectScoreAgain = {"X","X","X","X","X","X","X","X","X","XX"};
        BowlingScore perfectAlso = new BowlingScore("Jack",perfectScoreAgain);
        String[] unfinishedScore2Copy = {"42","5/","X","","","","","","",""};
        BowlingScore unfinished2Copy = new BowlingScore("Unfinished Also",unfinishedScore2Copy);
        String[] partOfActualScore = {"72","6-","8/","7-","X","","","","",""};
        BowlingScore partOfAverage = new BowlingScore("Average Joe",partOfActualScore);
        String[] DifferentActualScore = {"54","6-","8/","7-","X","61","X","X","71","4/6"};
        BowlingScore otherAverage = new BowlingScore("Average Joe",DifferentActualScore);

        //EQUALS() METHOD
        System.out.println("equals() method");
        System.out.println("Complete games (true): " + perfect.equals(perfectAlso));
        System.out.println("Incomplete games (true): " + unfinished2.equals(unfinished2Copy));
        System.out.println("Different games (false): " + perfect.equals(worst));
        System.out.println("Incomplete game (false): " + average.equals(partOfAverage));
        System.out.println("Same score, different frames (false): " + average.equals(otherAverage));
    }
}

