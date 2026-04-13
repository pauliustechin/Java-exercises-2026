import java.util.regex.Pattern;

public class Checker {

    // su regex
    public boolean isDayOfWeek(String string) {
        for(Days day : Days.values()) {
            if(day.name().matches(string.toUpperCase())) return true;
        }
        return false;
    }

    public boolean allVowels(String string) {

        boolean found;
        String[] splitString = string.split("");

        for(String letter : splitString) {
            found = false;
            for(Vowels vowel : Vowels.values()) {
                if(vowel.name().matches(letter.toUpperCase())) {
                    found = true;
                    break;
                }
            }
            if(!found) return false;
        }
        return true;
    }

    public boolean timeOfDay(String string) {
        return string.matches("^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$");
    }

}
