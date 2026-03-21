import java.util.ArrayList;
import java.util.List;

public class OneItemBox extends Box{

    private List<Item> items = new ArrayList<>();

    public OneItemBox() {
    }

    @Override
    public void add(Item item) {
        if(items.isEmpty()){
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        if(!items.isEmpty()){
            if(items.get(0).equals(item)){
                return true;
            }
        }
        return false;
    }
}
