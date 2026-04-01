package psem.checkoutstrategy.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class OrderItem {
    private String sku;
    private String name;
    private BigDecimal unitPrice;
    private int quantity;

    public OrderItem(String sku, String name, BigDecimal unitPrice, int quantity) {

        if(sku == null || name == null || unitPrice.intValue() < 0 || quantity < 1) {
            throw new IllegalArgumentException();
        }

        this.sku = sku;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getLineSubtotal() {
        return unitPrice.multiply(new BigDecimal(2));
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return quantity == orderItem.quantity && Objects.equals(sku, orderItem.sku) && Objects.equals(name, orderItem.name) && Objects.equals(unitPrice, orderItem.unitPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, name, unitPrice, quantity);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", quantity=" + quantity +
                '}';
    }
}
