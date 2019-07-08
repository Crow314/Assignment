public class Programming extends Homework{
    private int coding;

    public Programming(String name, int coding){
        super(name);
        this.coding = coding;
    }

    @Override
    public void proceed(int n){
        coding -=n;
        coding = Integer.max(coding, 0);
    }

    @Override
    public boolean isFinish(){
        return coding == 0;
    }

    @Override
    public String toString(){
        return getName() + ": coding("+ coding +")";
    }
}
