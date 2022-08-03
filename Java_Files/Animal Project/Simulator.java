import java.util.ArrayList;
import java.util.Scanner;
/**
 * Simulates the animal lab
 * 
 * @author Daniel Maloney
 * @version 1.0
 */
public class Simulator
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        ///// SETUP ARRAYLISTS /////
        ArrayList<Pet> listPets = new ArrayList<Pet>();
        ArrayList<FarmAnimal> listFarm = new ArrayList<FarmAnimal>();
        ArrayList<Ownable> listOwnable = new ArrayList<Ownable>();
        
        ///// SETUP PLAYER /////
        /// NAME ///
        System.out.println("What is your name?");
        String name = s.nextLine();

        /// AGE ///
        System.out.println("How old are you?");
        int age = s.nextInt();
        s.nextLine(); // eats the /n

        /// WEIGHT ///
        System.out.println("How much do you weigh?");
        double weight = s.nextDouble();
        s.nextLine(); // eats the /n

        /// CREATES THE PLAYER ///
        Human player = new Human(weight, name, age);

        ///// SETUP PETS /////
        System.out.println("How many pets do you have?");
        int numpets = s.nextInt();
        s.nextLine(); // eats the /n

        /// MAKES A NEW PET numpets TIMES
        for(int i = 0; i < numpets; i++)
        {
            /// PET AGE ///
            System.out.println("Enter the type of pet " + (i+1) + ":"); 
            String petspecies = s.nextLine();

            /// PET NAME ///
            System.out.println("Enter the name of pet " + (i+1) + ":"); 
            String petname = s.nextLine();

            /// PET AGE ///
            System.out.println("Enter the age of pet " + (i+1) + ":"); 
            int petage = s.nextInt();
            s.nextLine(); // eats the /n

            /// PET WEIGHT ///
            System.out.println("Enter the weight of pet " + (i+1) + ":"); 
            double petweight = s.nextDouble();
            s.nextLine(); // eats the /n

            /// CREATES PET ///
            Pet p = new Pet(petspecies, petweight, petname, player,  petage); 
            player.addPet(p);
            listPets.add(p);
            listOwnable.add(p);
        }

        ///// SETUP FARM ANIMALS /////
        System.out.println("How many Farm Animals do you have?");
        int numfarm = s.nextInt();
        s.nextLine(); // eats the /n left over

        /// MAKES NEW FARM ANIMALS numfarm TIMES ///
        for(int i = 0; i < numfarm; i++)
        {
            /// FARM ANIMAL TYPE ///
            System.out.println("Enter the type of Farm Animal " + (i+1) + ":"); 
            String farmSpecies = s.nextLine();

            /// FARM ANIMAL WEIGHT ///
            System.out.println("Enter the weight of Farm Animal " + (i+1) + ":"); 
            double farmWeight = s.nextDouble();
            s.nextLine(); // eats the /n

            /// CREATES THE FARM ANIMAL ///
            FarmAnimal f = new FarmAnimal(farmSpecies, farmWeight, player); 
            listFarm.add(f);
            listOwnable.add(f);
        }

        ///// GAME SETUP /////
        boolean isRunning = true;
        int day = 1;
        int currentMoney = 20;
        int income = 10;

        ///// RUN THE GAME /////
        while(isRunning)
        {
            //// DAY HEADER ////
            System.out.println();
            System.out.println("Day " + day);
            System.out.println("Current money: " + currentMoney);
            System.out.println("Current income: " + income);
            System.out.println();

            //// FEED THE PETS ////
            if (listPets.size() > 0)
            {
                //// FEEDING DESCRIPTION ////
                System.out.println();
                System.out.println("Time to feed the Pets:");
                System.out.println("Each pet costs 1 coin to feed.");
                System.out.println();
                
                //// FEEDING PROMPTS ////
                for(Pet p : listPets)
                {
                    System.out.println(p.toString());
                    
                    //// PET DESCRIPTION ////
                    /// IF HUNGRY ///
                    if (p.isHungry())
                    {
                        System.out.println(p.getName() + " the " + p.getSpecies() + 
                        " is hungry and has not been fed in " + p.daysSinceFed() + " days!");  
                    }
                    // IF NOT HUNGRY ///
                    else
                    {
                        System.out.println(p.getName() + " the " + p.getSpecies() + 
                        " is not hungry and has not been fed in " + p.daysSinceFed() + " days!");
                    }

                    //// ASK PLAYER TO FEED ////
                    System.out.println("Do you want to feed " + p.getName() + "?");
                    String response = s.nextLine();
                    
                    //// INTERPRET RESPONSE, DEFAULT ANSWER: "NO" ////
                    if (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y") )
                    {
                        /// IF YES ///
                        //CHECK CURRENCY
                        if (currentMoney >= 1)
                        {
                            p.feed();
                            System.out.println(p.getName() + " has been fed!");
                            currentMoney--;
                        }
                        else
                        {
                            System.out.println("You don't have enough money to feed this pet!");
                        }
                    }
                    /// IF NOT YES ///
                    else
                    {
                        System.out.println(p.getName() + " has not been fed!");
                    }
                    //// END OF RESPONSE INTERPRETATION ////
                }
                //// END OF FEEDING PROMPTS ////
            }
            //// END OF PET-FEEDING ////
            
            //// MONETARY REMINDER ////
            System.out.println("Current Money: " + currentMoney);

            //// FEED THE FARM ANIMALS ////
            if (listFarm.size() > 0)
            {
                //// FEEDING DESCRIPTION ////
                System.out.println();
                System.out.println("Time to feed the Farm Animals:");
                System.out.println("Each farm animal costs 2 to feed.");
                System.out.println();

                //// FEEDING PROMPTS ////
                for(FarmAnimal f : listFarm)
                {
                    //// FARM ANIMAL DESCRIPTION ////
                    System.out.println(f.toString());
                    
                    //// IF HUNGRY ////
                    if (f.isHungry())
                    {
                        System.out.println("This " + f.getSpecies() + 
                        " is hungry and has not been fed in " + f.daysSinceFed() + " days!");  
                    }
                    //// IF NOT HUNGRY ////
                    else
                    {
                        System.out.println("This " + f.getSpecies() + 
                        " is not hungry and has not been fed in " + f.daysSinceFed() + " days!");
                    }

                    //// ASK PLAYER TO FEED ////
                    System.out.println("Do you want to feed this " + f.getSpecies() + "?");
                    String response = s.nextLine();
                    
                    //// INTERPRET RESPONSE, DEFAULT ANSWER: "NO" ////
                    if (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y"))
                    {
                        /// IF YES ///
                        // CHECK CURRENCY //
                        if (currentMoney >= 2)
                        {
                            f.feed();
                            System.out.println("This " + f.getSpecies() + " has been fed!");
                            currentMoney -= 2;
                        }
                        else
                        {
                            System.out.println("You don't have enough money to feed this Farm Animal!");
                        }
                    }
                    /// IF NOT YES ///
                    else
                    {
                        System.out.println("This " + f.getSpecies() + " has not been fed!");
                    }
                    //// END OF RESPONSE INTERPRETATION
                }
                //// END OF FEEDING PROMPTS ////
            }
            //// END OF FARM ANIMAL-FEEDING ////
            
            System.out.println();

            //// DISPLAY PET HUNGRINESS ////
            for(Pet p : listPets)
            {
                System.out.println(p + "\nHungry?: " + p.isHungry());
                System.out.println();
            }
            
            //// DISPLAY FARM ANIMAL HUNGRINESS ////
            for(FarmAnimal f : listFarm)
            {
                System.out.println(f + "\nHungry?: " + f.isHungry());
                System.out.println();
            }

            //// ADVANCES A DAY ////
            for(Ownable o : listOwnable)
            {
                o.nextDay();
            }

            //// ANIMAL WEIGHT COMPETITIONS EVERY OTHER DAY ////
            if (day % 2 == 0)
            {
                //// ANIMAL COMPETITION DESCRIPTION ////
                System.out.println("It's animal competition day!");
                System.out.println();
                System.out.println("Rules:");
                System.out.println("1. The game will automatically select your heaviest animal.");
                System.out.println("2. It will then compare its weight to the weight of the competitors heaviest animal.");
                System.out.println("3. Winner gets 20 coins");

                Animal heaviest;
                
                //// CHOOSES THE HEAVIEST ANIMAL ////
                /// DEFAULT: FIRST PET OR FIRST FARM ANIMAL ///
                if (listPets.size() > 0)
                {
                    heaviest = listPets.get(0);
                }
                else
                {
                    heaviest = listFarm.get(0);   
                }
                
                /// SETS NEW HEAVIEST IF OTHER PETS ARE HEAVIER ///
                for(Pet p : listPets)
                {
                    if (p.compareTo(heaviest) > 0)
                    {
                        heaviest = p;
                    }
                }

                /// SETS NEW HEAVIEST IF OTHER FARM ANIMALS ARE HEAVIER ///
                for(FarmAnimal f : listFarm)
                {
                    if (f.compareTo(heaviest) > 0)
                    {
                        heaviest = f;
                    }
                }
                
                //// COMPARES HEAVIEST ANIMAL TO GOAT WITH RANDOM WEIGHT < 1000 LBS ////
                Human otherOwner = new Human(150, "Jake", 95);
                FarmAnimal competitor = new FarmAnimal("Goat", (int)(Math.random() * ((1000 - 20) + 1) + 20), otherOwner);
                
                //// DISPLAYS PLAYER'S HEAVIEST ANIMAL ////
                System.out.println("Your heaviest animal: ");
                System.out.println(heaviest);

                //// DISPLAYS GOAT'S WEIGHT ////
                System.out.println("The competitors heaviest animal: ");
                System.out.println(competitor);

                //// COMPARES WEIGHTS OF HEAVIEST ANIMAL WITH THE GOAT ////
                /// IF HEAVIER THAN GOAT ///
                if (heaviest.compareTo(competitor) > 0)
                {
                    System.out.println("You won!");
                    currentMoney += 20;
                    System.out.println("Current money: " + currentMoney);
                }
                /// IF NOT HEAVIER THAN GOAT ///
                else if (heaviest.compareTo(competitor) < 0)
                {
                    System.out.println("You lost!");
                }
                /// IF SAME WEIGHT AS GOAT ///
                else
                {
                    System.out.println("You tied! (You both get 10 coins)");
                    currentMoney += 10;
                    System.out.println("Current money: " + currentMoney);
                }
            }

            //// GET 2 MONEYS EVERY 5 DAYS ////
            if (day % 5 == 0)
            {
                income += 2;
                System.out.println("Your income has increased!");
                System.out.println("New income: " + income);
            }

            //// IF WEIGHT <= 0, PET DIES ////
            for(int i = 0; i < listPets.size(); i++)
            {
                if (listPets.get(i).getWeight() <= 0)
                {
                    Pet currentPet = listPets.get(i);
                    
                    System.out.println("Your pet " + currentPet.getName() + " has died!");
                    
                    listPets.remove(currentPet);
                    listOwnable.remove((Ownable)currentPet);
                    player.removePet(currentPet);
                }
            }

            //// IF WEIGHT <= 0, ANIMAL DIES ////
            for(int i = 0; i < listFarm.size(); i++)
            {
                if (listFarm.get(i).getWeight() <= 0)
                {
                    FarmAnimal currentAnimal = listFarm.get(i);
                    
                    System.out.println("Your " + currentAnimal.getSpecies() + " has died!");
                    
                    listFarm.remove(currentAnimal);
                    listOwnable.remove((Ownable)currentAnimal);
                }
            }

            //// GAME ENDS WHEN ALL ANIMALS DIE ////
            if (listFarm.size() == 0 && listPets.size() == 0)
            {
                isRunning = false;
                System.out.println("Game over! All of your pets and animals have died!");
                System.out.println("You lasted " + day + " days!");
            }
            
            //// GAIN MONEY FROM INCOME EVERY DAY ////
            currentMoney += income;

            //// ADVANCE ANOTHER DAY ////
            day++;
            
            //// PROMPT PLAYER TO KEEP PLAYING ////
            System.out.println("Do you want to keep playing? ");
            String response = s.nextLine();
            
            //// INTERPRET RESPONSE, DEFAULT ANSWER: "YES" ////
            /// IF YES ///
            if (response.toLowerCase().equals("yes") || response.toLowerCase().equals("y"))
            {   }
            /// IF NO ///
            else if (response.toLowerCase().equals("no") || response.toLowerCase().equals("n"))
            {
                isRunning = false;
                System.out.println("Thanks for playing! You lasted " + day + " days!");
            }
            /// IF NEITHER YES NOR NO ///
            else
            {
                System.out.println("Response was neither yes nor no, so I'm assuming that's a yes.");
            }
            //// END OF RESPONSE INTERPRETATION ////
        }
        //// END OF GAME ////
    }
}
