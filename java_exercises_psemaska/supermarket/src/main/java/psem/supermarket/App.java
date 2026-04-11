package psem.supermarket;

import psem.supermarket.model.Cash;
import psem.supermarket.model.Product;
import psem.supermarket.service.SupermarketService;
import psem.supermarket.service.SupermarketServiceImpl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        SupermarketService supermarketService = SupermarketServiceImpl.openSupermarket();
        Scanner scanner = new Scanner(System.in);

        supermarketService.addCash(new BigDecimal(1), 20);
        supermarketService.addCash(new BigDecimal(0.1), 30);
        supermarketService.addCash(new BigDecimal(0.5), 30);
        supermarketService.addCash(new BigDecimal(2), 15);

        supermarketService.addProduct("Milk", new BigDecimal(1.5), 1);
        supermarketService.addProduct("Bread", new BigDecimal(2), 20);
        supermarketService.addProduct("Apple", new BigDecimal(0.5), 40);


        System.out.println("WELCOME TO SUPERMARKET!");
        System.out.println();

        while(true) {

            Set<Product> products = supermarketService.getAllProducts();
            List<Cash> cash = supermarketService.getCashInvetory();

            System.out.println("Initial product inventory:");
            products.stream().forEach(product -> System.out.println(product));
            System.out.println();

            System.out.println("Initial cash inventory:");
            cash.stream().forEach(c -> System.out.println(c));
            System.out.println();

            System.out.print("What would you like to buy? Type in the name of the desired product: ");
            String productName = scanner.nextLine();

            supermarketService.beginPurchase(productName);

            System.out.print("Would you like to continue (y/n)? ");
            String continueShopping = scanner.nextLine();
            if(!continueShopping.equalsIgnoreCase("y")) {
                scanner.close();
                break;
            }
        }
    }
}