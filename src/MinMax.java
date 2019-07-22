import java.util.Arrays;

public class MinMax {

    public static final int INTMAX = 2147483647;
    public static final int INTMIN = -2147483648;

    public static int max(int a, int b){
        return Integer.max(a, b);
    }

    public static int min(int a, int b){
        return Integer.min(a, b);
    }

    public static int max(int[] list){
        try {

            int[] tmpList = list.clone();
            Arrays.sort(tmpList);
            return tmpList[tmpList.length - 1];
        }catch (Exception e){
            return INTMIN;
        }
    }

    public static int min(int[] list){
        try {
            int[] tmpList = list.clone();
            Arrays.sort(tmpList);
            return tmpList[0];
        }catch (Exception e){
            return INTMAX;
        }
    }
}
