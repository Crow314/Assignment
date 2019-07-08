public class Main {
    public static void main(String[] args) {
        Homework[] list = new Homework[5];

        list[0] = new Homework("国語3");
        list[1] = new Programming("プログラミング2", 70);
        list[2] = new Homework("公共");
        list[3] = new Report("情報工学実験2", 120);
        list[4] = new Programming("DBとWebアプリ", 120);


        for(int i=0; i<list.length; i++) {
            int time = 0;

            while(! list[i].isFinish()) {
                list[i].proceed(20);

                if(list[i] instanceof Report) {
                    Report r = (Report)list[i];
                    r.proceedExperiment(15);
                }

                time++;
            }
            System.out.println(list[i].getName() + "に" + time + "時間かかった");
        }
    }
}