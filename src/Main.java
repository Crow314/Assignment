import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        int n = 33554432;
        Random rand = new Random();

        System.out.println("連続追加");

        long timeArray = System.currentTimeMillis();
        int[] array = new int[n];
        for(int i=0; i<array.length; i++){
            array[i] = rand.nextInt(1024);
        }
        timeArray = System.currentTimeMillis() - timeArray;

        long timeArrayList = System.currentTimeMillis();
        List<Integer> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            arrayList.add(rand.nextInt(1024));
        }
        timeArrayList = System.currentTimeMillis() - timeArrayList;

        System.out.println("配列: " + timeArray + " ms");
        System.out.println("ArrayList: " + timeArrayList + " ms");

        System.out.println("検索(指定値要素数カウント)");

        timeArray = System.currentTimeMillis();
        int count = 0;
        int randNum = rand.nextInt(1024);
        for(int i=0; i<array.length; i++){
            if(array[i] == randNum){
                count++;
            }
        }
        timeArray = System.currentTimeMillis() - timeArray;

        timeArrayList = System.currentTimeMillis();
        count = 0;
        randNum = rand.nextInt(1024);
        for(int i=0; i<arrayList.size(); i++){
            if(arrayList.get(i) == randNum){
                count++;
            }
        }
        timeArrayList = System.currentTimeMillis() - timeArrayList;

        System.out.println("配列: " + timeArray + " ms");
        System.out.println("ArrayList: " + timeArrayList + " ms");
    }
}

/*
連続追加
配列: 444 ms
ArrayList: 24407 ms
検索(指定値要素数カウント)
配列: 27 ms
ArrayList: 112 ms

上のコードで2^25の長さを持つ配列に、要素を順番に代入する場合と、
同じ個数の要素をArrayListの末尾に追加していくのにかかる時間を比較する。
ここで、要素は0以上1024未満のランダムな整数とする。
この結果、配列に要素を代入した場合に比べ、ArrayListの末尾に追加した場合は、40～60倍程度の時間がかかることがわかった。
これは、ArrayListにおいて要素を追加する際の処理に大きな負荷がかかるためと考えられる。

続いて、上の処理で代入した配列及びArrayListに対し、ランダムな値の要素を指定し、その値がいくつ含まれているかを数え上げる処理を行った。
これは、配列及びArrayListに含まれる全ての要素を参照する処理である。
この結果、ArrayListでは配列に比べ5倍程度の時間がかかった。
これにより、要素の追加ほど大きな負荷ではないものの、連続した要素を参照する際にも配列ほど単純には処理が行えないものと考えられる。
 */