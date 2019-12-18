public class RaceManager {
    private int goalCount;

    public RaceManager(){
        goalCount = 1;
    }

    public int getGoalCount() {
        return goalCount;
    }

    public void countUp() {
        this.goalCount++;
    }
}
