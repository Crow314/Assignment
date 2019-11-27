import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
	    HeavyThread ht1 = new HeavyThread("A", stdIn.nextInt());
	    HeavyThread ht2 = new HeavyThread("B", stdIn.nextInt());
	    HeavyThread ht3 = new HeavyThread("C", stdIn.nextInt());
	    stdIn.close();
	    
	    System.out.println("Start threads.");
	    ht1.start();
	    ht2.start();
	    ht3.start();
	    System.out.println("Done.");

	}
}