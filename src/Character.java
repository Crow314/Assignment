public abstract class Character {

    private String name;
    private int hp;
    private int sp;
    private int strength;
    private int intelligence;

    public Character (String name, int hp, int strength, int intelligence){
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.intelligence = intelligence;
        this.sp = 0;
    }

    public void addSP(int point){
        sp += point;
    }

    public int attack(){
        sp++;
        return strength * 2;
    }

    public int magic(){
        sp++;
        return intelligence * 2;
    }

    public void addDamage(int damage){
        hp -= damage;
    }

    public boolean isDown(){
        return hp <= 0;
    }

    public int special(){
        if(sp <= 4){
            return -1;
        }

        int special = specialCalc();
        sp = 0;
        return special;
    }

    public abstract int specialCalc();

    public abstract void listAction();

    public abstract boolean act(int type, Character c);

    @Override
    public String toString(){
        return name + " HP:" + hp + " SP:" + sp;
    }

    public String getName() {
        return name;
    }
}
