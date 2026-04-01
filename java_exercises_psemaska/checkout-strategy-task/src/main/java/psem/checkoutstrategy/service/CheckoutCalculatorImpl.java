package psem.checkoutstrategy.service;

import academy.tasks.checkoutstrategy.domain.CheckoutContext;
import academy.tasks.checkoutstrategy.domain.PriceBreakdown;
import academy.tasks.checkoutstrategy.service.CheckoutCalculator;
import academy.tasks.checkoutstrategy.strategy.discount.DiscountStrategy;
import academy.tasks.checkoutstrategy.strategy.shipping.ShippingStrategy;

import java.math.BigDecimal;

public class CheckoutCalculatorImpl implements CheckoutCalculator {

    @Override
    public PriceBreakdown calculate(CheckoutContext checkoutContext, DiscountStrategy discountStrategy, ShippingStrategy shippingStrategy) {

        BigDecimal finalTotal = checkoutContext.getItemsSubtotal()
                .subtract(discountStrategy.calculateDiscount(checkoutContext))
                .add(shippingStrategy.calculateShipping(checkoutContext));

        PriceBreakdown priceBreakdown = new PriceBreakdown(
                checkoutContext.getItemsSubtotal(),
                discountStrategy.calculateDiscount(checkoutContext),
                shippingStrategy.calculateShipping(checkoutContext),
                finalTotal
        );

        return priceBreakdown;
    }
}
