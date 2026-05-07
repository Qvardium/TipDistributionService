package solution1;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;

public class TipDistributionService {

    private static final int HARD_DELIVERY_BONUS_PERCENT = 15;

    public DistributionResult distribute(long tipAmount, Delivery1 delivery1) {
        if (tipAmount < 0) {
            throw new IllegalArgumentException("tipAmount must not be negative");
        }

        Objects.requireNonNull(delivery1, "delivery must not be null");

        long platformAmount = percentFloor(tipAmount, Participant.PLATFORM.getPercent());

        long restaurantAmount = delivery1.restaurantInLoyaltyProgram()
                ? percentFloor(tipAmount, Participant.RESTAURANT.getPercent())
                : 0;

        if (delivery1.hardDelivery()) {
            long courierBonus = percentFloor(tipAmount, HARD_DELIVERY_BONUS_PERCENT);

            // Бонус курьеру идёт за счёт платформы,
            // но платформа не может уйти в минус.
            long amountTakenFromPlatform = Math.min(platformAmount, courierBonus);

            platformAmount -= amountTakenFromPlatform;
        }

        long courierAmount = tipAmount - platformAmount - restaurantAmount;

        if (courierAmount < 0) {
            throw new IllegalStateException("Courier amount became negative");
        }

        Map<Participant, Long> result = new EnumMap<>(Participant.class);
        result.put(Participant.COURIER, courierAmount);
        result.put(Participant.RESTAURANT, restaurantAmount);
        result.put(Participant.PLATFORM, platformAmount);

        validateResult(tipAmount, result);

        return new DistributionResult(delivery1.orderId(), result);
    }

    private long percentFloor(long amount, int percent) {
        return amount * percent / 100;
    }

    private void validateResult(long originalAmount, Map<Participant, Long> result) {
        long total = 0;

        for (Map.Entry<Participant, Long> entry : result.entrySet()) {
            if (entry.getValue() < 0) {
                throw new IllegalStateException(
                        "Negative amount for participant: " + entry.getKey()
                );
            }

            total += entry.getValue();
        }

        if (total != originalAmount) {
            throw new IllegalStateException(
                    "Distribution total does not match original tip amount"
            );
        }
    }
}