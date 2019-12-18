import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dog[] dogs = new Dog[4];
        RaceManager raceManager = new RaceManager();

        System.out.print("Input step length of the dog. :");
        double tmpStepLength = sc.nextDouble(); //Large number as soon as possible.
        System.out.print("Input step interval of the dog. :");
        int tmpStepInterval = sc.nextInt(); //Small number as soon as possible.
        for(int i=0; i<dogs.length; i++){
            System.out.print("Input name of the dog. :");
            String tmpName = sc.next();
            dogs[i] = new Dog(tmpName, tmpStepLength, tmpStepInterval, raceManager);
        }

        for (Dog dog : dogs) {
            dog.start();
        }
    }
}
