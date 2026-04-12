import lt.techin.warehouse.IdSequence;
import lt.techin.warehouse.StorageWarehouse;
import lt.techin.warehouse.test.AbstractStorageWarehouseContractTest;

public class StorageWarehouseContractTest extends AbstractStorageWarehouseContractTest {
    @Override
    public StorageWarehouse createWarehouse(IdSequence idSequence, IdSequence idSequence1, int i) {
        return new StorageWarehouseImpl(idSequence, idSequence1, i);
    }
}
