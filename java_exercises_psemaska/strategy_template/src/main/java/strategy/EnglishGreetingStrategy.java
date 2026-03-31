package strategy;

public class EnglishGreetingStrategy implements GreetingLanguageStrategy{

    @Override
    public String getGreetingString() {
        return "Hello";
    }
}
