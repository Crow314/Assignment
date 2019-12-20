public class Calculator extends Thread{

    private String name;
    private int num;

    public Calculator(String name,int num){
        this.name = name;
        this.num = num;
    }

    @Override
    public void run() {
        //I am processing...
        synchronized (System.out){
            System.out.println("演算器" + name + "は演算中");
        }

        try {
            Thread.sleep((long)(Math.random()*500)+500); //This is heavy process.
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        synchronized (System.out){
            System.out.print("演算器" + name + "[");
            for(int i=0; i<=num; i++){
                System.out.print(i + ",");
                try {
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("]");
        }
    }
}
