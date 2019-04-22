import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String pass = sc.next();

        boolean result = isGoodPass(pass);

        String res_out = result ? "OK" : "NG";

        System.out.println("Password " + res_out);
    }

    private static boolean isGoodPass(String pass){
        if(!isInRange(pass, 4, 6) || !hasLowerCase(pass) || !hasUpperCase(pass) || !hasNumeric(pass)){
            return false;
        }

        return true;
    }

    private static boolean isInRange(String pass, int min, int max){
        int length = pass.length();
        if(min <= length && max >= length){
            return true;
        }
        return false;
    }

    private static boolean hasLowerCase(String pass){
        return hasCharInRange(pass, 'a', 'z');
    }

    private static boolean hasUpperCase(String pass){
        return hasCharInRange(pass, 'A', 'Z');
    }

    private static boolean hasNumeric(String pass){
        return hasCharInRange(pass, '0', '9');
    }

    private static boolean hasCharInRange(String pass, char start, char fin){
        char[] passCharArray = pass.toCharArray();

        for(int i=0; i<passCharArray.length; i++){
            char tmp = passCharArray[i];
            if(tmp >= start&& tmp <= fin){
                return true;
            }
        }
        return false;
    }
}
