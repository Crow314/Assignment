public class EigoMaster extends Student {
    public EigoMaster(String name) {
        super(name);
    }

    @Override
    public boolean resolve(Homework hw) {
        if(hw.getKamoku().compareTo("Eigo") == 0) {
            return true;
        }
        return false;
    }

}