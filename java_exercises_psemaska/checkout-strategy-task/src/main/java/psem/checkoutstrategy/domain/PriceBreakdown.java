package psem.checkoutstrategy.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class PriceBreakdown {

    private BigDecimal subtotal;
    private BigDecimal discountAmount;
    private BigDecimal shippingCost;
    private BigDecimal finalTotal;

    public PriceBreakdown(BigDecimal subtotal, BigDecimal discountAmount, BigDecimal shippingCost, BigDecimal finalTotal) {
        this.subtotal = subtotal;
        this.discountAmount = discountAmount;
        this.shippingCost = shippingCost;
        this.finalTotal = finalTotal;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public BigDecimal getFinalTotal() {
        return finalTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PriceBreakdown that = (PriceBreakdown) o;
        return Objects.equals(subtotal, that.subtotal) && Objects.equals(discountAmount, that.discountAmount) && Objects.equals(shippingCost, that.shippingCost) && Objects.equals(finalTotal, that.finalTotal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subtotal, discountAmount, shippingCost, finalTotal);
    }

    @Override
    public String toString() {
        return "PriceBreakdown{" +
                "subtotal=" + subtotal +
                ", discountAmount=" + discountAmount +
                ", shippingCost=" + shippingCost +
                ", finalTotal=" + finalTotal +
                '}';
    }
}
