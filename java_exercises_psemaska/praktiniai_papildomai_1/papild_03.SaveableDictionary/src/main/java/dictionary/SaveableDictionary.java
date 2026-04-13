package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class SaveableDictionary {

    private Map<String, String> words = new HashMap<>();
    private File myFile;
    private String fileName;

    public SaveableDictionary() {
    }

    public SaveableDictionary(String file) {
        myFile = new File(file);
        fileName = file;
    }

    public void add(String word, String translation) {
        boolean found = false;
        for(String w : words.keySet()) {
            if(w.equalsIgnoreCase(word) || words.get(w).equalsIgnoreCase(translation))
                found = true;
        }
        if(!found) {
            words.put(word, translation);
        }
    }

    public String translate(String word) {
        for(String w : words.keySet()) {
            if(w.equalsIgnoreCase(word)) {
                return words.get(w);
            } else if (words.get(w).equalsIgnoreCase(word)) {
                return w;
            }
        }
        return null;
    }

    public void delete(String word) {
        Iterator iterator = words.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            if(pair.getKey().equals(word) || pair.getValue().equals(word)) {
                iterator.remove();
            }
        }
    }

    public boolean load() {
        try (Scanner myReader = new Scanner(myFile)){
            while(myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] words = line.split(":");
                add(words[0], words[1]);
            }
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public boolean save() {
        try (FileWriter myWriter = new FileWriter(fileName)){
            String stringToAppend = "";
            for(String w : words.keySet()) {
                stringToAppend += (w + ":" + words.get(w) + "\n");
            }
            myWriter.write(stringToAppend);
            myWriter.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
