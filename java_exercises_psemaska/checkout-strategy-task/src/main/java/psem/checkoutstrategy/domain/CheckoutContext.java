package psem.checkoutstrategy.domain;

import java.math.BigDecimal;
import java.util.List;

public final class CheckoutContext {
    private List<OrderItem> items;
    private CustomerProfile customerProfile;

    public CheckoutContext(List<OrderItem> items, CustomerProfile customerProfile) {

        if(items == null || items.isEmpty() || items.contains(null) || customerProfile == null) {
            throw new IllegalArgumentException();
        }
        this.items = items;
        this.customerProfile = customerProfile;
    }

    public List<OrderItem> getItems() {
        List<OrderItem> itemsToPass = items;
        return itemsToPass;
    }

    public CustomerProfile getCustomerProfile() {
        return customerProfile;
    }

    public BigDecimal getItemsSubtotal () {
        BigDecimal total = new BigDecimal(0);
        for(OrderItem item : items) {
            total = total.add(item.getLineSubtotal());
        }

        return total;
    }

    public int getTotalItemCount () {
        return items.stream()
                .mapToInt(item -> item.getQuantity())
                .sum();

    }
}
