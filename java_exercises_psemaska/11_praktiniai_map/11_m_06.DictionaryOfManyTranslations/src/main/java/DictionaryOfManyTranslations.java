import java.util.ArrayList;
import java.util.HashMap;

public class DictionaryOfManyTranslations {

    private HashMap<String, ArrayList<String>> dictionary = new HashMap<>();

    public void add(String word, String translation) {

        boolean found = false;

        if(dictionary.isEmpty()) {
            ArrayList<String> translations = new ArrayList<>();
            translations.add(translation);
            dictionary.put(word, translations);
        }
        else {
            for (String w : dictionary.keySet()) {
                if(w.equals(word)) {
                    ArrayList<String> arrayToUpdate = dictionary.get(word);
                    arrayToUpdate.add(translation);
                    dictionary.put(word, arrayToUpdate);
                    found = true;
                    break;
                }
            }
            if(!found) {
                ArrayList<String> translations = new ArrayList<>();
                translations.add(translation);
                dictionary.put(word, translations);
            }
        }

    }

    public ArrayList<String> translate(String word) {
        if(!dictionary.isEmpty()) {
            for(String w : dictionary.keySet()) {
                if(w.equals(word)) {
                    return dictionary.get(w);
                }
            }
        }
        return new ArrayList<>();
    }

    public void remove(String word) {
        if(!dictionary.isEmpty()) {
            for(String w : dictionary.keySet()) {
                if(w.equals(word)) {
                    dictionary.remove(word);
                    break;
                }
            }
        }
    }
}
