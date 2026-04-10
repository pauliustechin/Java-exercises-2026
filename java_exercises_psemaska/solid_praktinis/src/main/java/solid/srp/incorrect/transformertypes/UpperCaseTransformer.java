package solid.srp.incorrect.transformertypes;

public class UpperCaseTransformer implements TextTransformerType {

    @Override
    public String transform(String text) {
        return text.toUpperCase();
    }
}
