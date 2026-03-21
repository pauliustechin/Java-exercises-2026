import java.util.ArrayList;

public class Suitcase {

    private ArrayList<Item> items;
    private int maxWeight;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {

        int totalWeight = 0;

        if(!items.isEmpty()){
            for(Item itemFromArray: items) {
                totalWeight += itemFromArray.getWeight();
            }
            if(maxWeight >= (totalWeight + item.getWeight())){
                items.add(item);
            } else {
                System.out.println("Item is too heavy.");
            }
        } else {
            if(maxWeight >= item.getWeight()){
                items.add(item);
            } else {
                System.out.println("Item is too heavy.");
            }
        }
    }

    public int totalWeight(){

        int totalWeight = 0;

        if(!items.isEmpty()){
            for(Item item : items){
                totalWeight += item.getWeight();
            }
            return totalWeight;
        }
        return 0;
    }

    @Override
    public String toString() {

        if(items.isEmpty()){
            return "no items (0 kg)";
        } else if(items.size() == 1){
            return items.size() + " item (" + totalWeight() + " kg)";
        } else {
            return items.size() + " items (" + totalWeight() + " kg)";
        }
    }

    public void printItems() {
        if(!items.isEmpty()){
            System.out.println("The suitcase contains the following items: ");
            for(Item item : items){
                System.out.println(item.getName() + " (" + item.getWeight() + " kg)");
            }
        }
    }

    public Item heaviestItem() {
        if(items.isEmpty()){
            return null;
        } else {
            Item heaviestItem = items.get(0);
            for(int i = 1; i < items.size(); i++){
                if(heaviestItem.getWeight() < items.get(i).getWeight()){
                    heaviestItem = items.get(i);
                }
            }
            return heaviestItem;
        }
    }


}
