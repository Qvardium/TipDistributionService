package models;

public record Delivery(
        Long orderId,
        Long courierId,
        Long restaurantId,
        boolean isHardDelivery
) {
}
