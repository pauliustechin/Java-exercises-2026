import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // test your code here

        Card first = new Card(2, Suit.DIAMOND);
        Card second = new Card(14, Suit.SPADE);
        Card third = new Card(12, Suit.HEART);
        Card fourth = new Card(2, Suit.SPADE);

        List<Card> cards = new ArrayList<>();
        cards.add(first);
        cards.add(second);
        cards.add(third);
        cards.add(fourth);

        Hand hand = new Hand();
        hand.add(first);
        hand.add(second);
        hand.add(third);
        hand.add(fourth);

        hand.print();
        System.out.println("~~~~~~~~~~~~~~~~~~~");
        hand.sort();
        hand.print();

        System.out.println("~~~~~~~~~~~~~~~~~~~~");
        Collections.sort(cards, new SortBySuit());
        cards.stream().forEach(card -> System.out.println(card));


    }
}
