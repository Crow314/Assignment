import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Calculator[] calculators = new Calculator[5];

        for(int i=0; i<calculators.length; i++){
            System.out.print("Input name. :");
            String tmpName = sc.next();
            System.out.print("Input num. :");
            int tmpNum = sc.nextInt();
            calculators[i] = new Calculator(tmpName, tmpNum);
        }

        for(Calculator calculator : calculators){
            calculator.start();
        }
    }
}
