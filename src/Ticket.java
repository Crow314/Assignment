public class Ticket {

	private String menu; //メニュー名
	private int price; //値段

	Ticket(String menu, int price) {
		this.menu = menu;
		this.price = price;
	}

	public String getMenu() {
		return menu;
	}

	public int getPrice() {
		return price;
	}
}