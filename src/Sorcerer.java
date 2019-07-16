public class Sorcerer extends Character implements Wizard {

    private int concentration;

    Sorcerer(String name, int hp, int strength, int intelligence){
        super(name, hp, strength, intelligence);
        this.concentration = 1;
    }

    @Override
    public void concentrate() {
        concentration *= 2;
    }

    @Override
    public int magic() {
        return super.magic()*concentration;
    }

    @Override
    public int specialCalc() {
        int special = magic()*2;
        concentration--;
        return special;
    }

    @Override
    public void listAction() {
        System.out.println("1:attack, 2:magic, 4:concentrate, 5:special");
    }

    @Override
    public boolean act(int type, Character c) {
        boolean result = false;
        String output = "Invalid input!";

        switch (type){
            case 1:
                c.addDamage(attack());
                result = true;
                output = "attack";
                break;

            case 2:
                c.addDamage(magic());
                result = true;
                output = "magic";
                break;

            case 4:
                concentrate();
                result = true;
                output = "concentrate";
                break;

            case 5:
                int special = special();
                if(special == -1){
                    result = false;
                    output = "lack of SP";
                }else{
                    c.addDamage(special);
                    result = true;
                    output = "special";
                }
                break;
        }
        System.out.println(output);
        return result;
    }
}
