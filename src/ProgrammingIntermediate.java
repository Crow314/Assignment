public class ProgrammingIntermediate extends Student {

    public ProgrammingIntermediate(String name){
        super(name);
    }

    @Override
    public boolean resolve(Homework hw) {
        if(hw.getKamoku().compareTo("Programming") == 0 && hw.getLevel() < 3) {
            return true;
        }
        return false;
    }
}
