public class Homework {

    private String name;
    private int text;

    public Homework(String name){
        this.name = name;
        this.text = 50;
    }

    public void proceed(int n){
        text -= n;
        text = Integer.max(text, 0);
    }

    public boolean isFinish(){
        return text == 0;
    }

    @Override
    public String toString(){
        return name + ": text("+ text +")";
    }

    public String getName() {
        return name;
    }

    public int getText() {
        return text;
    }
}
