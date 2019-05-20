import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();

        Rect rect = new Rect(w, h);

        int area = rect.getArea();
        Point[] points = rect.getPoints();

        System.out.println(points[0] + " " + points[1] + " " + points[2] + " " + points[3] + " Area:" + area);
    }
}

class Rect{

    private int area;
    private Point[] points = new Point[4];

    Rect(int w, int h){
        this.area = w * h;

        points[0] = new Point(0, 0);
        points[1] = new Point(w, 0);
        points[2] = new Point(0, h);
        points[3] = new Point(w, h);
    }

    public int getArea() {
        return area;
    }

    public Point[] getPoints() {
        return points;
    }
}

class Point{
    private int x;
    private int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + x + "," + y + ")";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}