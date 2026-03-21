import java.util.ArrayList;

public class Hold {

    private int maxWeight;
    private ArrayList<Suitcase> suitcases;

    public Hold(int maxWeight) {
        this.maxWeight = maxWeight;
        suitcases = new ArrayList<>();
    }

    public void addSuitcase(Suitcase suitcase) {
        int totalWeight = 0;

        if(!suitcases.isEmpty()){
            for(Suitcase suitcasesFromArray: suitcases) {
                totalWeight += suitcasesFromArray.totalWeight();
            }
            if(maxWeight >= (totalWeight + suitcase.totalWeight())){
                suitcases.add(suitcase);
            } else {
                System.out.println("Suitcase is too heavy.");
            }
        } else {
            if(maxWeight >= suitcase.totalWeight()){
                suitcases.add(suitcase);
            } else {
                System.out.println("Suitcase is too heavy.");
            }
        }
    }

    @Override
    public String toString() {
        if(suitcases.isEmpty()){
            return "no suitcases (0 kg)";
        } else if(suitcases.size() == 1){
            return suitcases.size() + " suitcase (" + suitcases.get(0).totalWeight() + " kg)";
        } else {
            int totalWeight = 0;
            for(Suitcase suitcase : suitcases){
                totalWeight += suitcase.totalWeight();
            }
            return suitcases.size() + " suitcases (" + totalWeight + " kg)";
        }
    }

    public void printItems(){
        if(!suitcases.isEmpty()){
            System.out.println("The suitcases in the hold contain the following items: ");
            for(Suitcase suitcase: suitcases){
                    suitcase.printItems();
            }
        }
    }

}
