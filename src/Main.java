import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Account account = new Account(inputString("name"), inputString("no"));

        while(true){
            System.out.println(account);
            account.deposit(inputInt("deposit amount"));
            System.out.println(account.withdraw(inputInt("withdraw amount")));

        }
    }

    private static String inputString(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message + ":");
        return sc.next();
    }

    private static int inputInt(String message){
        Scanner sc = new Scanner(System.in);
        System.out.print(message + ":");
        return sc.nextInt();
    }

}
