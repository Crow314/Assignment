public class Penguin extends Bird {

    public Penguin(int vitality){
        super(vitality);
    }

    @Override
    public void fly(){
        useVitality(1);
    }
}
