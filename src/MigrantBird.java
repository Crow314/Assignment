public class MigrantBird extends Bird {

    MigrantBird(int vitality){
        super(vitality);
    }

    public void sleep(){
        super.movePosition(3);
    }
}
