

public class Main {

    public static void main(String[] args) {
        // You can test your program here

        BoxWithMaxWeight box = new BoxWithMaxWeight(10);
        box.add(new Item("Vaistai", 5));
        box.add(new Item("Kamuolys", 5));
        box.add(new Item("Kojines", 5));

        System.out.println(box.isInBox(new Item("Vaistai")));
        System.out.println(box.isInBox(new Item("Kamuolys")));
        System.out.println(box.isInBox(new Item("Kojines")));
    }
}
