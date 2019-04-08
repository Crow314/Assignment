import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("N:");
        int N = sc.nextInt();

        Set<Integer> submitList = new TreeSet<>();
        for(int i=1; i<=N; i++){
            submitList.add(i);
        }

        while (true){
            int in = sc.nextInt();

            if(in == 99) {
                break;
            }

            submitList.remove(in);
        }

        Integer[] out = submitList.toArray(new Integer[0]);

        System.out.println("Result");
        for(int i=0; i<out.length; i++){
            System.out.println(out[i]);
        }

    }
}
