public class TimeAccount extends Account {

    private CalDate kigen;
    private int timeBalance;

    TimeAccount(String name, String no, CalDate kigen){
        super(name, no);
        this.kigen = kigen;
    }

    public boolean moveToTime(int amount){
        if(!super.withdraw(amount)) return false;
        timeBalance += amount;
        return true;
    }

    public boolean moveToNormal(CalDate hikidashibi){
        if(kigen.isAfterOf(hikidashibi)) return false;
        super.deposit(timeBalance);
        timeBalance = 0;
        return true;
    }

    @Override
    public String toString(){
        return super.getName() + "(" + super.getNo() +") :Normal(" + super.getBalance() + ") Time(" + timeBalance + ")";
    }
}
