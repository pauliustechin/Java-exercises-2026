public class Bird {

    private String name;
    private String nameInLatin;

    public Bird(String name, String nameInLatin) {
        this.name = name;
        this.nameInLatin = nameInLatin;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + nameInLatin + "): ";
    }
}
