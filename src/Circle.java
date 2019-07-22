public class Circle {

    private int r;

    Circle(int r){
        this.r = r;
    }

    public int calcArea(){
        return (int) Math.round(Math.pow(r, 2) * Math.PI);
    }

    @Override
    public String toString(){
        return "r:" + r + " area:" + calcArea();
    }

    public int getR() {
        return r;
    }
}
