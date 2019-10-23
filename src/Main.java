import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        Party heroes = new Party(stdIn.nextInt());

        heroes.add(new Character("AAAA", "Hero", true),0);
        heroes.add(new Character("Ryan", "Soldier", true),1);
        heroes.add(new Character("Borya", "Mage", true),2);
        heroes.add(new Character("Alena", "Martial Artist", false),3);

        heroes.show();

        switch(stdIn.nextInt()){
            case 1:
                System.out.println("===remove Borya===");
                heroes.remove(2);
                heroes.show();
                break;

            case 2:
                System.out.println("===add Meena between Ryan and Borya===");
                heroes.add(new Character("Meena", "Fortune-teller", false),2);
                heroes.show();
                break;

            case 3:
                System.out.println("===change AAAA and Ryan===");
                heroes.change(0, 1);
                heroes.show();
                break;

            case 4:
                System.out.println("===add 5 heroes===");
                heroes.add(new Character("Kiryl", "Priest", true),4);
                heroes.add(new Character("Torneko", "Weapons merchant", true),5);
                heroes.add(new Character("Healie", "Healslime", false),6);
                heroes.add(new Character("Sparkie", "Baby dragon", true),7);
                heroes.add(new Character("Tom", "Performer", true),8);

                heroes.show();
                break;

            case 5:
                System.out.println("===remove all heroes===");
                heroes.remove(0);
                heroes.remove(0);
                heroes.show();
                heroes.remove(0);
                heroes.remove(0);
                heroes.remove(0);
                heroes.show();
        }


        stdIn.close();
    }
}