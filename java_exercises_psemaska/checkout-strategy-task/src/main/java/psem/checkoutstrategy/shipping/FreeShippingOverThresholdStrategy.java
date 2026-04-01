package psem.checkoutstrategy.shipping;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.shipping.ShippingStrategy;

import java.math.BigDecimal;

public class FreeShippingOverThresholdStrategy implements ShippingStrategy {

    private BigDecimal subtotalThreshold;
    private BigDecimal shippingCost;

    public FreeShippingOverThresholdStrategy(BigDecimal subtotalThreshold, BigDecimal shippingCost) {
        this.subtotalThreshold = subtotalThreshold;
        this.shippingCost = shippingCost;
    }

    @Override
    public String getCode() {
        return "";
    }

    @Override
    public BigDecimal calculateShipping(CheckoutContext checkoutContext) {
        if(checkoutContext.getItemsSubtotal().compareTo(subtotalThreshold) >= 0) {
            return BigDecimal.ZERO;
        } else {
            return shippingCost;
        }
    }
}
