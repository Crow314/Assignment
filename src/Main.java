import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>();

        set.add("abc");
        set.add("pqr");
        set.add("del");
        set.add("あいうえお");
        set.add("アイウエオ");
        set.add("有");
        set.add("かきくけこ");
        set.add("さしすせそ");
        set.add("カキクケコ");
        set.add("サシスセソ");
        set.add("課");
        set.add("差");
        set.add("消");

        System.out.println(set);

        System.out.println("deleate \"del\" & \"消\"");

        set.remove("del");
        set.remove("消");

        System.out.println(set);

    }
}


/*
[abc, del, pqr, あいうえお, かきくけこ, さしすせそ, アイウエオ, カキクケコ, サシスセソ, 差, 有, 消, 課]
deleate "del" & "消"
[abc, pqr, あいうえお, かきくけこ, さしすせそ, アイウエオ, カキクケコ, サシスセソ, 差, 有, 課]


上記の通り正常に追加ができていることがわかる。
また、削除も行えていることがわかる。

並び順は先頭文字のアルファベット順や、五十音に並んでいることがわかる。
ただし、漢字はこのとおり並んでいない。
ここで、漢字の並び順は文字コード順である。
また、アルファベットやひらがな・カタカナは辞書順にUnicodeに登録されている。
よって、String型は文字コード順に並ぶといえる。
 */
