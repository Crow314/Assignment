import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = 2019;
        int month = sc.nextInt();

        sc.close();

        int[] daysOfMonth = {31, checkLeapYear(year) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        CalDate calDate = new CalDate(year, month, 0);

        for(int i=0; i<daysOfMonth[month-1]; i++){
            calDate.change(year, month, i+1);
            System.out.println(calDate.getYear() + "/" + calDate.getMonth() + "/" + calDate.getDay() + "(" + calDate.getDayOfWeek() + ")");
        }

    }

    public static boolean checkLeapYear(int year){
        if(year % 400 == 0) return true;
        if(year % 100 == 0) return false;
        if(year % 4 == 0) return true;
        return false;
    }
}

class CalDate{
    private int year;
    private int month;
    private int day;
    private String dayOfWeek;

    public static final String[] DAY_OF_WEEK = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    CalDate(int year, int month, int day){
        this.change(year, month, day);
    }

    public void  change(int year, int month, int day){
        this.year = year;
        this.month = month;
        this.day = day;

        //1月を前年の13月, 2月を前年の14月として計算する
        if(month == 1 || month == 2){
            year--;
            month += 12;
        }

        int dayOfWeek_int = (year + year/4 - year/100 + year/400 + (13 * month + 8)/5 + day) % 7;
        this.dayOfWeek = DAY_OF_WEEK[dayOfWeek_int];

    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}