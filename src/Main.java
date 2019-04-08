public class Main {

    public static void main(String[] args) {

        System.out.print("  ");

        for(int i=1; i<10; i++) {
            System.out.print(" ");
            System.out.printf("%02d", i);
        }

        System.out.println();

        for(int i=1; i<10; i++) {
            System.out.printf("%02d", i);
            for(int j=1; j<10; j++) {
                System.out.print(" ");
                System.out.printf("%02d", i*j);
            }
            System.out.println();
        }


    }

}