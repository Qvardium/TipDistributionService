package solution1;

public enum Participant {
    COURIER(100),
    RESTAURANT(10),
    PLATFORM(5);

    private final int percent;

    private Participant(int percent) {
        this.percent = percent;
    }

    public int getPercent() {
        return percent;
    }
}
