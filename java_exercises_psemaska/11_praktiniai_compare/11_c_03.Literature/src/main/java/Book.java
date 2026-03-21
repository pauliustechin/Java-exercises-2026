import java.util.Comparator;

public class Book implements Comparable<Book> {

    private String name;
    private int recommendedAge;

    public Book(String name, int recommendedAge) {
        this.name = name;
        this.recommendedAge = recommendedAge;
    }

    public String getName() {
        return name;
    }

    public int getRecommendedAge() {
        return recommendedAge;
    }

    @Override
    public String toString() {
        return name + " (recommended for " + recommendedAge + " year-olds or older)";
    }

    @Override
    public int compareTo(Book o) {
        int ageCompare = Integer.compare(this.recommendedAge, o.recommendedAge);
        if(ageCompare == 0) return this.name.compareTo(o.name);
        return ageCompare;
    }
}
