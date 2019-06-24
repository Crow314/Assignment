public class Car {

    private String color;
    private String no;

    Car(String no, String color){
        this.color = color;
        this.no = no;
    }

    public String getColor() {
        return color;
    }

    public String getNo() {
        return no;
    }

    @Override
    public String toString(){
        return no + "(" + color + ")";
    }
}
