import java.util.HashMap;
import java.util.Map;

public class Abbreviations {

    private Map<String, String> abbreviations;

    public Abbreviations() {
        this.abbreviations = new HashMap<>();
    }

    public void addAbbreviation(String abbreviation, String explanation) {
        abbreviations.put(abbreviation, explanation);
    }

    public boolean hasAbbreviation(String abbreviation) {
        if(abbreviations.containsKey(abbreviation)) {
            return true;
        }
        return false;
    }

    public String findExplanationFor(String abbreviation) {
        if(!abbreviations.isEmpty()){
            for (String key : abbreviations.keySet()){
                if(key.equals(abbreviation)) {
                    return abbreviations.get(key);
                }
            }
        }

        return null;
    }
}
