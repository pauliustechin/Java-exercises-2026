package psem.supermarket.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

public interface SupermarketService {

    void addCash(BigDecimal value, int qunatity);
    void addProduct(String name, BigDecimal price, int quantity);
    Set getAllProducts();
    List getCashInvetory();
    void beginPurchase(String name);

}
