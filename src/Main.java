import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year = sc.nextInt();

        sc.close();

        isLeapYear(year);

    }

    private static void isLeapYear(int year){
        boolean leap = false;

        if(year%400 == 0){
            leap = true;
        }else if(year%100 == 0){
            leap = false;
        }else if(year%4 == 0){
            leap = true;
        }

        if(leap){
            System.out.println("Year " + year + " is a leap year!");
        }else{
            System.out.println("Year " + year + " is NOT a leap year.");
        }
    }
}
