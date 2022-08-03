import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Store Film objects in an ArrayList
 * 
 * @author Mr. Funk and Kyle Luu
 * @version 1.0
 */
public class Films
{
    private ArrayList<Film> data;

    /**  
     * @param the location of the file containing the list of names
     */
    public Films(String filename)
    {
        data = new ArrayList<Film>();

        //Setup File
        if(filename.equals(""))
        {
            filename = "BestPicture.txt";
        }
        File fileLocation = new File(filename);

        try 
        { 
            // 
            // Create a new Scanner object which will read the data from the file 
            // passed in. 
            Scanner scanner = new Scanner(fileLocation);             

            // To check if there are more lines to read, check by calling the  
            // scanner.hasNextLine() method. Then read lines one by one 
            // until all are read. 

            while (scanner.hasNextLine()) 
            { 
                String word = scanner.nextLine();
                String[] parts = word.split("\t");
                Film film = new Film(Integer.parseInt(parts[0]),parts[1]);
                data.add(film);
                //update data with new Film object  
            } 

            //if file not found, catch the exception thrown by the Scanner class
        } 
        catch (FileNotFoundException e) 
        { 
            e.printStackTrace(); 
        }
    }

    public ArrayList<Film> getData()
    {
        return data;
    }

    public String toString()
    {
        String result = "";
        for (int i = 0; i < data.size(); i++)
        {
            result += data.get(i).toString();
            result += "\n";
        }
        return result.substring(0,result.length()-1);
    }

    public void print()
    {
        System.out.println(this.toString());
    }

    public String searchForFilmByYear(int year)
    {
        return searchForFilmByYear(0, data.size(), year);
    }
    
    private String searchForFilmByYear(int start, int end, int year)
    {
        if (end - start == 1)
        {
            if (data.get(start).getYear() == year)
            {
                return data.get(start).getTitle();
            }
            else
            {
                return "";
            }
        }
        else if (end - start < 1)
        {
            return "";
        }
        else
        {
            if (data.get((start + end)/2).getYear() > year)
            {
                return searchForFilmByYear(start, (start + end)/2, year);
            }
            else
            {
                return searchForFilmByYear((start + end)/2, end, year);
            }
        }
    }
    
    public int searchForFilmByTitle(String title)
    {
        for (int i = 0; i < data.size(); i++)
        {
            if (data.get(i).getTitle().equals(title))
            {
                return data.get(i).getYear();
            }
        }
        return -1;
    }

    public ArrayList<Film> filmsContainingTheWord(String word)
    {
        ArrayList<Film> result = new ArrayList<Film>();
        for (int i = 0; i < data.size(); i++)
        {
            if (data.get(i).titleContainsTheWord(word))
            {
                result.add(data.get(i));
            }
        }
        return result;
    }
    
    private static ArrayList<Film> merge(ArrayList<Film> films1, ArrayList<Film> films2)
    {
        ArrayList<Film> result = new ArrayList<Film>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < films1.size() && index2 < films2.size())
        {
            if (films1.get(index1).compareTo(films2.get(index2)) < 0)
            {
                result.add(films1.get(index1));
                index1++;
            }
            else
            {
                result.add(films2.get(index2));
                index2++;
            }
        }
        while (index1 < films1.size())
        {
            result.add(films1.get(index1));
            index1++;
        }
        while (index2 < films2.size())
        {
            result.add(films2.get(index2));
            index2++;
        }
        return result;
    }

    private static ArrayList<Film> mergeSort(ArrayList<Film> oldData)
    {
        if (oldData.size() <= 1)
        {
            return oldData;
        }
        
        ArrayList<Film> front = new ArrayList<Film>();
        ArrayList<Film> back = new ArrayList<Film>();
        for (int i = 0; i < oldData.size(); i++)
        {
            if (i < oldData.size()/2)
            {
                front.add(oldData.get(i));
            }
            else
            {
                back.add(oldData.get(i));
            }
        }
        return merge(mergeSort(front), mergeSort(back));
    }
    
    public void mergeSort()
    {
        data = mergeSort(data);
    }
}

