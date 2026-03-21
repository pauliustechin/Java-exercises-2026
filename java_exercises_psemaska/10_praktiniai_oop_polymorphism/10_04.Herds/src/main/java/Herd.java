import java.util.ArrayList;
import java.util.List;

public class Herd implements Movable{

    private List<Movable> movables = new ArrayList<>();

    public void addToHerd(Movable movable){
        movables.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for(Movable movable : movables){
            movable.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        // nesugalvojau, kaip cia praeit su string, jei einu per for loop  ir sout tada vistiek praso string grazinti
        // jei to string Ogranizem naudoju '\n', tada organizmo testai nepraeina
        return movables.toString();
    }
}
