import java.util.ArrayList;
import java.util.List;

public class Box implements Packable{

    private double capacity;
    private List<Packable> items = new ArrayList<>();

    public Box(double capacity) {
        this.capacity = capacity;
    }

    public void add(Packable packable){

        if(capacity >= packable.weight()){
            items.add(packable);
            capacity -= packable.weight();
        }
    }

    public double weight(){
        double totalWeight = 0;
        for(Packable packable : items){
            totalWeight += packable.weight();
        }
        return totalWeight;
    }

    @Override
    public String toString() {
        return "Box: " + items.size() + " items, total weight " + weight() + " kg";
    }
}
