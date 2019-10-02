public class AllNovice extends Student {
    public AllNovice(String name) {
        super(name);
    }

    @Override
    public boolean resolve(Homework hw) {
        if(hw.getLevel() < 2) {
            return true;
        }else {
            return false;
        }
    }
}