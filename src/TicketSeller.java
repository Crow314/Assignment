public class TicketSeller {

	private int udonNum; //うどんの在庫数
	private int udonPrice; //うどんの値段
	private int sobaNum; //そばの在庫数
	private int sobaPrice; //そばの値段

	public TicketSeller(int udonNum, int udonPrice, int sobaNum, int sobaPrice) {
		this.udonNum = udonNum;
		this.udonPrice = udonPrice;
		this.sobaNum = sobaNum;
		this.sobaPrice = sobaPrice;
	}

	public void putCurrentTicket() {
		System.out.println("------");
		System.out.println("Udon:" + udonNum);
		System.out.println("Soba:" + sobaNum);
		System.out.println("------");
	}

	public Ticket getTicket(String menu) {
		if (menu == "Soba" && sobaNum > 0) {
			sobaNum--;
			return new Ticket("Soba", sobaPrice);
		} else if (menu == "Udon" && udonNum > 0) {
			udonNum--;
			return new Ticket("Udon", udonPrice);
		}
		return null;
	}
}