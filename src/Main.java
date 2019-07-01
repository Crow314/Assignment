public class Main {
    public static void main(String[] args) {
        System.out.println("Animal");
        Animal a = new Animal(80);
        System.out.println("start " + a);
        a.walk();
        System.out.println("walk " + a);
        a.eat();
        System.out.println("eat " + a);
        ////////////////////////////////////

        System.out.println();
        System.out.println("Human");
        Human h = new Human(60);
        System.out.println("start " + h);
        h.walk();
        System.out.println("walk " + h);
        h.eat();
        System.out.println("eat " + h);
        h.rideOn();
        h.drive();
        System.out.println("ride on and drive " + h);
        h.getDown();
        h.drive();
        System.out.println("get down and drive " + h);
        ////////////////////////////////////

        System.out.println();
        System.out.println("Bird");
        Bird b = new Bird(50);
        System.out.println("start " + b);
        b.walk();
        System.out.println("walk " + b);
        b.eat();
        System.out.println("eat " + b);
        b.fly();
        System.out.println("fly " + b);
        ////////////////////////////////////

        System.out.println();
        System.out.println("Migrant Bird");
        MigrantBird m = new MigrantBird(100);
        System.out.println("start " + m);
        m.walk();
        System.out.println("walk " + m);
        m.eat();
        System.out.println("eat " + m);
        m.fly();
        System.out.println("fly " + m);
        m.sleep();
        System.out.println("sleep " + m);
    }
}