import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //5科目の点数を入力し，配列scoreに格納
        int[] score = input(5);

        //合計を計算し，表示
        int total = total(score);
        System.out.println("Total:" + total);

        //平均点を計算し，表示
        double average = average(score);
        System.out.println("Average:" + average);
    }

    private static int[] input(int kamoku) {
        int[] list = new int[kamoku];

        Scanner in = new Scanner(System.in);
        for(int i=0; i<kamoku; i++)
            list[i] = in.nextInt();

        return list;
    }

    private static int total(int[] score){
        int result = 0;
        for(int i=0; i<score.length; i++){
            result += score[i];
        }
        return result;
    }

    private static double average(int[] score){
        double result = 0.0;
        for(int i=0; i<score.length; i++){
            result += score[i];
        }

        result /= score.length;

        return result;
    }

}