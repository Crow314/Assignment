public class CarDriver extends Human {

    public CarDriver(int vitality){
        super(vitality);
    }

    @Override
    public void drive(){
        super.movePosition(8);
        super.useVitality(1);
    }

    @Override
    public void walk(){}
}
