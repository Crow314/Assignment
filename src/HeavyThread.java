public class HeavyThread extends Thread{

    private String name;
    private int interval;

    public HeavyThread(String name, int interval){
        this.name = name;
        this.interval = interval;
    }

    public void run(){
        for(int i=5; i>0; i--){
            try {
                Thread.sleep(interval); //処理を(約)1000ms止める．例外の可能性あり
            } catch (InterruptedException e) { /*略*/ }
            System.out.println(name + ":" + i);
        }
    }
}
