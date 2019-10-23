import java.util.ArrayList;
import java.util.List;

public class Party {

    private List<Character> member = new ArrayList<>();
    private int money;

    Party(int money){
        this.money = money;
    }

    public void add(Character c, int n){
        if(member.size()<8){
            try{
                member.add(n, c);
            }catch (Exception e){
                //I have no processing;
            }
        }
    }

    public void remove(int n){
        try{
            member.remove(n);
        }catch (Exception e){
            //I have no processing;
        }
    }

    public void change(int first, int second){
        try{
            Character tmpCharacter = member.get(first);
            member.set(first, member.get(second));
            member.set(second, tmpCharacter);
        }catch (Exception e){
            //I have no processing;
        }
    }

    public void show(){
        for(Character c : member){
            System.out.println(c.getName() + "[LV:" + c.getLevel() + "] " + c.getHp() + "/" + c.getMp());
        }
        System.out.println("Money:" + money);
    }

}
