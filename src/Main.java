import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        String[] s = new String[3];

        for(int i=0; i < n; i++)
            try {
                s[i] = "No." + i;
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Out of Bound!!");
            }
        for(int i=0; i < n; i++)
            try {
                System.out.println(s[i]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("Out of Bound!!");
            }

    }
}