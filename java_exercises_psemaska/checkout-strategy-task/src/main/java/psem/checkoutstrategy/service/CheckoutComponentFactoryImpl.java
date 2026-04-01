package psem.checkoutstrategy.service;

import academy.tasks.checkoutstrategy.service.CheckoutComponentFactory;
import academy.tasks.checkoutstrategy.strategy.discount.DiscountStrategy;
import academy.tasks.checkoutstrategy.strategy.shipping.ShippingStrategy;
import psem.checkoutstrategy.discount.DiscountStrategyImpl;
import psem.checkoutstrategy.shipping.ShippingStrategyImpl;

import java.math.BigDecimal;

public class CheckoutComponentFactoryImpl implements CheckoutComponentFactory {

    @Override
    public DiscountStrategy createNoDiscountStrategy() {
        return new DiscountStrategyImpl();
    }

    @Override
    public DiscountStrategy createPercentageDiscountStrategy(BigDecimal bigDecimal) {
        if(bigDecimal.compareTo(new BigDecimal(100)) > 0) {
            return new DiscountStrategyImpl(new BigDecimal(100));
//            throw new IllegalArgumentException("Percentage discount can't be higher than 100%");
        }
        return new DiscountStrategyImpl(bigDecimal);
    }

    @Override
    public DiscountStrategy createThresholdDiscountStrategy(BigDecimal subtotalThreshold, BigDecimal discountAmount) {
        return new DiscountStrategyImpl(subtotalThreshold, discountAmount);
    }

    @Override
    public ShippingStrategy createFlatRateShippingStrategy(BigDecimal rate) {
        return new ShippingStrategyImpl(rate, "flat");
    }

    @Override
    public ShippingStrategy createFreeShippingOverThresholdStrategy(BigDecimal subtotalThreshold, BigDecimal rate) {
        return new ShippingStrategyImpl(subtotalThreshold, rate);
    }

    @Override
    public ShippingStrategy createPerItemShippingStrategy(BigDecimal rate) {
        return new ShippingStrategyImpl(rate, "perItem");
    }

}
