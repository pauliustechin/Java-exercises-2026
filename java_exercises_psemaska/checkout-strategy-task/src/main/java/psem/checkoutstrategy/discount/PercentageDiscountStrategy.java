package psem.checkoutstrategy.discount;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.strategy.discount.DiscountStrategy;

import java.math.BigDecimal;

public class PercentageDiscountStrategy implements DiscountStrategy {

    private BigDecimal discountPercentage;

    public PercentageDiscountStrategy(BigDecimal discountPercentage) {

        if(discountPercentage.compareTo(new BigDecimal(100)) > 0) {
            this.discountPercentage = BigDecimal.ONE;
        } else {
            this.discountPercentage = discountPercentage.divide(new BigDecimal(100));
        }

    }

    @Override
    public String getCode() {
        return "percentageDiscount";
    }

    @Override
    public BigDecimal calculateDiscount(CheckoutContext checkoutContext) {
        BigDecimal bigDecimal =  checkoutContext.getItemsSubtotal().multiply(discountPercentage);
        return bigDecimal;
    }
}
