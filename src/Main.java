import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double height = 0;
        do{
            System.out.println("Height:");
            height = sc.nextDouble();
        }while (!(height>=100 && height<200));

        double weight = 0;

        do{
            System.out.println("Weight:");
            weight = sc.nextDouble();
        }while (!(weight>=10 && weight<200));

        sc.close();

        double heightDouble = height / 100;

        double BMI = weight / (heightDouble * heightDouble);
        System.out.println("Your BMI is " + BMI);
    }
}
