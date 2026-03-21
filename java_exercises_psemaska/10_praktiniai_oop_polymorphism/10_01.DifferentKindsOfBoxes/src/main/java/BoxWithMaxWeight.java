import java.util.ArrayList;

public class BoxWithMaxWeight extends Box{

    private int capacity;
    private ArrayList<Item> items = new ArrayList<>();

    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public void add(Item item) {
        if(capacity - item.getWeight() >= 0){
            capacity -= item.getWeight();
            items.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        if(!items.isEmpty()){
            for(Item i : items){
                if(i.equals(item)){
                    return true;
                }
            }
        }
        return false;
    }
}
