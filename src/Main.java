import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		//うどんとそばの食券の枚数を入力
		Scanner sc = new Scanner(System.in);
		int uNum = sc.nextInt();
		int sNum = sc.nextInt();
		sc.close();
		
		//入力された枚数で券売機を初期化（うどん290円，そば300円）
		TicketSeller seller = new TicketSeller(uNum, 290, sNum, 300);

		//券売機が食券の残り状況を表示
		seller.putCurrentTicket();
		//お客さんは6人，うどん好きが2名
		Customer line[] = new Customer[6];
		line[0] = new Customer();
		line[1] = new Customer();
		line[2] = new UdonMania();
		line[3] = new Customer();
		line[4] = new UdonMania();
		line[5] = new Customer();

		//お客さんが順番に食券を買い，買った食券について話す
		for(int i=0; i < 6; i++){
			System.out.println("#" + (i+1) + " customer");
			line[i].buyTicket(seller);
			line[i].say();
		}

		//券売機が食券の残り状況を表示
		seller.putCurrentTicket();
	}
}
