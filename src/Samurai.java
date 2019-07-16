public class Samurai extends Character implements Fighter {

    Samurai(String name, int hp, int strength, int intelligence){
        super(name, hp, strength, intelligence);
    }

    @Override
    public int magic(){
        return 0;
    }

    @Override
    public void ready(){
        addSP(3);
    }

    @Override
    public int specialCalc(){
        return attack() * 5;
    }

    @Override
    public void listAction() {
        System.out.println("1:attack, 3:ready, 5:special");
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

            case 3:
                ready();
                result = true;
                output = "ready";
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
