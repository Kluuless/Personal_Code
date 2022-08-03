
/**
 * Who knows?
 *
 * @author Kyle Luu
 * @version 1.0
 */
public class Rand1 implements Comparable<Rand1>
{
    private int currentYear;
    private int currentMonth;
    private int currentDay;
    private int dayOfTheWeek;

    public Rand1()
    {
        currentYear = 2018;
        currentMonth = 7;
        currentDay = 4;
        dayOfTheWeek = 4;
    }

    public Rand1 (int year, int month, int day, int dayOfWeek)
    {
        currentYear = year;
        currentMonth = month;
        currentDay = day;
        dayOfTheWeek = dayOfWeek;
    }

    public String toString()
    {
        String theDate = currentMonth + "/" + currentDay + "/" + currentYear;
        return theDate;
    }

    private boolean arrayContains(int[] array, int value)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == value)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isLeapYear()
    {
        if (currentYear % 4 == 0)
        {
            if (currentYear % 1000 != 0)
            {
                return true;
            }
        }
        return false;
    }

    public void nextDay()
    {
        dayOfTheWeek++;
        if (dayOfTheWeek > 7)
        {
            dayOfTheWeek = 1;
        }

        int[] longerMonths = {1,3,5,7,8,10,12};
        currentDay++;
        //for months with 31 days
        if (arrayContains(longerMonths,currentMonth) && currentDay == 32)
        {
            currentMonth++;
            currentDay = 1;
        }
        //for months with 30 days
        if (!arrayContains(longerMonths,currentMonth) && currentDay == 31 && currentMonth != 2)
        {
            currentMonth++;
            currentDay = 1;
        }
        //for February
        if (currentMonth == 2)
        {
            if (isLeapYear() && currentDay == 30)
            {
                currentMonth++;
                currentDay = 1;
            }
            else if (!isLeapYear() && currentDay == 29)
            {
                currentMonth++;
                currentDay = 1;
            }
        }

        if (currentMonth == 13)
        {
            currentYear++;
            currentMonth = 1;
            currentDay = 1;
        }
    }
    
    public void previousDay()
    {
        dayOfTheWeek--;
        if (dayOfTheWeek == 0)
        {
            dayOfTheWeek = 7;
        }

        int[] longerMonths = {1,3,5,7,8,10,12};
        currentDay--;
        if (currentDay == 0)
        {
            currentMonth--;
            if (arrayContains(longerMonths,currentMonth))
            {
                currentDay = 31;
            }
            else if (currentMonth == 2)
            {
                if (isLeapYear())
                {
                    currentDay = 29;
                }
                currentDay = 28;
            }
            else if (currentMonth == 0)
            {
                currentYear--;
                currentMonth = 12;
                currentDay = 31;
            }
            else
            {
                currentDay = 30;
            }
        }
    }

    public boolean equals (Object other)
    {
        if (other instanceof Rand1)
        {
            if (((Rand1)other).currentDay == currentDay && ((Rand1)other).currentMonth == currentMonth && ((Rand1)other).currentYear == currentYear)
            {
                return true;
            }
        }
        return false;
    }

    public int compareTo (Rand1 targetDate)
    {
        if (this.equals(targetDate))
        {
            return 0;
        }
        else if (this.currentYear != targetDate.currentYear)
        {
            return this.currentYear - targetDate.currentYear;
        }
        else if (this.currentMonth != targetDate.currentMonth)
        {
            return this.currentMonth - targetDate.currentMonth;
        }
        else
        {
            return this.currentDay - targetDate.currentDay;
        }
    }

    public int daysUntil(Rand1 targetDate)
    {
        if (this.equals(targetDate))
        {
            return 0;
        }
        else if (this.compareTo(targetDate) < 0)
        {
            int days = 0;
            while (!this.equals(targetDate))
            {
                days++;
                this.nextDay();
            }
            return days;
        }
        else
        {
            Rand1 target = copy(targetDate);
            int days = 0;
            while (!this.equals(target))
            {
                days++;
                target.nextDay();
            }
            return -1 * days;
        }
    }

    public void advance(int amountOfDays)
    {
        if (amountOfDays >= 0)
        {
            for (int i = 0; i < amountOfDays; i++)
            {
                nextDay();
            }
        }
        else
        {
            for (int i = 0; i > amountOfDays; i--)
            {
                previousDay();
            }
        }
    }
    
    public void advanceYears(int amount)
    {
        Rand1 copy = new Rand1(this.currentYear + amount,this.currentMonth,this.currentDay,this.dayOfTheWeek);
        while (!this.equals(copy))
        {
            nextDay();
        }
    }
    
    public void advanceToYear(int year)
    {
        advanceYears(year - currentYear);
    }

    public Rand1 copy(Rand1 date)
    {
        Rand1 theCopy = new Rand1(date.currentYear,date.currentMonth,date.currentDay,date.dayOfTheWeek);
        return theCopy;
    }
    
    public String dayOfWeek()
    {
        if (dayOfTheWeek == 1)
        {
            return "Sunday";
        }
        else if (dayOfTheWeek == 2)
        {
            return "Monday";
        }
        else if (dayOfTheWeek == 3)
        {
            return "Tuesday";
        }
        else if (dayOfTheWeek == 4)
        {
            return "Wednesday";
        } 
        else if (dayOfTheWeek == 5)
        {
            return "Thursday";
        }
        else if (dayOfTheWeek == 6)
        {
            return "Friday";
        }
        else
        {
            return "Saturday";
        }
    }
    
    public int getMonth()
    {
        return currentMonth;
    }
    public int getYear()
    {
        return currentYear;
    }
    public int getDay()
    {
        return currentDay;
    }
    
    public void print()
    {
        if (currentMonth == 1)
        {
            System.out.print("January ");
        }
        else if (currentMonth == 2)
        {
            System.out.print("February ");
        }
        else if (currentMonth == 3)
        {
            System.out.print("March ");
        }
        else if (currentMonth == 4)
        {
            System.out.print("April ");
        }
        else if (currentMonth == 5)
        {
            System.out.print("May ");
        }
        else if (currentMonth == 6)
        {
            System.out.print("June ");
        }
        else if (currentMonth == 7)
        {
            System.out.print("July ");
        }
        else if (currentMonth == 8)
        {
            System.out.print("August ");
        }
        else if (currentMonth == 9)
        {
            System.out.print("September ");
        }
        else if (currentMonth == 10)
        {
            System.out.print("October ");
        }
        else if (currentMonth == 11)
        {
            System.out.print("November ");
        }
        else if (currentMonth == 12)
        {
            System.out.print("December ");
        }
        
        System.out.print(currentDay + ", " + currentYear);
        System.out.println();
        System.out.print("It is a " + dayOfWeek());
    }
}


