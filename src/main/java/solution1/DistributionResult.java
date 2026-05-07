package solution1;

import java.util.Map;

public record DistributionResult(
        String orderId,
        Map<Participant, Long> amounts
) {
    public long courierAmount() {
        return amounts.getOrDefault(Participant.COURIER, 0L);
    }

    public long restaurantAmount() {
        return amounts.getOrDefault(Participant.RESTAURANT, 0L);
    }

    public long platformAmount() {
        return amounts.getOrDefault(Participant.PLATFORM, 0L);
    }

    public long total() {
        return amounts.values().stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}