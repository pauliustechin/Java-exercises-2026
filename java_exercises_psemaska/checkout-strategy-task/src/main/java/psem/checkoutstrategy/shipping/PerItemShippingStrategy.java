package psem.checkoutstrategy.shipping;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.shipping.ShippingStrategy;

import java.math.BigDecimal;

public class PerItemShippingStrategy implements ShippingStrategy {

    private BigDecimal shippingCostPerItem;

    public PerItemShippingStrategy(BigDecimal shippingCostPerItem) {
        this.shippingCostPerItem = shippingCostPerItem;
    }

    @Override
    public String getCode() {
        return "perItem";
    }

    @Override
    public BigDecimal calculateShipping(CheckoutContext checkoutContext) {
        BigDecimal totalItems = new BigDecimal(checkoutContext.getTotalItemCount());
        return shippingCostPerItem.multiply(totalItems);
    }
}
