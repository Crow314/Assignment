import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);
		
		Character yusha = new Character("Ness", "Hero", true);
		
		//初期ステータスの表示
		System.out.println(yusha.toString());
		
		//Expの獲得
		boolean isLevelUp = false;
		boolean isErrorOccurred = false;

		while(!isErrorOccurred){
			try {
				isLevelUp = yusha.addEx(stdIn.nextInt());
				if(isLevelUp)
					System.out.println(yusha.toString());
			} catch (InputMismatchException e) {
				isErrorOccurred = true;
				System.out.println("Invalid Input!");
			}
		}

		stdIn.close();
	}
}