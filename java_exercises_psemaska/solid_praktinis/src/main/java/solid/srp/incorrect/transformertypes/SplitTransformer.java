package solid.srp.incorrect.transformertypes;

import java.util.Arrays;

public class SplitTransformer implements TextTransformerType{

    @Override
    public String transform(String text) {
        String[] splitString = text.split("");
        StringBuilder sb = new StringBuilder();
        Arrays.stream(splitString).forEach(letter -> sb.append(" ").append(letter));
        return sb.toString();
    }
}
