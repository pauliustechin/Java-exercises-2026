package psem.checkoutstrategy.service;

import academy.tasks.checkoutstrategy.service.CheckoutComponentFactory;
import academy.tasks.checkoutstrategy.strategy.discount.DiscountStrategy;
import academy.tasks.checkoutstrategy.strategy.shipping.ShippingStrategy;
import psem.checkoutstrategy.discount.NoDiscountStrategy;
import psem.checkoutstrategy.discount.PercentageDiscountStrategy;
import psem.checkoutstrategy.discount.ThresholdDiscountStrategy;
import psem.checkoutstrategy.shipping.FlatRateShippingStrategy;
import psem.checkoutstrategy.shipping.FreeShippingOverThresholdStrategy;
import psem.checkoutstrategy.shipping.PerItemShippingStrategy;

import java.math.BigDecimal;

public class CheckoutComponentFactoryImpl implements CheckoutComponentFactory {

    @Override
    public DiscountStrategy createNoDiscountStrategy() {
        return new NoDiscountStrategy();
    }

    @Override
    public DiscountStrategy createPercentageDiscountStrategy(BigDecimal bigDecimal) {
        return new PercentageDiscountStrategy(bigDecimal);
    }

    @Override
    public DiscountStrategy createThresholdDiscountStrategy(BigDecimal subtotalThreshold, BigDecimal discountAmount) {
        return new ThresholdDiscountStrategy(subtotalThreshold, discountAmount);
    }

    @Override
    public ShippingStrategy createFlatRateShippingStrategy(BigDecimal rate) {
        return new FlatRateShippingStrategy(rate);
    }

    @Override
    public ShippingStrategy createFreeShippingOverThresholdStrategy(BigDecimal subtotalThreshold, BigDecimal rate) {
        return new FreeShippingOverThresholdStrategy(subtotalThreshold, rate);
    }

    @Override
    public ShippingStrategy createPerItemShippingStrategy(BigDecimal rate) {
        return new PerItemShippingStrategy(rate);
    }

}
