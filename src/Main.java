import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        int N = sc.nextInt();

        sc.close();

        for(int i=N; i<S.length()+1; i+=N){
            System.out.print(S.charAt(i-1));
        }


    }
}
