public class Report extends Homework{
    private int experiment;

    public Report(String name, int experiment){
        super(name);
        this.experiment = experiment;
    }

    public void proceedExperiment(int n){
        experiment -=n;
        experiment = Integer.max(experiment, 0);
    }

    @Override
    public void proceed(int n){
        if(experiment == 0){
            super.proceed(n);
        }
    }

    @Override
    public String toString(){
        return getName() + ": text(" + getText() + ") experiment("+ experiment +")";
    }
}
