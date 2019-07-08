public class Main {
    public static void main(String[] args) {

        Animal[] list = new Animal[4];
        list[0] = new Bird(50);
        list[1] = new Penguin(50);
        list[2] = new Human(50);
        list[3] = new CarDriver(50);

        for(int i=0; i<list.length; i++) {
            list[i].walk();
            System.out.println("walk " + list[i]);

            if(list[i] instanceof Bird) {
                Bird b = (Bird)list[i];
                b.fly();
                System.out.println("fly " + b);
            }

            if(list[i] instanceof Human) {
                Human h = (Human)list[i];
                h.drive();
                System.out.println("drive " + h);
            }
        }
    }
}