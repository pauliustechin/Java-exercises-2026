package psem.checkoutstrategy.shipping;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.shipping.ShippingStrategy;

import java.math.BigDecimal;

public class ShippingStrategyImpl implements ShippingStrategy {

    private String code;
    private BigDecimal shippingCost;
    private BigDecimal subtotalThreshold;

    public ShippingStrategyImpl(BigDecimal rate, String code) {
        this.shippingCost = rate;
        this.code = code;
    }

    public ShippingStrategyImpl(BigDecimal subtotalThreshold, BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
        this.subtotalThreshold = subtotalThreshold;
        this.code = "threshold";
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public BigDecimal calculateShipping(CheckoutContext checkoutContext) {
        if(code.equals("flat")) {
            return shippingCost;
        } else if (code.equals("perItem")) {
            BigDecimal totalItems = new BigDecimal(checkoutContext.getTotalItemCount());
            return shippingCost.multiply(totalItems);
        }
        else {
            if(checkoutContext.getItemsSubtotal().compareTo(subtotalThreshold) >= 0) {
                return BigDecimal.ZERO;
            } else {
                return shippingCost;
            }
        }
    }
}
