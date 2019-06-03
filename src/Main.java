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