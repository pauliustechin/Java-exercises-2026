package psem.checkoutstrategy.discount;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.discount.DiscountStrategy;

import java.math.BigDecimal;

public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public String getCode() {
        return "noDiscount";
    }

    @Override
    public BigDecimal calculateDiscount(CheckoutContext checkoutContext) {
        return BigDecimal.ZERO;
    }
}
