import lt.techin.philatelist.Philatelist;
import lt.techin.philatelist.PostStamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PhilatelistImpl implements Philatelist {

    private List<PostStamp> postStamps = new ArrayList<>();

    @Override
    public void addToCollection(PostStamp postStamp) {
        if(postStamp == null || postStamp.getName() == null || postStamp.getName().isEmpty()) {
            throw new IllegalArgumentException();
        }
        postStamps.add(postStamp);
    }

    @Override
    public int getNumberOfPostStampsInCollection() {
        if(!postStamps.isEmpty()) {
            return postStamps.size();
        }
        return 0;
    }

    @Override
    public void printAllPostStampNames() {
        postStamps.forEach(postStamp -> System.out.println(postStamp.getName()));
    }

    @Override
    public void printPostStampsWithPriceGreaterThan(double v) {
        postStamps.stream()
                .filter(postStamp -> postStamp.getMarketPrice() > v)
                .forEach(postStamp -> System.out.println(postStamp.getName()));
    }

    @Override
    public boolean isPostStampInCollection(PostStamp postStamp) {
        if(postStamp == null || postStamp.getName() == null) {
            throw new IllegalArgumentException();
        }
        return postStamps.contains(postStamp);
    }

    @Override
    public boolean isPostStampWithNameInCollection(String s) {
        if(s == null || s.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return postStamps.stream().anyMatch(postStamp -> postStamp.getName().equals(s));
    }

    @Override
    public double calculateTotalMarketPrice() {
        return postStamps.stream().mapToDouble(postStamp -> postStamp.getMarketPrice()).sum();
    }

    @Override
    public double getAveragePostStampPrice() {
        return postStamps.stream().mapToDouble(postStamp -> postStamp.getMarketPrice()).average().orElse(0.0);
    }

    @Override
    public PostStamp getTheMostExpensivePostStampByMarketValue() {
        return postStamps.stream().max(Comparator.comparing(postStamp -> postStamp.getMarketPrice())).orElse(null);
    }

    @Override
    public List<PostStamp> findPostStampsByNameContaining(String s) {
        if(s == null || s.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return postStamps.stream()
                .filter(postStamp -> postStamp.getName().contains(s))
                .toList();
    }

    @Override
    public List<PostStamp> getSortedPostStampsByName() {
        return postStamps.stream()
                .sorted(Comparator.comparing(postStamp -> postStamp.getName()))
                .toList();
    }
}
