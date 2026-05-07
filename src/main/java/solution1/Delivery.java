package solution1;

public record Delivery(
        String orderId,
        String courierId,
        String restaurantId,
        boolean hardDelivery,
        boolean restaurantInLoyaltyProgram
) {
}