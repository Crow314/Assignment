public class Dog extends Thread {

    private static int goalCount = 1;

    private String name;
    private double stepLength;
    private int stepInterval;

    public Dog(String name, double stepLength, int stepInterval){
        this.name = name;
        this.stepLength = stepLength;
        this.stepInterval = stepInterval;
    }

    @Override
    public void run() {
        double distance = 0;
        int goalDistance = 600;
        int[] checkPoint = {200, 400};
        int checkPointCount = 0;
        int remainGrateStatus = 0;

        while (distance < goalDistance){
            if(remainGrateStatus>0){
                distance += stepLength*2;
                remainGrateStatus--;

                if(remainGrateStatus == 0){
                    System.out.println(name + "は絶好調じゃなくなった");
                }
            }else{
                distance += stepLength;
            }

            if(checkPointCount<checkPoint.length){
                if(distance >= checkPoint[checkPointCount]){
                    System.out.println(name + "が" + checkPoint[checkPointCount] + "mに到達!");
                    checkPointCount++;
                }
            }

            int random = (int)(Math.random() * 100);
            if(random == 0 && remainGrateStatus == 0){
                remainGrateStatus = 10;
                System.out.println(name + "は絶好調!!");
            }

            try {
                Thread.sleep(stepInterval);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println(name + "が" + goalCount + "位でゴール!!");
        goalCount++;
    }

}
