package psem.checkoutstrategy.discount;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.discount.DiscountStrategy;
import java.math.BigDecimal;

public class DiscountStrategyImpl implements DiscountStrategy {

    private BigDecimal discount;
    private BigDecimal subtotalThreshold;
    private String code;

    public DiscountStrategyImpl() {
        this.discount = BigDecimal.ZERO;
        this.code = "zero";
    }

    public DiscountStrategyImpl(BigDecimal discount) {
        this.discount = discount.divide(new BigDecimal(100));
        this.code = "discount";
    }

    public DiscountStrategyImpl(BigDecimal subtotalThreshold, BigDecimal discountAmount) {
        this.subtotalThreshold = subtotalThreshold;
        this.discount = discountAmount;
        this.code = "threshold";
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public BigDecimal calculateDiscount(CheckoutContext checkoutContext) {

        if(subtotalThreshold != null) {
            if(checkoutContext.getItemsSubtotal().compareTo(subtotalThreshold) >= 0) {
                return discount;
            } else {
                return BigDecimal.ZERO;
            }
        }

        return checkoutContext.getItemsSubtotal().multiply(discount);
    }
}
