package psem.supermarket.storage;

import psem.supermarket.model.Product;
import java.util.HashSet;
import java.util.Set;

public class ProductStorageImpl implements ProductStorage{

    private Set<Product> products;

    public ProductStorageImpl() {
        products = new HashSet<>();
    }

    public void addProduct(Product product) {

        boolean found = false;

        for(Product productFromDb : products) {
            if(productFromDb.getName().equals(product.getName())) {
                productFromDb.setQuantity(productFromDb.getQuantity() + product.getQuantity());
                found = true;
                break;
            }
        }
        if(!found) {
            products.add(product);
        }
    }

    public void reduceQty(Product product) {
        for(Product productFromDb : products) {
            if(productFromDb.getName().equalsIgnoreCase(product.getName())) {
                productFromDb.setQuantity(productFromDb.getQuantity() - 1);
                break;
            }
        }

    }

    @Override
    public Set<Product> getAllProducts() {
        return products;
    }

}
