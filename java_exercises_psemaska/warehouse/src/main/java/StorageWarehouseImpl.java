import lt.techin.warehouse.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class StorageWarehouseImpl extends StorageWarehouse {

    private final List<Customer> customers = new ArrayList<>();

    protected StorageWarehouseImpl(IdSequence idSequence, IdSequence idSequence1, int i) {
        super(idSequence, idSequence1, i);
    }

    @Override
    public int getTotalCapacity() {
        return super.totalCapacity;
    }

    @Override
    public int getReservedCapacity() {
        return  customers.stream()
                .mapToInt(customer -> customer.getReservedCapacity())
                .sum();
    }

    @Override
    public int getFreeReservationCapacity() {

        return getTotalCapacity() - getReservedCapacity();
    }

    @Override
    public int getUnusedPhysicalCapacity() {
                int remainingCapacitySum = customers.stream()
                .mapToInt(customer -> customer.getRemainingReservedCapacity())
                .sum();

        return remainingCapacitySum + getFreeReservationCapacity();
    }

    @Override
    public Customer registerCustomer(String s, int i) {
        if(s == null) {
            throw new NullPointerException();
        } else if(i > getFreeReservationCapacity()) {
            throw new CapacityExceededException("No more capacity.");
        }

        int customerId = customerIdSequence.nextId();
        Customer customer = new Customer(customerId, s, i);

        customers.add(customer);
        return customer;
    }

    @Override
    public Parcel createParcel(String s, int i) {
        if(s == null) {
            throw new NullPointerException();
        }

        int parcelId = parcelIdSequence.nextId();

        return new Parcel(parcelId, s, i);
    }

    @Override
    public void storeParcel(Customer customer, Parcel parcel) {

        if(customer == null || parcel == null) {
            throw new NullPointerException();
        }

        if(customer.getRemainingReservedCapacity() < parcel.getSize()) {
            throw new CapacityExceededException("Parcel is too big.");
        }

        customers.stream()
                .filter(cst -> cst == customer)
                                .findAny().orElseThrow(() -> new IllegalArgumentException());

        customer.addParcel(parcel);

    }

    @Override
    public Customer findCustomerById(int i) {
        return customers.stream()
                .filter(customer -> customer.getId() == i)
                .findAny().orElse(null);
    }

    @Override
    public boolean hasCustomer(int i) {
        Customer customer = findCustomerById(i);
        if(customer == null) {
            return false;
        }
        return true;
    }

    @Override
    public List<Customer> findCustomersBy(Predicate<Customer> predicate) {
        List<Customer> customersList = new ArrayList<>();
        for(Customer customer : customers) {
            if(predicate.test(customer)) {
                customersList.add(customer);
            }
        }

        return Collections.unmodifiableList(customersList);
    }
}
