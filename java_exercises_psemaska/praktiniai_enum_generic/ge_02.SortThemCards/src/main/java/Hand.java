import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hand implements Comparable<Hand> {

    private List<Card> hand = new ArrayList<>();

    public void add(Card card) {
        hand.add(card);
    }

    public void print() {
        for(Card card : hand) {
            System.out.println(card.toString());
        }
    }

    private int getHandSum() {
        return hand.stream()
                .mapToInt(hand -> hand.getValue())
                .sum();
    }

    public void sort() {
        hand.sort(new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                if(o1.getValue() != o2.getValue()) {
                    return o1.getValue() - o2.getValue();
                } else {
                    return o1.getSuit().ordinal() - o2.getSuit().ordinal();
                }
            }
        });
    }

    public void sortBySuit() {
        hand.sort((o1, o2) -> {
            if(o1.getSuit() != o2.getSuit()) {
                return o1.getSuit().ordinal() - o2.getSuit().ordinal();
            } else {
                return o1.getValue() - o2.getValue();
            }
        });
    }

    @Override
    public int compareTo(Hand o) {
        return this.getHandSum() - o.getHandSum();
    }

    @Override
    public String toString() {
        return "Hand{" +
                "hand=" + hand +
                '}';
    }
}
