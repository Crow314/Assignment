public class Bird extends Animal {

    Bird(int vitality){
        super(vitality);
    }

    public void fly(){
        super.movePosition(3);
        super.useVitality(1);
    }
}
