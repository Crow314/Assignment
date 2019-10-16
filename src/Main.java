import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();

        try{
            while(true){
                input.add(sc.nextInt());
            }
        }catch (Exception e){
            System.out.println("Invalid Input!");
        }

        int result = 0;
        System.out.print("input: ");

        if(input.size()%2 == 0){
            for(int i=0; i<input.size(); i++){
                System.out.print(" " + input.get(i));
                result += input.get(i);
            }
        }else{
            result = 1;
            for(int i=0; i<input.size(); i++){
                System.out.print(" " + input.get(i));
                result *= input.get(i);
            }
        }

        System.out.println();
        System.out.println("result:" + result);
    }
}
