package psem.checkoutstrategy.shipping;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.shipping.ShippingStrategy;

import java.math.BigDecimal;

public class FlatRateShippingStrategy implements ShippingStrategy {

    private BigDecimal shippingCost;

    public FlatRateShippingStrategy(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    @Override
    public String getCode() {
        return "flatRate";
    }

    @Override
    public BigDecimal calculateShipping(CheckoutContext checkoutContext) {
        return shippingCost;
    }
}
