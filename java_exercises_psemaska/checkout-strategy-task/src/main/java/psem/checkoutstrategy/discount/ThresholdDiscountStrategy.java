package psem.checkoutstrategy.discount;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.discount.DiscountStrategy;

import java.math.BigDecimal;

public class ThresholdDiscountStrategy implements DiscountStrategy {

    private BigDecimal subtotalThreshold;
    private BigDecimal discountAmount;

    public ThresholdDiscountStrategy(BigDecimal subtotalThreshold, BigDecimal discountAmount) {
        this.subtotalThreshold = subtotalThreshold;
        this.discountAmount = discountAmount;
    }

    @Override
    public String getCode() {
        return "threshold";
    }

    @Override
    public BigDecimal calculateDiscount(CheckoutContext checkoutContext) {

        if(checkoutContext.getItemsSubtotal().compareTo(subtotalThreshold) >= 0) {
            return discountAmount;
        } else {
            return BigDecimal.ZERO;
        }
    }
}
