public class Animal {
    private int position;
    private int currentVitality;
    private  int maxVitality;

    Animal(int vitality){
        this.currentVitality = vitality;
        this.maxVitality = vitality;
        this.position = 0;
    }

    public void movePosition(int n){
        position += n;
    }

    public void useVitality(int n){
        currentVitality -= n;
    }

    public void walk(){
        position++;
        currentVitality--;
    }

    public void eat(){
        currentVitality = maxVitality;
    }

    @Override
    public String toString(){
        return "pos:" + position +" vit:" + currentVitality + "/" + maxVitality;
    }
}
