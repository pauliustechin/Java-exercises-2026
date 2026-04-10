package solid.srp.incorrect.transformertypes;

public class LowerCaseTransformer implements TextTransformerType {
    @Override
    public String transform(String text) {
        return text.toLowerCase();
    }
}
