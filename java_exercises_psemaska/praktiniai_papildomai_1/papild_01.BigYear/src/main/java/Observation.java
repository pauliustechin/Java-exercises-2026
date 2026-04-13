
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Observation {

    private Map<Bird, Integer> birds;
    private final Scanner scanner;

    public Observation(Scanner scanner) {
        this.scanner = scanner;
        birds = new HashMap<>();
    }

    public void add() {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Name in Latin: ");
        String nameInLatin = scanner.nextLine();
        Bird bird = new Bird(name, nameInLatin);
        birds.put(bird, 0);
    }

    public void observation() {
        boolean found = false;
        System.out.print("Bird? ");
        String name = scanner.nextLine();
        for(Bird bird : birds.keySet()) {
            if(bird.getName().equals(name)) {
                birds.replace(bird, birds.get(bird) + 1);
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Not a bird!");
        }
    }

    public void all() {
        for(Bird bird : birds.keySet()) {
            System.out.println(bird.toString() + birds.get(bird) + " observations");
        }
    }

    public void one() {
        System.out.print("Bird? ");
        String name = scanner.nextLine();
        for(Bird bird : birds.keySet()) {
            if(bird.getName().equals(name)) {
                System.out.println(bird.toString() + birds.get(bird) + " observations");
                break;
            }
        }
    }



}
