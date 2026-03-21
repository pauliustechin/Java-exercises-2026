import java.util.ArrayList;

public class Stack {

    ArrayList<String> items;

    public Stack() {
        this.items = new ArrayList<>();
    }

    public boolean isEmpty(){
        return items.isEmpty();
    }

    public void add(String value){
        items.add(0, value);
    }

    public ArrayList<String> values() {
        return items;
    }

    public String take() {
        String topMost = items.get(0);
        items.remove(0);
        return topMost;
    }
}
