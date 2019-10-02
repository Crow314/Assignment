public class Customer {

    private Ticket ticket;

    public void buyTicket(TicketSeller seller){
        setTicket(seller.getTicket("Soba"));
        if(getTicket() == null){
            setTicket(seller.getTicket("Udon"));
        }
    }

    public void say(){
        if(getTicket() != null){
            System.out.println(getTicket().getMenu() + " (" + getTicket().getPrice() + "Yen) get!");
        }else{
            System.out.println("I'm hungry..");
        }
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
