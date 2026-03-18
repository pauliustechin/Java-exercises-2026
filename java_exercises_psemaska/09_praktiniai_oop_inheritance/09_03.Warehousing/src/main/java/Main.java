

public class Main {

    public static void main(String[] args) {
        // here you can write code to test your classes

        System.out.println("*********** PART 1 **************");
        System.out.println();

        ProductWarehouse juice1 = new ProductWarehouse("Juice", 1000.0);
        juice1.addToWarehouse(1000.0);
        juice1.takeFromWarehouse(11.3);
        juice1.addToWarehouse(1.0);
        System.out.println(juice1.getName());
        System.out.println(juice1);

        System.out.println();
        System.out.println("*********** PART 2 Warehouse with history **************");
        System.out.println();

        ProductWarehouseWithHistory juice2 = new ProductWarehouseWithHistory("Juice", 1000, 500);
        System.out.println(juice2);
        juice2.takeFromWarehouse(11.3);
        System.out.println(juice2.getName());
        juice2.addToWarehouse(1.0);
        System.out.println(juice2);

//        System.out.println(juice2.history());
        System.out.println();
        System.out.println("Analysis: ");
        juice2.printAnalysis();
    }




}
