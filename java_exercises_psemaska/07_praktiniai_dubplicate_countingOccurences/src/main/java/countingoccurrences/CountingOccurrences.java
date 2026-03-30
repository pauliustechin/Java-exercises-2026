package countingoccurrences;

import java.util.HashMap;
import java.util.Map;

public class CountingOccurrences {

    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'd', 'a', 'c', 'd', 'e', 'e', 'f', 'd'};
        printOccurrences(chars);
    }

    public static void printOccurrences(char[] chars){
        Map<Character, Integer> charCount = new HashMap<>();

        for(Character ch : chars) {
            if(charCount.containsKey(ch)){
                charCount.put(ch, charCount.get(ch) + 1);
            } else {
                charCount.put(ch, 1);
            }
        }

        System.out.println("The occurrences of each letter are: ");
        System.out.print("| ");
        for(Character ch : charCount.keySet()) {
            System.out.print(charCount.get(ch) + ":" + ch + " | ");
        }
    }

}
