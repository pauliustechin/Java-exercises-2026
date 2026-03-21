
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Item> items = new ArrayList<>();

        while(true){
            System.out.println("Identifier? (empty will stop)");
            String identifier = scanner.nextLine();
            if(identifier.isEmpty()){
                break;
            }
            System.out.println("Name? (empty will stop)");
            String name = scanner.nextLine();
            if(name.isEmpty()){
                break;
            }

            boolean itemExists = false;

            if(items.isEmpty()){
                items.add(new Item(identifier, name));
                itemExists = true;
            } else {
                for(Item item : items){
                    if(item.equals(new Item(identifier, name))){
                        itemExists = true;
                        break;
                    }
                }
            }

            if(!itemExists){
                items.add(new Item(identifier, name));
            }

        }

        for(Item item : items){
            System.out.println(item);
        }
    }
}
