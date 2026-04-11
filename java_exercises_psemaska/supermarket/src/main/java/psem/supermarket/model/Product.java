package psem.supermarket.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private String name;
    private BigDecimal price;
    private double quantity;

    public Product(String name, BigDecimal price, double quantity) {

        this.name = Objects.requireNonNull(name, "Product name can't be null");
        this.price = Objects.requireNonNull(price, "Product price can't be null");
        if(quantity < 0) {
            throw new IllegalArgumentException("Quantity can't be lower than 0");
        }
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return name.toUpperCase() + ", quantity: " + quantity;
    }
}
