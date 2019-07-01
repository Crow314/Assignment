public class Human extends Animal {
    private boolean isRide;

    Human(int vitality){
        super(vitality);
    }

    public void rideOn(){
        isRide = true;
        super.useVitality(1);
    }

    public void getDown(){
        isRide = false;
        super.useVitality(1);
    }

    public void drive(){
        if(isRide){
            super.movePosition(5);
            super.useVitality(3);
        }
    }
}
