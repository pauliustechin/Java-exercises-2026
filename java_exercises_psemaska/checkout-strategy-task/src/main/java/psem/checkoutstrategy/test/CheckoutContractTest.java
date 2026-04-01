package psem.checkoutstrategy.test;

import academy.tasks.checkoutstrategy.service.CheckoutCalculator;
import academy.tasks.checkoutstrategy.service.CheckoutComponentFactory;
import academy.tasks.checkoutstrategy.test.AbstractCheckoutContractTest;
import psem.checkoutstrategy.service.CheckoutCalculatorImpl;
import psem.checkoutstrategy.service.CheckoutComponentFactoryImpl;

public class CheckoutContractTest extends AbstractCheckoutContractTest {

    @Override
    public CheckoutCalculator createCheckoutCalculator() {
        return new CheckoutCalculatorImpl();
    }

    @Override
    public CheckoutComponentFactory createCheckoutComponentFactory() {
        return new CheckoutComponentFactoryImpl();
    }
}
