public class Account {

    private String name;
    private String no;
    private int balance;

    Account(String name, String no){
        this.name = name;
        this.no = no;
        this.balance = 0;
    }

    private boolean isSufficientAmount(int amount){
        return (balance >= amount);
    }

    public void deposit(int amount){
        balance += amount;
    }

    public boolean withdraw(int amount){
        if(!isSufficientAmount(amount)){
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override
    public String toString(){
        return name + "(" + no + ") :" + balance;
    }

    public String getName() {
        return name;
    }

    public String getNo() {
        return no;
    }

    public int getBalance() {
        return balance;
    }
}
