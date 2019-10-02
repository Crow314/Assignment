public class UdonMania extends Customer {

    @Override
    public void buyTicket(TicketSeller seller) {
        setTicket(seller.getTicket("Udon"));
    }

    @Override
    public void say(){
        if(getTicket() != null){
            System.out.println(getTicket().getMenu() + " (" + getTicket().getPrice() + "Yen) geeeeet!!!");
        }else{
            System.out.println("Where is MY Udon??");
        }
    }
}
