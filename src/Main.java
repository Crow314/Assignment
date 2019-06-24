public class Main {
    public static void main(String[] args) {
        Slot[] slots = new Slot[4];

        for(int i=0; i<slots.length; i++)
            slots[i] = new Slot();

        System.out.println("初期状態");
        for(int i=0; i<slots.length; i++)
            System.out.println(slots[i]);

        Car c1 = new Car("1234", "white");
        System.err.println(slots[0].contract(c1));

        Car c2 = new Car(" 777", "red");
        System.err.println(slots[1].contract(c2));

        System.out.println("2台契約後");
        for(int i=0; i<slots.length; i++)
            System.out.println(slots[i]);

        System.err.println(slots[0].carIn(c1));
        System.err.println(slots[2].carIn(c2));


        System.out.println("2台駐車後");
        for(int i=0; i<slots.length; i++)
            System.out.println(slots[i]);

        System.out.println("チェック");
        for(int i=0; i<slots.length; i++) {
            if(!slots[i].check())
                System.out.println(i + "番で異常検出! " + slots[i]);

        }
    }
}