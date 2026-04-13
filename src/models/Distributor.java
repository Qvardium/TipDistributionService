package models;

public enum Distributor {
    Platform(0.05f),
    Restaurant(0.1f),
    Deliver(1f);

    private final float procent;

    Distributor(float procent) {
        this.procent = procent;
    }

    public long calculateTips(Delivery delivery, long tipsAmount) {
        return tipsAmount;
    }
}
