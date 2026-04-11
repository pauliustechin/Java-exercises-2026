package psem.supermarket.service;

import psem.supermarket.exception.PayNotAcceptedException;
import psem.supermarket.exception.SoldOutException;
import psem.supermarket.model.Cash;
import psem.supermarket.model.Product;
import psem.supermarket.storage.ProductStorage;
import psem.supermarket.storage.ProductStorageImpl;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.*;

public class SupermarketServiceImpl implements SupermarketService{

    public static SupermarketServiceImpl supermarket;
    private ProductStorage productStorage = new ProductStorageImpl();
    private CashRegister cashRegister = new CashRegisterImpl();

    private SupermarketServiceImpl() {
    }

    public static SupermarketServiceImpl openSupermarket() {
        if(supermarket == null) {
            synchronized (SupermarketServiceImpl.class) {
                if(supermarket == null) {
                    supermarket = new SupermarketServiceImpl();
                }
            }
        }
        return supermarket;
    }

    @Override
    public void addCash(BigDecimal value, int quantity) {
        Cash cash = new Cash(value, quantity);
        cashRegister.addCash(cash);
    }

    @Override
    public void addProduct(String name, BigDecimal price, int quantity) {
        Product product = new Product(name, price, quantity);
        productStorage.addProduct(product);
    }

    @Override
    public Set getAllProducts() {
        return productStorage.getAllProducts();
    }

    @Override
    public List getCashInvetory() {
        return cashRegister.getCashInventory();
    }

    @Override
    public void beginPurchase(String name) {

        try {
            boolean found = false;
            for(Product product : productStorage.getAllProducts()) {
                if(product.getName().equalsIgnoreCase(name) && product.getQuantity() > 0) {
                    System.out.println("You are trying to buy " + product.getName() + ". You need to pay: " + product.getPrice());
                    beginPayment(product);
                    found = true;
                    break;
                } else if(product.getName().equals(name) && product.getQuantity() <= 0) {
                    throw new SoldOutException(product.getName() + " ran out of stock");
                }
            }
            if(!found) {
                System.out.println("Error: product is not available!");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void beginPayment(Product product) {
        BigDecimal change = proceedPayment(product.getPrice());
        boolean enoughChange = cashRegister.hasEnoughChange(change);
        if(enoughChange) {
            System.out.println("Here is your product: " + product.getName());
            if(change.compareTo(BigDecimal.ZERO) > 0) {
                System.out.println("Here is your change: ");
                cashRegister.returnChange(change);
                productStorage.reduceQty(product);
            } else {
                System.out.println("No change. You paid exact amount. Thank You!");
            }

        }
    }

    private BigDecimal proceedPayment(BigDecimal productPrice) {
        Scanner scanner = new Scanner(System.in);
        Double[] arr = {0.1, 0.5, 1.0, 2.0};
        List<Double> availableCash = Arrays.asList(arr);
        List<BigDecimal> paidMoney = new ArrayList<>();
        BigDecimal totalCash = BigDecimal.ZERO;
        while(true) {
            try{
                System.out.println("Provide bill or coin (accepted values: 0.1, 0.5, 1, 2, (empty to cancel operation)):");
                String input = scanner.nextLine();
                if(input.isEmpty()) {
                    throw new RuntimeException("Operation is canceled");
                }
                double providedCash = Double.parseDouble(input);

                if(!availableCash.contains(providedCash)) {
                    throw new PayNotAcceptedException("Value is not allowed, please try again: ");
                } else {
                    totalCash = totalCash.add(new BigDecimal(providedCash)).round(new MathContext(2));
                    paidMoney.add(new BigDecimal(providedCash));
                    if(totalCash.compareTo(productPrice) >= 0) {
                        System.out.println("You paid " + totalCash + " in total.");
                        // jei sumoka visa kieki, saukiam addMoney ir paduodam visus sumoketus coins, kad prideti
                        // prie turimu cash register.
                        addMoney(paidMoney);
                        return totalCash.subtract(productPrice);
                    } else {
                        BigDecimal leftToPay = productPrice.subtract(totalCash);
                        System.out.println("You paid " + totalCash + " in total.");
                        System.out.println("You still need to pay " + leftToPay);
                    }
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("Operation is canceled");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void addMoney(List<BigDecimal> paidMoney) {
        for(BigDecimal value : paidMoney) {
            for(Cash cash : cashRegister.getCashInventory()) {
                if(cash.getValue().compareTo(value) == 0) {
                    cash.setQuantity(cash.getQuantity() + 1);
                }
            }
        }
    }
}
