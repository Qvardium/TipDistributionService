package services;

import models.Delivery;
import models.DistributionResult;

public class TipDistributionService {

    /**
     * Распределить чаевые между участниками.
     *
     * @param tipAmount сумма чаевых в копейках
     * @param delivery информация о доставке
     * @return результат распределения
     */
    public DistributionResult distribute(long tipAmount, Delivery delivery) {
        // место для кода
        return new DistributionResult.Builder().build();
    }
}
