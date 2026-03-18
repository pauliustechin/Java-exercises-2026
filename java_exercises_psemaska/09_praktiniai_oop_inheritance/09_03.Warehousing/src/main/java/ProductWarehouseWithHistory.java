public class ProductWarehouseWithHistory extends ProductWarehouse {

    private ChangeHistory changeHistory = new ChangeHistory();

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance) {
        super(productName, capacity);
        setBalance(initialBalance);
        changeHistory.add(initialBalance);
    }

    public String history() {
        return changeHistory.toString();
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public void addToWarehouse(double amount) {
        super.addToWarehouse(amount);
        changeHistory.add(getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double value = super.takeFromWarehouse(amount);
        changeHistory.add(getBalance());
        return value;
    }

    public void printAnalysis() {
        System.out.println("Product: " + getName() + '\n'
                + "History: " + changeHistory + '\n'
                + "Largest amount of product: " + changeHistory.maxValue() + '\n'
                + "Smallest amount of product: " + changeHistory.minValue() + '\n'
                + "Average: " + changeHistory.average());
    }

}
