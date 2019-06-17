import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car car = new Car(inputInt("tank"), inputDouble("mileage"));

        while(true){
            System.out.println(car.toString());
            int tmp = inputInt("fill? [0/1]");
            if(tmp>0) car.fillUp();
            System.out.println(car.move(inputInt("move")));
        }
    }

    public static int inputInt(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message + ":");
        int input = sc.nextInt();
        return input;
    }

    public static double inputDouble(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message + ":");
        double input = sc.nextDouble();
        return input;
    }
}
