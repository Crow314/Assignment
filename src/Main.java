import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;

        try{
            for(int i=0; i<2; i++){
                result += sc.nextInt();
            }
            System.out.println("result:" + result);
        }catch (Exception e){
            System.out.println("Invalid Input!");
        }
    }
}
