import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * ReadingDemo - how to read in a file of String 
 *               and split it along the tab
 * 
 * @author Mr. Funk
 * @version 3/21/2018
 */
public class ReadingDemo
{
    private ArrayList<String> data;
    
     /**  
      * @param the location of the file containing the list of names
      */
    public ReadingDemo(String filename)
    {
        data = new ArrayList<String>();
        
        //Setup File
        if(filename == null || filename.equals(""))
            filename = "BestPicture.txt";
        File fileLocation = new File(filename);
        
        try { 
            // 
            // Create a new Scanner object which will read the data from the file 
            // passed in. 
            Scanner scanner = new Scanner(fileLocation);             
            
            // To check if there are more lines to read, check by calling the  
            // scanner.hasNextLine() method. Then read lines one by one 
            // until all are read. 
            
            while (scanner.hasNextLine()) { 
                String word = scanner.nextLine();
                String[] parts = word.split("\t");
                data.add(parts[0]);
                data.add(parts[1]);
            } 
            
        //if file not found, catch the exception thrown by the Scanner class
        } catch (FileNotFoundException e) { 
            e.printStackTrace(); 
        }
    }
    
    public void print()
    {
        for(String s : data)
            System.out.println(s);
    }
}

