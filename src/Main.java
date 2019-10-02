import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Student alice = new EigoMaster("alice"); //英語ならすべての難易度の課題が解ける学生
        Student bob = new AllNovice("bob"); //難易度が2未満ならすべての科目の課題が解ける学生
        Student charlie = new ProgrammingIntermediate("charlie"); //難易度が3未満のプログラミングの課題なら解ける学生

        alice.setNext(bob);
        bob.setNext(charlie);

        Scanner sc = new Scanner(System.in);
        int level = sc.nextInt();
        sc.close();

        Homework hw1 = new Homework("Kairo", level);
        alice.tryHomework(hw1);

        Homework hw2 = new Homework("Kairo", 2);
        alice.tryHomework(hw2);

        Homework hw3 = new Homework("Eigo", 3);
        alice.tryHomework(hw3);

        Homework hw4 = new Homework("Programming", 2);
        alice.tryHomework(hw4);

        Homework hw5 = new Homework("Programming", level);
        alice.tryHomework(hw5);
    }
}