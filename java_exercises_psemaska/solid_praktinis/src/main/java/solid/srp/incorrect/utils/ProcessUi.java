package solid.srp.incorrect.utils;

import solid.srp.incorrect.transformertypes.TextTransformerType;
import solid.srp.incorrect.enums.TransformType;
import solid.srp.incorrect.service.TextTransformerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessUi {

    private TextTransformerFactory factory = new TextTransformerFactory();

    public void processUi() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;

            System.out.print("$ ");

            while ((input = reader.readLine()) != null) {
                int colonIdx = input.indexOf(':');
                TransformType transformType = TransformType.valueOf(input.substring(0, colonIdx).toUpperCase());
                String text = input.substring(colonIdx + 1);

                TextTransformerType textTransformer = factory.createTextTransformer(transformType);
                String transformed = textTransformer.transform(text);
                System.out.println("Transformed:" + transformed);

                System.out.print("$ ");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to present user interface", e);
        }
    }
}
