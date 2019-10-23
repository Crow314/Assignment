import java.util.HashMap;
import java.util.Map;

public class Character {

    private String name;
    private String job;
    private boolean isMale;
    private int level;
    private int hp;
    private int mp;
    private Map<String, Integer> status = new HashMap<>();

    Character(String name, String job, boolean isMale){
        this.name = name;
        this.job = job;
        this.isMale = isMale;
        this.level = 1;
        this.hp = 5;
        this.mp = 5;

        this.status.put("STR", 5);
        this.status.put("DEX", 5);
        this.status.put("VIT", 5);
        this.status.put("INT", 5);
        this.status.put("LUK", 5);
        this.status.put("MaxHP", 5);
        this.status.put("MaxMP", 5);
        this.status.put("ATK", 5);
        this.status.put("DEF", 5);
        this.status.put("Ex", 0);
    }

    public boolean addEx(int ex){
        boolean result = false;

        ex += status.get("Ex");
        status.put("Ex", ex);

        while(ex >= level*10){
            result = true;
            level++;
            status.put("STR", status.get("STR")+2);
            status.put("DEX", status.get("DEX")+2);
            status.put("VIT", status.get("VIT")+2);
            status.put("INT", status.get("INT")+2);
            status.put("LUK", status.get("LUK")+2);
            status.put("MaxHP", status.get("MaxHP")+2);
            status.put("MaxMP", status.get("MaxMP")+2);
            status.put("ATK", status.get("ATK")+2);
            status.put("DEF", status.get("DEF")+2);
        }
        return result;
    }

    @Override
    public String toString(){
        return name + "(" + job + ":" + (isMale?"M":"F") + ") LV" + level + "[" + hp + "/" + mp + "]" + status;
    }

}
