import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        sc.close();

        int result = X * 1000 - A - B * C;
        result %= 1000;
        System.out.println(result);
    }
}
