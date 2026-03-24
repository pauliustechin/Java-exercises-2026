import java.util.HashMap;

public class IOU {

    private HashMap<String, Double> hashMap;

    public IOU() {
        this.hashMap = new HashMap<>();
    }

    public void setSum(String toWhom, double amount) {
        for(String name : hashMap.keySet()) {
            if(name.equals(toWhom)) {
                hashMap.put(name, amount + hashMap.get(name));
            }
        }
        hashMap.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom) {
        for(String name : hashMap.keySet()) {
            if(name.equals(toWhom)) {
                return hashMap.get(name);
            }
        }
        return 0;
    }
}
