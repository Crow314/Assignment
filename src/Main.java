public class Main {
    public static void main(String[] args) {
        System.out.println("   01 02 03 04 05 06 07 08 09");
        for(int i=1; i<10; i++){
            System.out.print("0" + i);
            lineOutput(i);
            System.out.println();
        }
    }

    private static void lineOutput(int y) {
        for (int x = 1; x < 10; x++) {
            int n = x * y;
            // 1桁の時の追加処理
            if (n < 10)
                System.out.print(" 0" + n);
            else
                System.out.print(" " + n);
        }
    }
}