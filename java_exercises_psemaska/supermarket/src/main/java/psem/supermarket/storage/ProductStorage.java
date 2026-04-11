package psem.supermarket.storage;

import psem.supermarket.model.Product;
import java.util.Set;

public interface ProductStorage {

    void addProduct(Product product);
    void reduceQty(Product product);
    Set<Product> getAllProducts();
}
