package psem.supermarket.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class Cash {

    private BigDecimal value;
    private int quantity;

    public Cash(BigDecimal value, int quantity) {

        this.value = Objects.requireNonNull(value, "Value can't be null").round(new MathContext(2));
        if(quantity < 0) {
            throw new IllegalArgumentException("Value can't be lower than 0");
        }
        this.quantity = quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Value: " + value + ", quantity: " + quantity;
    }
}
