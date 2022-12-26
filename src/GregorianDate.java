//Ally Hassett -- CS 1410

public class GregorianDate{
    private int year;
    private int month;
    private int day;

    //Default -- today's date
    GregorianDate(){
        this.year = 1970;
        this.month = 1;
        this.day = 1;

        //86,400,000 milliseconds in a day
        int daysSince = (int)((System.currentTimeMillis() + java.util.TimeZone.getDefault().getRawOffset())/ 86400000);
        this.addDays(daysSince);
    }

    GregorianDate(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;
    }


    //All the public classes are listed below

    //If day is too big to be a possible day, move through months and years until it is valid
    public void addDays(int days){
        this.day += days;
        while(this.day > getNumberOfDaysInMonth(this.year, this.month)){
            this.day -= getNumberOfDaysInMonth(this.year, this.month);
            this.month += 1;
            if(this.month > 12){
                this.month = 1;
                this.year += 1;
            }
        }

    }

    //If day is too small to be a possible day, move through months and years until it is valid
    public void subtractDays(int days){
        this.day -= days;
        while(this.day < 1){
            if(this.month - 1 < 1){
                this.day += getNumberOfDaysInMonth(this.year, 12);
            }else{
                this.day += getNumberOfDaysInMonth(this.year, this.month - 1);
            }
            this.month -= 1;
            if(this.month < 1){
                this.month = 12;
                this.year -= 1;
            }
        }
    }

    //Print the date in the form: Monthname day, year
    public void printLongDate(){
        System.out.printf("%s %d, %d", getMonthName(this.month), this.day, this.year);
    }

    //Print the date in the form: MM/DD/YYYY
    public void printShortDate(){
        System.out.printf("%d/%d/%d", this.month, this.day, this.year);
    }

    //Gregorian leap year is every four years unless it's a multiple of 100 that is not also a multiple of 400
    public boolean isLeapYear(){
        if(this.year % 400 == 0){
            return true;
        } else if(this.year % 100 == 0){
            return false;
        } else{
            return this.year % 4 == 0;
        }
    }

    //Return name of the month publicly
    public String getMonthName(){
        return getMonthName(this.month);
    }

    //Return the number of the month publicly
    public int getMonth(){
        return this.month;
    }

    //Return the year publicly
    public int getYear(){
        return this.year;
    }

    //Return the number of the day publicly
    public int getDayOfMonth(){
        return this.day;
    }


    //All the private classes are listed below

    //Gregorian leap year is every four years unless it's a multiple of 100 that is not also a multiple of 400
    private static boolean isLeapYear(int year){
        if(year % 400 == 0){
            return true;
        } else if(year % 100 == 0){
            return false;
        } else{
            return year % 4 == 0;
        }
    }

    //Different number of days in every month
    private static int getNumberOfDaysInMonth(int year, int month){
        if(month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            return 31;
        }else if(month == 2){
            if(isLeapYear(year)){
                return 29;
            }else{
                return 28;
            }
        }else if(month == 4 || month == 6 || month == 9 || month == 11){
            return 30;
        }else{
            return 0;
        }
    }

    //Find name of the month using its number
    private static String getMonthName(int month){
        if(month == 1){
            return "January";
        }else if(month == 2){
            return "February";
        }else if(month == 3){
            return "March";
        }else if(month == 4){
            return "April";
        }else if(month == 5){
            return "May";
        }else if(month == 6){
            return "June";
        }else if(month == 7){
            return "July";
        }else if(month == 8){
            return "August";
        }else if(month == 9){
            return "September";
        }else if(month == 10){
            return "October";
        }else if(month == 11){
            return "November";
        }else if(month == 12){
            return "December";
        }else{
            return "";
        }
    }
}
