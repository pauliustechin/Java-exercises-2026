import lt.techin.warehouse.IdSequence;

public class IdSequenceImpl implements IdSequence {

    private static int currentId;
    private int id;

    public IdSequenceImpl() {
        this.id = ++currentId;
    }

    @Override
    public int nextId() {
        return id;
    }
}
