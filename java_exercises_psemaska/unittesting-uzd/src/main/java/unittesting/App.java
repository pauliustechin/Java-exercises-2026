package unittesting;

public class App {

    public static void main(String[] args) {
        try {
            SpamFilter sf = new SpamFilter(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
