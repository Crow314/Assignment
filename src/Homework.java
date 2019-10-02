public class Homework {
    private int level;
    private String kamoku;

    public Homework(String kamoku, int level) {
        this.kamoku = kamoku;
        this.level = level;
    }

    public String getKamoku() {
        return kamoku;
    }

    public int getLevel() {
        return level;
    }

    public String toString() {
        return kamoku + "(Level:" + level + ")";
    }
}