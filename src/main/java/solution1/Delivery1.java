package solution1;

public record Delivery1(
        String orderId,
        String courierId,
        String restaurantId,
        boolean hardDelivery,
        boolean restaurantInLoyaltyProgram
) {
}