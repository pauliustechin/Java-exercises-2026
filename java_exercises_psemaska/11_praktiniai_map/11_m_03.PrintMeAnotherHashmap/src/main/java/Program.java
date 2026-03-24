
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        // Test your program here!
    }

    public static void printValues(HashMap<String, Book> hashMap) {
        for(String s : hashMap.keySet()) {
            System.out.println(hashMap.get(s));
        }
    }

    public static void printValueIfNameContains(HashMap<String, Book> hashMap, String text) {
        for(String s : hashMap.keySet()) {
            if(hashMap.get(s).getName().contains(text)){
                System.out.println(hashMap.get(s));
            }
        }
    }



}
