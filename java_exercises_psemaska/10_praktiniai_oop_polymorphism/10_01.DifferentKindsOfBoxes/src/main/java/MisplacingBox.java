import java.util.ArrayList;
import java.util.List;

public class MisplacingBox extends Box{

    private List<Item> items = new ArrayList<>();

    @Override
    public void add(Item item) {
        items.add(item);
    }

    @Override
    public boolean isInBox(Item item) {
        return false;
    }
}
