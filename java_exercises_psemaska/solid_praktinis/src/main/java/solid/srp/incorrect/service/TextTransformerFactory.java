package solid.srp.incorrect.service;

import solid.srp.incorrect.enums.TransformType;
import solid.srp.incorrect.transformertypes.LowerCaseTransformer;
import solid.srp.incorrect.transformertypes.SplitTransformer;
import solid.srp.incorrect.transformertypes.TextTransformerType;
import solid.srp.incorrect.transformertypes.UpperCaseTransformer;

public class TextTransformerFactory {
    public TextTransformerType createTextTransformer(TransformType transformType) {
        switch (transformType) {
            case UPPERCASE:
                return new UpperCaseTransformer();
            case LOWERCASE:
                return new LowerCaseTransformer();
            case SPLIT:
                return new SplitTransformer();
            default:
                throw new IllegalArgumentException("Transformation type is not supported: " + transformType);
        }
    }
}
