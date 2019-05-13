import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int w = sc.nextInt();
        int h = sc.nextInt();

        Rect rect = new Rect(w, h);

        System.out.println("The rectangle has " + rect.getHeight() + " height, " + rect.getWidth() + " width and " + rect.getArea() + " area.");
    }
}

class Rect{
    private int width;
    private int height;
    private int area;

    Rect(int w, int h){
        this.width = w;
        this.height = h;
        this.area = w * h;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return area;
    }
}