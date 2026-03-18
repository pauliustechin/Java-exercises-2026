import java.util.ArrayList;

public class ChangeHistory {

    private ArrayList<Double> inventory = new ArrayList<>();

    public void add(double status) {
        inventory.add(status);
    }

    public void clear() {
        inventory.clear();
    }

    public double maxValue() {

        if(!inventory.isEmpty()){
            double maxValue = inventory.get(0);
            for(double val : inventory){
                if(val > maxValue) {
                    maxValue = val;
                }
            }
            return maxValue;
        }
        return 0;
    }

    public double minValue() {

        if(!inventory.isEmpty()){
            double minValue = inventory.get(0);
            for(double val : inventory){
                if(val < minValue) {
                    minValue = val;
                }
            }
            return minValue;
        }
        return 0;
    }

    public double average() {

        if(!inventory.isEmpty()){
            double size = inventory.size();
            double sum = 0;
            for(double val : inventory){
                sum += val;
            }
            return sum / size;
        }
        return 0;
    }

    @Override
    public String toString() {
        return inventory.toString();
    }
}
