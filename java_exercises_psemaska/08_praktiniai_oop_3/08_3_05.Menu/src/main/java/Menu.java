
import java.util.ArrayList;

public class Menu {

    private ArrayList<String> meals;

    public Menu() {
        this.meals = new ArrayList<>();
    }

    // implement the required methods here

    public void addMeal(String meal){
        boolean mealExists = false;

        if(!meals.isEmpty()){
            for(String mealFromList : meals){
                if(meal.equals(mealFromList)){
                    mealExists = true;
                }
            }
        }
        if(!mealExists){
            meals.add(meal);
        }
    }

    public void printMeals() {
        for(String meal : meals){
            System.out.println(meal);
        }
    }

    public void clearMenu(){
        meals.clear();
    }
}
