public class Car {
    private int tankSize;
    private int currentFuel;
    private double mileage;
    private double position;

    Car(int tankSize, double mileage){
        this.tankSize = tankSize;
        this.currentFuel = 0;
        this.mileage = mileage;
        this.position = 0;
    }

    public void fillUp(){
        this.currentFuel = this.tankSize;
    }

    public boolean move(int n){
        boolean flg = false;
        if(n <= currentFuel){
            position += n*mileage;
            currentFuel -= n;
            flg = true;
        }else{
            position += currentFuel*mileage;
            currentFuel = 0;
            flg = false;
        }
        return flg;
    }

    @Override
    public String toString(){
        return "Fuel:" + currentFuel + "/" + tankSize + " Pos:" + position;
    }

    public int getTankSize() {
        return tankSize;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }

    public double getMileage() {
        return mileage;
    }

    public double getPosition() {
        return position;
    }
}
