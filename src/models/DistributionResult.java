package models;

public class DistributionResult {
    private final Distributor deliver;
    private final Distributor restaurant;
    private final Distributor platform;

    private DistributionResult(Builder builder) {
        this.deliver = builder.deliver;
        this.restaurant = builder.restaurant;
        this.platform = builder.platform;
    }

    public static class Builder {
        private Distributor deliver;
        private Distributor restaurant;
        private Distributor platform;

        public Builder(){
            this.deliver = null;
            this.restaurant = null;
            this.platform = null;
        }

        public Builder setDeliver(Distributor deliver) {
            this.deliver = deliver;
            return this;
        }

        public Builder setRestaurant(Distributor restaurant) {
            this.restaurant = restaurant;
            return this;
        }

        public Builder setPlatform(Distributor platform) {
            this.platform = platform;
            return this;
        }

        public DistributionResult build() {
            return new DistributionResult(this);
        }
    }
}
